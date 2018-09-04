package ru.clean.process.api.dto.query.impl;

import ru.clean.process.api.dto.query.ComplexCondition;
import ru.clean.process.api.dto.query.Condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Abstract class to hold complex search conditions
 * Has two extension classes (and/or conditions)
 */
public abstract class ComplexConditionImpl implements ComplexCondition {
    private List<Condition> conditions;

    @Override
    public List<Condition> getConditions() {
        return conditions;
    }

    ComplexConditionImpl(List<Condition> conditions) {
        this.conditions = conditions == null ? new ArrayList<>() : new ArrayList<>(conditions);
    }

    ComplexConditionImpl(Condition... conditions) {
        this.conditions = conditions == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(conditions));
    }

    /**
     * Factory method to create And Complex condition
     */
    public static And and(Condition... conditions) {
        return new And(conditions);
    }

    /**
     * Factory method to create And Complex condition
     */
    public static And and(List<Condition> conditions) {
        return new And(conditions);
    }

    /**
     * Factory method to create Or Complex condition
     */
    public static Or or(Condition... conditions) {
        return new Or(conditions);
    }

    /**
     * Factory method to create Or Complex condition
     */
    public static Or or(List<Condition> conditions) {
        return new Or(conditions);
    }

    static class And extends ComplexConditionImpl {
        And(List<Condition> conditions) {
            super(conditions);
        }

        And(Condition... conditions) {
            super(conditions);
        }
    }

    static class Or extends ComplexConditionImpl {
        Or(List<Condition> conditions) {
            super(conditions);
        }

        Or(Condition... conditions) {
            super(conditions);
        }
    }
}
