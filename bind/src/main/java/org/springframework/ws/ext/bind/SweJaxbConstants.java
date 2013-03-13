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

package org.springframework.ws.ext.bind;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.constants.Constants;

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
public interface SweJaxbConstants {

	// JAXB Context properties

	static final String SWE_CONTEXT_PROPERTY_PREFIX = SweJaxbContext.class.getPackage().getName();

	/**
	 * <p>If the value of this property is true, we try to be as much JAXB compliant as its ... reasonable. Otherwise we try to be pragmatic.</p>
	 * <p>This setting affects:<ul>
	 * <li>package scanning: Do we use ObjectFactory/@XmlRegistry/jaxb.index (compliant) or just all package's classes (pragmatic)?</li>
	 * </ul></p>
	 */
	public static final String SWE_CONTEXT_PROPERTY_STRICT_JAXB = SWE_CONTEXT_PROPERTY_PREFIX + ".strictJaxbCompliance";

	// JAXB Marshaller properties

	/**
	 * The name of the property used to specify whether or not we're doing multiRef encoding (Soap 1.1 Section 5 Encoding) during marshalling.
	 * This should be detected by Unmarshaller however.
	 */
	public static final String SWE_MARSHALLER_PROPERTY_JAXB_MULTIREFS = "swe.jaxb.marshaller.multirefs";

	/**
	 * <p>The name of the property used to specify whether or not we add {@code xsi:type="QName"} were it MUST NOT be explicit.</p>
	 * <p>{@code xsi:type="QName"} should be explicit e.g., in case of using derived type.</p>
	 */
	public static final String SWE_MARSHALLER_PROPERTY_SEND_TYPES = "swe.jaxb.marshaller.types";

	// JAXB Unmarshaller properties

	// XMLSchema 1.1 types
	// like org.apache.ws.commons.schema.constants.Constants but with explicit "xs" prefix for http://www.w3.org/2001/XMLSchema namespace

	static final String XSD_PREFIX = "xs";

	// 3.3 Primitive Datatypes (#built-in-primitive-datatypes)

	// 3.3.1 string (#string)
	public static final QName XSD_STRING = new QName(Constants.URI_2001_SCHEMA_XSD, "string", XSD_PREFIX);
	// 3.3.2 boolean (#boolean)

	// 3.3.3 decimal (#decimal)
	// 3.3.4 float (#float)
	// 3.3.5 double (#double)
	// 3.3.6 duration (#duration)
	// 3.3.7 dateTime (#dateTime)
	// 3.3.8 time (#time)
	// 3.3.9 date (#date)
	// 3.3.10 gYearMonth (#gYearMonth)
	// 3.3.11 gYear (#gYear)
	// 3.3.12 gMonthDay (#gMonthDay)
	// 3.3.13 gDay (#gDay)
	// 3.3.14 gMonth (#gMonth)
	// 3.3.15 hexBinary (#hexBinary)
	// 3.3.16 base64Binary (#base64Binary)
	// 3.3.17 anyURI (#anyURI)
	// 3.3.18 QName (#QName)
	// 3.3.19 NOTATION (#NOTATION)

	// 3.4 Other Built-in Datatypes (#ordinary-built-ins)

	// 3.4.1 normalizedString (#normalizedString)
	// 3.4.2 token (#token)
	// 3.4.3 language (#language)
	// 3.4.4 NMTOKEN (#NMTOKEN)
	// 3.4.5 NMTOKENS (#NMTOKENS)
	// 3.4.6 Name (#Name)
	// 3.4.7 NCName (#NCName)
	// 3.4.8 ID (#ID)
	// 3.4.9 IDREF (#IDREF)
	// 3.4.10 IDREFS (#IDREFS)
	// 3.4.11 ENTITY (#ENTITY)
	// 3.4.12 ENTITIES (#ENTITIES)
	// 3.4.13 integer (#integer)
	// 3.4.14 nonPositiveInteger (#nonPositiveInteger)
	// 3.4.15 negativeInteger (#negativeInteger)
	// 3.4.16 long (#long)
	// 3.4.17 int (#int)
	// 3.4.18 short (#short)
	// 3.4.19 byte (#byte)
	// 3.4.20 nonNegativeInteger (#nonNegativeInteger)
	// 3.4.21 unsignedLong (#unsignedLong)
	// 3.4.22 unsignedInt (#unsignedInt)
	// 3.4.23 unsignedShort (#unsignedShort)
	// 3.4.24 unsignedByte (#unsignedByte)
	// 3.4.25 positiveInteger (#positiveInteger)
	// 3.4.26 yearMonthDuration (#yearMonthDuration)
	// 3.4.27 dayTimeDuration (#dayTimeDuration)
	// 3.4.28 dateTimeStamp (#dateTimeStamp)

}
