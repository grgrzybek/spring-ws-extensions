/**
 * EchoEndpointService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.springframework.ws.axis1.case1.contractfirst.document_encoded_11;

public interface EchoEndpointService extends javax.xml.rpc.Service {
    public java.lang.String getmyserviceAddress();

    public org.springframework.ws.axis1.case1.contractfirst.document_encoded_11.EchoEndpoint getmyservice() throws javax.xml.rpc.ServiceException;

    public org.springframework.ws.axis1.case1.contractfirst.document_encoded_11.EchoEndpoint getmyservice(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
