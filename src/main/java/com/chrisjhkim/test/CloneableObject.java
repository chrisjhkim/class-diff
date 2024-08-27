package com.chrisjhkim.test;


import lombok.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Builder
@EqualsAndHashCode
@Getter
public class CloneableObject implements Cloneable{

	private String name;
	private String phoneNumber;
	private Integer age;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
