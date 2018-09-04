package ru.clean.process.api.dto.query;

import java.io.Serializable;
import java.util.List;

/**
 * Base interface for simple condition
 */
public interface SimpleCondition extends Condition {
    /**
     * Field name
     */
    String getFieldName();

    /**
     * Condition operator
     */
    Operator getOperator();

    /**
     * Field values for filter
     */
    List<Serializable> getValues();

    @Override
    default ConditionType getType() {
        return ConditionType.SIMPLE;
    }
}
