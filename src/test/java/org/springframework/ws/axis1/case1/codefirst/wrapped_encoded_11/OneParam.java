/**
 * OneParam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.ws.axis1.case1.codefirst.wrapped_encoded_11;

public class OneParam implements java.io.Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 5845024061670632336L;

	private java.lang.String param1;

	public OneParam() {
	}

	public OneParam(java.lang.String param1) {
		this.param1 = param1;
	}

	/**
	 * Gets the param1 value for this OneParam.
	 * 
	 * @return param1
	 */
	public java.lang.String getParam1() {
		return this.param1;
	}

	/**
	 * Sets the param1 value for this OneParam.
	 * 
	 * @param param1
	 */
	public void setParam1(java.lang.String param1) {
		this.param1 = param1;
	}

	private java.lang.Object __equalsCalc = null;

	@Override
	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof OneParam))
			return false;
		OneParam other = (OneParam) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (this.__equalsCalc != null) {
			return (this.__equalsCalc == obj);
		}
		this.__equalsCalc = obj;
		boolean _equals;
		_equals = true && ((this.param1 == null && other.getParam1() == null) || (this.param1 != null && this.param1.equals(other.getParam1())));
		this.__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	@Override
	public synchronized int hashCode() {
		if (this.__hashCodeCalc) {
			return 0;
		}
		this.__hashCodeCalc = true;
		int _hashCode = 1;
		if (this.getParam1() != null) {
			_hashCode += this.getParam1().hashCode();
		}
		this.__hashCodeCalc = false;
		return _hashCode;
	}

}
