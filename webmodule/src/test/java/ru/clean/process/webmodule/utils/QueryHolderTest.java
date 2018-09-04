package ru.clean.process.webmodule.utils;

import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.uri.expression.FilterExpression;
import org.junit.Assert;
import org.junit.Test;
import ru.clean.process.api.dto.query.*;
import ru.clean.process.api.exceptions.SearchServiceException;
import ru.clean.process.webmodule.controllers.query.converter.ConditionConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryHolderTest extends Assert {

    @Test
    public void parseFilterTest() throws ODataException, SearchServiceException {
        Map<String, String> params = new HashMap<>();
        params.put("$filter", "Id eq 1111 or Name eq 272222 and Role eq 'role'");
        FilterExpression expression = QueryUtils.parseFilter(params);
        Condition condition = ConditionConverter.from(expression).getCondition();
        assertEquals(ConditionType.COMPLEX, condition.getType());
        List<Condition> conditions = ((ComplexCondition) condition).getConditions();
        assertEquals(2, conditions.size());
        assertEquals(ConditionType.SIMPLE, conditions.get(0).getType());
        SimpleCondition simpleCondition = (SimpleCondition) conditions.get(0);
        assertEquals("Id", simpleCondition.getFieldName());
        assertEquals(Operator.EQ, simpleCondition.getOperator());
        assertEquals("1111", simpleCondition.getValues().get(0));
        assertEquals(ConditionType.COMPLEX, conditions.get(1).getType());
        ComplexCondition complexCondition = (ComplexCondition) conditions.get(1);
        assertEquals(2, complexCondition.getConditions().size());
        simpleCondition = (SimpleCondition) complexCondition.getConditions().get(0);
        assertEquals("Name", simpleCondition.getFieldName());
        assertEquals(Operator.EQ, simpleCondition.getOperator());
        assertEquals("272222", simpleCondition.getValues().get(0));
        simpleCondition = (SimpleCondition) complexCondition.getConditions().get(1);
        assertEquals("Role", simpleCondition.getFieldName());
        assertEquals(Operator.EQ, simpleCondition.getOperator());
        assertEquals("'role'", simpleCondition.getValues().get(0));
    }
}
