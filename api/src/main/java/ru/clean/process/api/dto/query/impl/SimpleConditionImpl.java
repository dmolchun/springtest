package ru.clean.process.api.dto.query.impl;

import ru.clean.process.api.dto.query.Operator;
import ru.clean.process.api.dto.query.SimpleCondition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Condition implementation for simple search condition
 */
public class SimpleConditionImpl implements SimpleCondition {
    private String fieldName;
    private Operator operator;
    private List<Serializable> values = new ArrayList<>();

    public SimpleConditionImpl(String fieldName, Operator operator) {
        this.fieldName = fieldName;
        this.operator = operator;
    }

    public SimpleConditionImpl(String fieldName, Operator operator, List<Serializable> values) {
        this.fieldName = fieldName;
        this.operator = operator;
        if (values != null) {
            this.values.addAll(values);
        }
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public Operator getOperator() {
        return operator;
    }

    @Override
    public List<Serializable> getValues() {
        return values;
    }
}
