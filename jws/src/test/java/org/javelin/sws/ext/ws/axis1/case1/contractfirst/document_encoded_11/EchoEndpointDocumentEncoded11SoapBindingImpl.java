/**
 * EchoEndpointDocumentEncoded11SoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.ws.axis1.case1.contractfirst.document_encoded_11;

public class EchoEndpointDocumentEncoded11SoapBindingImpl implements org.springframework.ws.axis1.case1.contractfirst.document_encoded_11.EchoEndpoint{
    public java.lang.String oneParam(java.lang.String param1) throws java.rmi.RemoteException {
        return "[" + param1 + "]";
    }

    public java.lang.String twoParams(java.lang.String param1, java.lang.String param2) throws java.rmi.RemoteException {
        return "[" + param1 + "|" + param2 + "]";
    }

}
