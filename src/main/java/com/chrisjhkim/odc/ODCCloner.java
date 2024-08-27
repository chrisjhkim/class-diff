package com.chrisjhkim.odc;

import java.lang.reflect.Field;

public class ODCCloner {
	public static <T> T clone(T obj) {
		if ( obj == null )
			return null;


		if (obj instanceof Cloneable) {
			try {
				return (T) obj.getClass().getMethod("clone").invoke(obj);
			} catch (Exception e) {
				throw new RuntimeException("Cloning using clone() method failed: " + e);
			}
		}


		try {
			// Create a new instance of the object's class
			T clone = (T) obj.getClass().getDeclaredConstructor().newInstance();

			// Get all fields of the class, including private fields
			Field[] fields = obj.getClass().getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(obj);
				field.set(clone, value);
			}
			return clone;
		} catch (Exception e) {
			throw new IllegalStateException("Cloning failed", e);
		}

	}
}
