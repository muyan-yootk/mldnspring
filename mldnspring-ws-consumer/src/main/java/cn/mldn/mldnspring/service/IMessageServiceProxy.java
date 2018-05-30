package cn.mldn.mldnspring.service;

public class IMessageServiceProxy implements cn.mldn.mldnspring.service.IMessageService {
  private String _endpoint = null;
  private cn.mldn.mldnspring.service.IMessageService iMessageService = null;
  
  public IMessageServiceProxy() {
    _initIMessageServiceProxy();
  }
  
  public IMessageServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIMessageServiceProxy();
  }
  
  private void _initIMessageServiceProxy() {
    try {
      iMessageService = (new cn.mldn.mldnspring.service.impl.MessageServiceLocator()).getMessageServiceImplPort();
      if (iMessageService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iMessageService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iMessageService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iMessageService != null)
      ((javax.xml.rpc.Stub)iMessageService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.mldn.mldnspring.service.IMessageService getIMessageService() {
    if (iMessageService == null)
      _initIMessageServiceProxy();
    return iMessageService;
  }
  
  public java.lang.String echo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (iMessageService == null)
      _initIMessageServiceProxy();
    return iMessageService.echo(arg0);
  }
  
  
}