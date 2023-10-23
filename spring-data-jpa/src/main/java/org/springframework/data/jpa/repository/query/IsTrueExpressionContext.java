/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository.query;

/**
 * Represents an {@literal IS TRUE} clause in a query.
 *
 * @author Greg Turnquist
 */
class IsTrueExpressionContext implements ExpressionContext {

    private final ExpressionContext expression;

    public IsTrueExpressionContext(ExpressionContext expression) {
        this.expression = expression;
    }

    @Override
    public String joins(String alias) {
        return expression.joins(alias);
    }

    @Override
    public String criteria(String alias) {
        return expression.criteria(alias) + " IS TRUE";
    }
}
