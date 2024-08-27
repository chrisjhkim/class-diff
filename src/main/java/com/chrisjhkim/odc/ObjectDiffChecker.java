package com.chrisjhkim.odc;

public class ObjectDiffChecker <T> {


	public static <T> DiffResult<T> diff(T obj1, T obj2) {
		T diffResult = null;
		if ( obj1 == null && obj2 == null ) {
			return DiffResult.bothNull();
		}

		if ( obj1 == null ) {
			T clone = ODCCloner.clone(obj2);
			return DiffResult.of(null, clone);
		}

		if ( obj2 == null ) {
			T clone = ODCCloner.clone(obj1);
			return DiffResult.of(clone, null);
		}


		return null;
		// 할 예정
	}
}
