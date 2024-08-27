package com.chrisjhkim.test;


import lombok.*;

@Builder
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor
@Getter
public class NoArgsConstructorClazz {

	private String name;
	private String phoneNumber;
	private Integer age;


	public NoArgsConstructorClazz(String name, String phoneNumber, Integer age) {
		System.out.println("NoArgsConstructorClazz.NoArgsConstructorClazz");
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
}
