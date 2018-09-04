package ru.clean.process.webmodule.controllers.query.converter;

import org.apache.olingo.odata2.api.uri.expression.*;
import org.springframework.lang.NonNull;
import ru.clean.process.api.dto.query.ComplexCondition;
import ru.clean.process.api.dto.query.Condition;
import ru.clean.process.api.dto.query.Operator;
import ru.clean.process.api.dto.query.SimpleCondition;
import ru.clean.process.api.dto.query.impl.ComplexConditionImpl;
import ru.clean.process.api.dto.query.impl.SimpleConditionImpl;
import ru.clean.process.api.exceptions.SearchServiceException;

import java.util.Arrays;

/**
 * Condition converter for OData
 */
public class ConditionConverter {
    private CommonExpression expression;

    private ConditionConverter(CommonExpression expression) {
        this.expression = expression;
    }

    /**
     * Fabric method for OData condition converter
     */
    public static ConditionConverter from(@NonNull FilterExpression expression) {
        return new ConditionConverter(expression.getExpression());
    }

    /**
     * Transforms OData FilterExpression to ru.clean.process.api.dto.query.Condition
     */
    public Condition getCondition() throws SearchServiceException {
        ExpressionKind expressionKind = expression.getKind();
        if (expression.getKind() == ExpressionKind.BINARY) {
            return convertBinary((BinaryExpression) expression);
        }
        throw new SearchServiceException("Unsupported expression kind: {}", expressionKind);
    }

    /**
     * Converts OData BinaryExpression to ru.clean.process.api.dto.query.Condition
     */
    private Condition convertBinary(BinaryExpression expression) throws SearchServiceException {
        CommonExpression left = expression.getLeftOperand();
        CommonExpression right = expression.getRightOperand();
        BinaryOperator operator = expression.getOperator();
        ExpressionKind leftKind = left.getKind();
        switch (leftKind) {
            case BINARY:
                return convertComplex((BinaryExpression) left, (BinaryExpression) right, operator);
            case PROPERTY:
                return convertSimple((PropertyExpression) left, right, operator);
            default:
                throw new SearchServiceException("Unsupported expression kind: {}", leftKind);
        }
    }

    /**
     * Converts OData BinaryExpressions to ru.clean.process.api.dto.query.ComplexCondition
     */
    private ComplexCondition convertComplex(BinaryExpression left, BinaryExpression right, BinaryOperator operator) throws SearchServiceException {
        if (operator == BinaryOperator.OR) {
            return ComplexConditionImpl.or(convertBinary(left), convertBinary(right));
        }
        return ComplexConditionImpl.and(convertBinary(left), convertBinary(right));
    }

    /**
     * Converts OData expressions to ru.clean.process.api.dto.query.SimpleCondition
     */
    private SimpleCondition convertSimple(PropertyExpression left, CommonExpression right, BinaryOperator operator) throws SearchServiceException {
        ExpressionKind rightKind = right.getKind();
        if (rightKind == ExpressionKind.LITERAL) {
            return new SimpleConditionImpl(left.getUriLiteral(), convertOperator(operator), Arrays.asList(right.getUriLiteral()));
        }
        throw new SearchServiceException("Unsupported expression kind: {}", rightKind);
    }

    private Operator convertOperator(BinaryOperator operator) {
        return Operator.valueOf(operator.name());
    }
}
