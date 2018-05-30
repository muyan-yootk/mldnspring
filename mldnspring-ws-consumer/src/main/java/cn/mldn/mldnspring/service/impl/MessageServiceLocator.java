/**
 * MessageServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.mldn.mldnspring.service.impl;

public class MessageServiceLocator extends org.apache.axis.client.Service implements cn.mldn.mldnspring.service.impl.MessageService {

    public MessageServiceLocator() {
    }


    public MessageServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MessageServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MessageServiceImplPort
    private java.lang.String MessageServiceImplPort_address = "http://192.168.28.87:7777/message";

    public java.lang.String getMessageServiceImplPortAddress() {
        return MessageServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MessageServiceImplPortWSDDServiceName = "MessageServiceImplPort";

    public java.lang.String getMessageServiceImplPortWSDDServiceName() {
        return MessageServiceImplPortWSDDServiceName;
    }

    public void setMessageServiceImplPortWSDDServiceName(java.lang.String name) {
        MessageServiceImplPortWSDDServiceName = name;
    }

    public cn.mldn.mldnspring.service.IMessageService getMessageServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MessageServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMessageServiceImplPort(endpoint);
    }

    public cn.mldn.mldnspring.service.IMessageService getMessageServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.mldn.mldnspring.service.impl.MessageServiceImplPortBindingStub _stub = new cn.mldn.mldnspring.service.impl.MessageServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getMessageServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMessageServiceImplPortEndpointAddress(java.lang.String address) {
        MessageServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.mldn.mldnspring.service.IMessageService.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.mldn.mldnspring.service.impl.MessageServiceImplPortBindingStub _stub = new cn.mldn.mldnspring.service.impl.MessageServiceImplPortBindingStub(new java.net.URL(MessageServiceImplPort_address), this);
                _stub.setPortName(getMessageServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MessageServiceImplPort".equals(inputPortName)) {
            return getMessageServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.mldnspring.mldn.cn/", "messageService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.mldnspring.mldn.cn/", "MessageServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MessageServiceImplPort".equals(portName)) {
            setMessageServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
