/**
 * EchoEndpointWrappedEncoded11SoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11;

public class EchoEndpointWrappedEncoded11SoapBindingImpl implements org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11.EchoEndpoint{
    public org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11.OneParamResponse oneParam(org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11.OneParam parameters) throws java.rmi.RemoteException {
        return new OneParamResponse("[" + parameters.getParam1() + "]");
    }

    public org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11.TwoParamsResponse twoParams(org.springframework.ws.axis1.case1.contractfirst.wrapped_encoded_11.TwoParams parameters) throws java.rmi.RemoteException {
        return new TwoParamsResponse("[" + parameters.getParam1() + "|" + parameters.getParam2() + "]");
    }

}
