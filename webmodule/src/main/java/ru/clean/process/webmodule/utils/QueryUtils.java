package ru.clean.process.webmodule.utils;

import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.uri.UriParser;
import org.apache.olingo.odata2.api.uri.expression.FilterExpression;
import org.springframework.util.StringUtils;

import java.util.Map;

public class QueryUtils {
    /**
     * Converts RequestParam to OData DFilterExpressions
     * @throws ODataException
     */
    public static FilterExpression parseFilter(Map<String, String> params) throws ODataException {
        String filterString = params.get("$filter");
        return StringUtils.isEmpty(filterString) ? null : UriParser.parseFilter(null, null, filterString);
    }
}
