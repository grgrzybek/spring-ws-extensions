/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use file except in compliance with the License.
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

package org.springframework.ws.ext.bind.internal;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.ws.ext.bind.SweJaxbConstants;
import org.springframework.ws.ext.bind.internal.model.ValuePattern;
import org.springframework.ws.ext.bind.internal.model.XmlEventsPattern;

/**
 * <p>Built-in mappings are configured for classes convertible to {@link String}</p>
 * <p>See:<ul>
 * <li><a href="http://www.w3.org/TR/xmlschema-2/#built-in-datatypes">http://www.w3.org/TR/xmlschema-2/#built-in-datatypes</a></li>
 * <li>JAXB 2.2, section 6.2.2.</li>
 * <li>JAX-RPC 1.1, section 4.2.1.</li>
 * </ul></p>
 *
 * @author Grzegorz Grzybek
 */
public abstract class BuiltInMappings {

	/**
	 * @param patterns
	 * @param formattingConversionService
	 */
	public static void initialize(Map<Class<?>, XmlEventsPattern> patterns, FormattingConversionService formattingConversionService) {
		// see: com.sun.xml.bind.v2.model.impl.RuntimeBuiltinLeafInfoImpl<T> and inner
		// com.sun.xml.bind.v2.model.impl.RuntimeBuiltinLeafInfoImpl.StringImpl<T> implementations

		// we have two places where XSD -> Java mapping is defined:
		// - JAX-RPC 1.1, section 4.2.1 Simple Types
		// - JAXB 2, section 6.2.2 Atomic Datatype

		// XML Schema (1.0) Part 2: Datatypes Second Edition, or/and
		// W3C XML Schema Definition Language (XSD) 1.1 Part 2: Datatypes

		// conversion of primitive types should be base on "Lexical Mapping" of simple types defined in XSD part 2

		// 3.2 Special Built-in Datatypes (#special-datatypes)
		// 3.2.1 anySimpleType (#anySimpleType)
		// 3.2.2 anyAtomicType (#anyAtomicType)

		// 3.3 Primitive Datatypes (#built-in-primitive-datatypes)
		// ValuePattern pattern = null;

		// 3.3.1 string (#string)
		patterns.put(String.class, new ValuePattern(SweJaxbConstants.XSD_STRING, String.class));

		// 3.3.2 boolean (#boolean)
		patterns.put(Boolean.class, new ValuePattern(SweJaxbConstants.XSD_BOOLEAN, Boolean.class));
		patterns.put(Boolean.TYPE, new ValuePattern(SweJaxbConstants.XSD_BOOLEAN, Boolean.class));
		formattingConversionService.addFormatterForFieldType(Boolean.class, new Formatter<Boolean>() {
			@Override
			public String print(Boolean object, Locale locale) {
				return Boolean.toString(object);
			}

			@Override
			public Boolean parse(String text, Locale locale) throws ParseException {
				// TODO: should allow "true", "false", "1", "0"
				return Boolean.parseBoolean(text);
			}
		});

		// 3.3.3 decimal (#decimal)
		patterns.put(BigDecimal.class, new ValuePattern(SweJaxbConstants.XSD_DECIMAL, BigDecimal.class));
		formattingConversionService.addFormatterForFieldType(BigDecimal.class, new Formatter<BigDecimal>() {
			@Override
			public String print(BigDecimal object, Locale locale) {
				return object.toPlainString();
			}

			@Override
			public BigDecimal parse(String text, Locale locale) throws ParseException {
				// TODO: should allow (\+|-)?([0-9]+(\.[0-9]*)?|\.[0-9]+)
				return new BigDecimal(text);
			}
		});

		// 3.3.4 float (#float)
		patterns.put(Float.class, new ValuePattern(SweJaxbConstants.XSD_FLOAT, Float.class));
		formattingConversionService.addFormatterForFieldType(Float.class, new Formatter<Float>() {
			@Override
			public String print(Float object, Locale locale) {
				return Float.toString(object);
			}

			@Override
			public Float parse(String text, Locale locale) throws ParseException {
				// TODO: should allow (\+|-)?([0-9]+(\.[0-9]*)?|\.[0-9]+)([Ee](\+|-)?[0-9]+)?|(\+|-)?INF|NaN
				return Float.parseFloat(text);
			}
		});

		// 3.3.5 double (#double)
		patterns.put(Double.class, new ValuePattern(SweJaxbConstants.XSD_DOUBLE, Double.class));
		formattingConversionService.addFormatterForFieldType(Double.class, new Formatter<Double>() {
			@Override
			public String print(Double object, Locale locale) {
				return Double.toString(object);
			}

			@Override
			public Double parse(String text, Locale locale) throws ParseException {
				// TODO: should allow (\+|-)?([0-9]+(\.[0-9]*)?|\.[0-9]+)([Ee](\+|-)?[0-9]+)?|(\+|-)?INF|NaN
				return Double.parseDouble(text);
			}
		});

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

		patterns.put(Byte.class, ValuePattern.INSTANCE);
		formattingConversionService.addFormatterForFieldType(Byte.class, new Formatter<Byte>() {
			@Override
			public String print(Byte object, Locale locale) {
				return Byte.toString(object);
			}

			@Override
			public Byte parse(String text, Locale locale) throws ParseException {
				return Byte.parseByte(text);
			}
		});

		patterns.put(Short.class, ValuePattern.INSTANCE);
		formattingConversionService.addFormatterForFieldType(Short.class, new Formatter<Short>() {
			@Override
			public String print(Short object, Locale locale) {
				return Short.toString(object);
			}

			@Override
			public Short parse(String text, Locale locale) throws ParseException {
				return Short.parseShort(text);
			}
		});

		patterns.put(Integer.class, new ValuePattern(SweJaxbConstants.XSD_INTEGER, Integer.class));
		patterns.put(Integer.TYPE, new ValuePattern(SweJaxbConstants.XSD_INTEGER, Integer.class));
		formattingConversionService.addFormatterForFieldType(Integer.class, new Formatter<Integer>() {
			@Override
			public String print(Integer object, Locale locale) {
				return Integer.toString(object);
			}

			@Override
			public Integer parse(String text, Locale locale) throws ParseException {
				return Integer.parseInt(text);
			}
		});

		patterns.put(Long.class, ValuePattern.INSTANCE);
		formattingConversionService.addFormatterForFieldType(Long.class, new Formatter<Long>() {
			@Override
			public String print(Long object, Locale locale) {
				return Long.toString(object);
			}

			@Override
			public Long parse(String text, Locale locale) throws ParseException {
				return Long.parseLong(text);
			}
		});

		// conversion service
		for (XmlEventsPattern vp : patterns.values())
			((ValuePattern) vp).setConversionService(formattingConversionService);

		// other simple types
		// JAXB2:
		/*
			class [B
			class java.awt.Image
			class java.io.File
			class java.lang.Character
			class java.lang.Class
			class java.lang.Void
			class java.math.BigDecimal
			class java.math.BigInteger
			class java.net.URI
			class java.net.URL
			class java.util.Calendar
			class java.util.Date
			class java.util.GregorianCalendar
			class java.util.UUID
			class javax.activation.DataHandler
			class javax.xml.datatype.Duration
			class javax.xml.datatype.XMLGregorianCalendar
			class javax.xml.namespace.QName
			interface javax.xml.transform.Source
		 */
	}

}
