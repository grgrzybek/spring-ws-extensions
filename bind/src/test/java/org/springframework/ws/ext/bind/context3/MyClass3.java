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

package org.springframework.ws.ext.bind.context3;

import javax.xml.bind.annotation.XmlElement;

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
public class MyClass3 {

	@XmlElement
	private MyClass2 c2;

	/**
	 * @return the c2
	 */
	public MyClass2 getC2() {
		return this.c2;
	}

	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(MyClass2 c2) {
		this.c2 = c2;
	}

}
