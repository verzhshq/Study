package AOPdemo;

public class ProxyHello implements IHello {

    private IHello hello;
    public ProxyHello(IHello hello) {
        super();
        this.hello = hello;
    }

    @Override
    public void sayHello(String str) {
        Logger.start();
        hello.sayHello(str);
        Logger.end();
    }
}
