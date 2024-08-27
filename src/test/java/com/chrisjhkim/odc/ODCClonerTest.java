package com.chrisjhkim.odc;

import com.chrisjhkim.test.CloneableObject;
import com.chrisjhkim.test.Member;
import com.chrisjhkim.test.NoArgsConstructorClazz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ODCClonerTest {


	@Test
	@DisplayName("null 객체 clone")
	void test_clone_null(){

		// Test # Given
		Member member = null;

		// Test # When
		Member result = ODCCloner.clone(member);

		// Test # Then
		assertThat(result).isNull();;


	}






	@Test
	@DisplayName("Cloneable 객체 clone")
	void test_clone_Cloneable(){

		// Test # Given
		CloneableObject cloneableObject = CloneableObject.builder()
				.name("Chris")
				.phoneNumber("01012341234")
				.build();

		// Test # When
		CloneableObject result = ODCCloner.clone(cloneableObject);

		// Test # Then
		assertThat(result.getName()).isEqualTo(cloneableObject.getName());;
		assertThat(result.getPhoneNumber()).isEqualTo(cloneableObject.getPhoneNumber());;
		assertThat(result).isEqualTo(cloneableObject);;


	}


	@Test
	@DisplayName("기본생성자 public 복사")
	void test_clone_All_Args_Constructor(){

		// Test # Given
		NoArgsConstructorClazz noArgsConstructorObject = NoArgsConstructorClazz.builder()
				.name("Chris")
				.phoneNumber("01012341234")
				.build();

		// Test # When
		NoArgsConstructorClazz result = ODCCloner.clone(noArgsConstructorObject);

		// Test # Then
		assertThat(result.getName()).isEqualTo(noArgsConstructorObject.getName());;
		assertThat(result.getPhoneNumber()).isEqualTo(noArgsConstructorObject.getPhoneNumber());;
		assertThat(result).isEqualTo(noArgsConstructorObject);;


	}

}