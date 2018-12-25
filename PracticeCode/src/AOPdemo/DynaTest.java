package AOPdemo;

/**
 * 通过实现InvocationHandler动态代理
 */
public class DynaTest {
    public static void main(String[] args) {
//        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
        //IHello hello = new Hello();//如果不需要日志功能则使用目标类
//        hello.sayHello("world");

        IHello hello = (IHello) new DynaProxyHelloWithReflect().bind(new Hello(), new DLogger());
//        IHello hello = new Hello();//如果不需要日志功能则使用目标类
        hello.sayHello("你好");

    }
}
