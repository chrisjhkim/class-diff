package com.chrisjhkim.odc;

import lombok.Getter;

@Getter
public class DiffResult <T> {


	private boolean isEqual;

	private T diffResultObject1;
	private T diffResultObject2;


	/**
	 * Returns a DiffResult indicating both objects are null.
	 *
	 * @param <T> the type of objects being compared
	 * @return a DiffResult object with isEqual set to true and diffResult set to null
	 */
	public static <T> DiffResult<T> bothNull() {
		DiffResult<T> result = new DiffResult<>();
		result.isEqual = true;
		result.diffResultObject1 = null;
		result.diffResultObject2 = null;
		return result;
	}

	public static <T> DiffResult<T> of(T obj1, T obj2) {
		DiffResult<T> result = new DiffResult<>();
		result.isEqual = false;
		result.diffResultObject1 = obj1;
		result.diffResultObject2 = obj2;
		return result;
	}
}
