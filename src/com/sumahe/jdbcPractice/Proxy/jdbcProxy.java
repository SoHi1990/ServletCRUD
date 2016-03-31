package com.sumahe.jdbcPractice.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class jdbcProxy implements InvocationHandler {
	private Object target = null;

	public Object getProxy(Object object) {
		this.target = object;
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader()
				, this.target.getClass().getInterfaces()
				, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(this.target, args);
	}

}
