package DefaultNamespace;

public class SayHelloProxy implements DefaultNamespace.SayHello {
    private String _endpoint = null;
    private DefaultNamespace.SayHello sayHello = null;

    public SayHelloProxy() {
        _initSayHelloProxy();
    }

    public SayHelloProxy(String endpoint) {
        _endpoint = endpoint;
        _initSayHelloProxy();
    }

    private void _initSayHelloProxy() {
        try {
            sayHello = (new DefaultNamespace.SayHelloServiceLocator()).getsayHello();
            if (sayHello != null) {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub)sayHello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
                else
                    _endpoint = (String)((javax.xml.rpc.Stub)sayHello)._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        }
        catch (javax.xml.rpc.ServiceException serviceException) {}
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
        if (sayHello != null)
            ((javax.xml.rpc.Stub)sayHello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

    }

    public DefaultNamespace.SayHello getSayHello() {
        if (sayHello == null)
            _initSayHelloProxy();
        return sayHello;
    }

    public java.lang.String hello(java.lang.String name) throws java.rmi.RemoteException{
        if (sayHello == null)
            _initSayHelloProxy();
        return sayHello.hello(name);
    }


}