/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.javelin.sws.ext.bind.internal.model.context1;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

import org.joda.time.DateTime;

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
public class MyDate {

	@XmlValue
	@XmlSchemaType(name = "date")
	public DateTime date;

	/**
	 * @param date
	 */
	public MyDate(DateTime date) {
		this.date = date;
	}

}
