/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.parser.context.selectitem;

import com.google.common.base.Optional;
import io.shardingsphere.core.constant.AggregationType;
import io.shardingsphere.core.parsing.parser.exception.SQLParsingUnsupportedException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Aggregation distinct select item.
 *
 * @author panjuan
 */
@Getter
@EqualsAndHashCode
@ToString
public final class AggregationDistinctSelectItem extends DistinctSelectItem {
    
    private final AggregationType type;
    
    public AggregationDistinctSelectItem(final AggregationType type, final String distinctColumn, final Optional<String> alias) {
        super(distinctColumn, alias);
        this.type = type;
        // TODO :panjuan gets correct parsing result and supports this syntax
        throw new SQLParsingUnsupportedException(type.toString() + "(DISTINCT)");
    }
}
