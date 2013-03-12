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

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
public interface JwsJaxbConstants {

	/**
	 * The name of the property used to specify whether or not we're doing multiRef encoding (Soap 1.1 Section 5 Encoding) during marshalling.
	 * This should be detected by Unmarshaller however.
	 */
	public static final String JWS_JAXB_MULTIREFS = "jws.jaxb.multirefs";

}