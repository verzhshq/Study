package AOPdemo;

import java.lang.reflect.Method;

public interface ILogger {
    void start(Method method);
    void end(Method method);
}
