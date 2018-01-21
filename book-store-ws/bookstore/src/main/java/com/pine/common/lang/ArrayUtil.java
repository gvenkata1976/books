package com.pine.common.lang;

public class ArrayUtil {
	public static Object[] AppendCopy(Object[] oldArray, Object newObject) {
		Object[] newArray = (Object[]) java.lang.reflect.Array.newInstance(newObject.getClass(), 1);
		newArray[0] = newObject;
		return AppendCopy(oldArray, newArray);
	}

	public static Object[] AppendCopy(Object[] oldArray, Object[] newArray) {
		Object[] tempValue = oldArray;
		if (oldArray != null && newArray != null) {
			tempValue = (Object[]) java.lang.reflect.Array.newInstance(oldArray.getClass().getComponentType(),
					oldArray.length + newArray.length);
			System.arraycopy(oldArray, 0, tempValue, 0, oldArray.length);
			System.arraycopy(newArray, 0, tempValue, oldArray.length, newArray.length);
		} else if (oldArray == null && newArray != null) {
			tempValue = newArray;
		}
		return tempValue;
	}
}
