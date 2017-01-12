// Copyright 2017 Yahoo Inc.
// Licensed under the terms of the Apache license. Please see LICENSE.md file distributed with this work for terms.
package com.yahoo.bard.rfc.table;

import com.yahoo.bard.rfc.data.dimension.DimensionColumn;
import com.yahoo.bard.webservice.data.dimension.Dimension;
import com.yahoo.bard.webservice.druid.model.query.Granularity;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Table is a schema with dimension columns.
 */
public interface Table extends HasName {

    Schema getSchema();

    /**
     * Convenience getter for table granularity
     *
     * @return The granularity of the underlying schema
     */
    default Granularity getGranularity() {
        return getSchema().getGranularity();
    }

    /**
     * Getter for set of dimensions.
     *
     * @return Set of Dimension
     */
    default Set<Dimension> getDimensions() {
        return getSchema().getColumns(DimensionColumn.class).stream()
                .map(DimensionColumn::getDimension)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
