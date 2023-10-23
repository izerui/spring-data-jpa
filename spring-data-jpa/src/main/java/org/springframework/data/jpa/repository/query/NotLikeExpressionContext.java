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
 * Represents a {@literal NOT LIKE} clause in a query.
 * 
 * @author Greg Turnquist
 */
class NotLikeExpressionContext implements ExpressionContext {

	private final ExpressionContext propertyExpression;
	private final ExpressionContext parameterExpression;

	public NotLikeExpressionContext(ExpressionContext propertyExpression, ExpressionContext parameterExpression) {

		this.propertyExpression = propertyExpression;
		this.parameterExpression = parameterExpression;
	}

	@Override
	public String joins(String alias) {

		String propertyJoins = propertyExpression.joins(alias);
		String parameterJoins = parameterExpression.joins(alias);

		String build = "";

		if (!propertyJoins.isEmpty()) {
			build += propertyJoins;
		}

		if (!parameterJoins.isEmpty()) {
			if (!build.isEmpty()) {
				build += " ";
			}
			build += parameterJoins;
		}

		return build;
	}

	@Override
	public String criteria(String alias) {
		return propertyExpression.criteria(alias) + " not like " + parameterExpression.criteria(alias);
	}
}
