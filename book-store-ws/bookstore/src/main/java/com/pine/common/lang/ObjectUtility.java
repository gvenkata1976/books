package com.pine.common.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectUtility {
	public static Method getMethodByName(Object obj, String methodName) {
		Method result = null;
		if (obj != null && methodName != null) {
			for (Method method : obj.getClass().getDeclaredMethods()) {
				if (method.getName().equals(methodName)) {
					result = method;
				}
			}
		}
		return result;
	}

	public static void copyAttributes(Object obj1, Object obj2) {
		if (obj1 != null && obj2 != null) {
			for (Method setMethod : obj2.getClass().getDeclaredMethods()) {
				if (setMethod.getName().indexOf("set") == 0) {
					// it's a set method of obj2
					Method getMethod = getMethodByName(obj1, "g" + setMethod.getName().substring(1));
					if (getMethod != null) {
						try {
							Object result = getMethod.invoke(obj1, new Object[0]);
							// System.out.println("invoking:" +
							// getMethod.getName() + "()=" + result);
							if (result == null) {
								continue;
							}
							Object[] args = { result };
							// System.out.println("##"+result.toString());
							// System.out.println("invoking:" +
							// setMethod.getName() + "("+result.toString()+")");
							setMethod.invoke(obj2, args);
						} catch (IllegalArgumentException e) {
							// ignore on purpose, not an error
							continue;
						} catch (IllegalAccessException e) {
							// ignore on purpose, not an error
							continue;
						} catch (InvocationTargetException e) {
							// ignore on purpose, not an error
							continue;
						}
					}
				}
			}
		}
	}
}
