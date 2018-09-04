package ru.clean.process.api.dto.query;

import java.util.List;

/**
 * Base interface for complex condition
 */
public interface ComplexCondition extends Condition {
    /**
     * Conditions included
     */
    List<Condition> getConditions();

    @Override
    default ConditionType getType() {
        return ConditionType.COMPLEX;
    }
}
