package org.example.proxyJDBC;

// LoggingTransactionProxy.java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class LoggingTransactionProxy implements InvocationHandler {
    private final Object target;
    private final Connection connection;

    public LoggingTransactionProxy(Object target, Connection connection) {
        this.target = target;
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            connection.setAutoCommit(false);
            result = method.invoke(target, args);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            System.out.println(method.getName() + " executed in " + executionTime + "ms");
            connection.setAutoCommit(true);
        }
        return result;
    }

    public static <T> T createProxy(T target, Connection connection, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingTransactionProxy(target, connection)
        );
    }
}

