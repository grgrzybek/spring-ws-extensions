/*
 * Copyright 2005-2011 the original author or authors.
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

package org.springframework.ws.cxf.dispatch1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
@WebService
public interface EchoEndpointDocumentInterface {

	@WebMethod
	public String echo1(@WebParam String param);

	@WebMethod
	public String echo2(@WebParam String param);

	@SOAPBinding(parameterStyle = ParameterStyle.BARE, style = Style.DOCUMENT, use = Use.LITERAL)
	public String echo3a(@WebParam String param);

	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
	public String echo3b(@WebParam String param1, @WebParam String param2);

	@SOAPBinding(parameterStyle = ParameterStyle.BARE, style = Style.DOCUMENT, use = Use.ENCODED)
	public String echo3e(@WebParam String param);

	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.ENCODED)
	public String echo3f(@WebParam String param1, @WebParam String param2);

	@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
	public String echo4(@WebParam int param);

}
