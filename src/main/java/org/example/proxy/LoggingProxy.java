package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy implements InvocationHandler {

    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();

        // Invoke the actual method
        Object result = method.invoke(target, args);

        long executionTime = System.currentTimeMillis() - start;
        System.out.println(method.getName() + " executed in " + executionTime + "ms");

        return result;
    }

    /**
     * target is implement class
     * @param target
     * @param interfaceType
     * @return
     * @param <T>
     */
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingProxy(target)
        );
    }
}
