package com.topica.annotation.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMethodAnnotation {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Class<?> aClass = MethodClass.class;

		// field
		Field[] fields = aClass.getFields();
		for (Field field : fields) {
			String name = field.getName();
			System.out.println("Name: " +name);
			System.out.println("Value: "+ field.get(name));
			Annotation annotation = field.getAnnotation(MethodAnnotation.class);
			MethodAnnotation anno = (MethodAnnotation) annotation;
			System.out.println("Value of annotation: " + anno.value());
		}

		// method
		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			Annotation annotation = method.getAnnotation(MethodAnnotation.class);
			if (annotation instanceof MethodAnnotation) {
				System.out.println("Name: " + method.getName());
				MethodAnnotation ann = (MethodAnnotation) annotation;
				System.out.println("Value of annotation: " + ann.value());
			}
		}
	}
}

class MethodClass {
	@MethodAnnotation(value = "Constant String")
	public static final String CONSTANT = "constant string";

	@MethodAnnotation
	public static final void doSomething() {

	}
}