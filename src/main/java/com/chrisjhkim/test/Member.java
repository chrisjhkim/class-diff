package com.chrisjhkim.test;


import lombok.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Builder
@AllArgsConstructor(access = PACKAGE)
@NoArgsConstructor(access = PRIVATE)
@EqualsAndHashCode
@Getter
public class Member {

	private String name;
	private String phoneNumber;
	private Integer age;

}
