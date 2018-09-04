package ru.clean.process.webmodule.controllers.query;

import org.apache.olingo.odata2.api.uri.expression.FilterExpression;
import ru.clean.process.api.dto.query.Condition;
import ru.clean.process.api.dto.query.QueryHolder;
import ru.clean.process.api.exceptions.SearchServiceException;
import ru.clean.process.webmodule.controllers.query.converter.ConditionConverter;

/**
 * QueryHolder implementation adapter for OData
 */
public class ODataQueryHolder implements QueryHolder {
    private FilterExpression filterExpression;

    public ODataQueryHolder(FilterExpression filterExpression) {
        this.filterExpression = filterExpression;
    }

    @Override
    public Condition getCondition() throws SearchServiceException {
        return ConditionConverter.from(filterExpression).getCondition();
    }
}
