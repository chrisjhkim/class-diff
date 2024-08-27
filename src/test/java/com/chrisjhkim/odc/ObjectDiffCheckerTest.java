package com.chrisjhkim.odc;

import com.chrisjhkim.test.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ObjectDiffCheckerTest {


	@Test
	void test_diff(){
		// Test # Given
		Member member1 = Member.builder()
				.name("Chris")
				.build();

		Member member2 = Member.builder()
				.name("David")
				.build();

		// Test # When
		DiffResult<Member> result = ObjectDiffChecker.diff(member1, member2);

		// Test # Then
		assertThat(result.isEqual()).isFalse();
		assertThat(result.getDiffResultObject1()).isNotNull();
		assertThat(result.getDiffResultObject2()).isNotNull();

	}



	@Test
	@DisplayName("둘다 null 인 경우")
	void test_diff_both_null(){
		// Test # Given
		Member member1 = null;
		Member member2 = null;

		// Test # When
		DiffResult<Member> diffResult = ObjectDiffChecker.diff(member1, member2);

		// Test # Then
		assertThat(diffResult.isEqual()).isTrue();
		assertThat(diffResult.getDiffResultObject1()).isNull();
		assertThat(diffResult.getDiffResultObject2()).isNull();

	}


	@Test
	@DisplayName("첫번쩌 Object null")
	void test_diff_first_object_null(){
		// Test # Given
		Member member1 = null;
		Member member2 = Member.builder()
				.name("Chris")
				.phoneNumber("01012341234")
				.age(5)
				.build();

		// Test # When
		DiffResult<Member> diffResult = ObjectDiffChecker.diff(member1, member2);

		// Test # Then
		assertThat(diffResult.isEqual()).isFalse();
		assertThat(diffResult.getDiffResultObject1()).isNull();
		assertThat(diffResult.getDiffResultObject2()).isEqualTo(member2);

	}



	@Test
	@DisplayName("두번째 Object null")
	void test_diff_second_object_null(){
		// Test # Given
		Member member1 = Member.builder()
				.name("Chris")
				.phoneNumber("01012341234")
				.age(5)
				.build();
		Member member2 = null;

		// Test # When
		DiffResult<Member> diffResult = ObjectDiffChecker.diff(member1, member2);

		// Test # Then
		assertThat(diffResult.isEqual()).isFalse();
		assertThat(diffResult.getDiffResultObject1()).isEqualTo(member1);
		assertThat(diffResult.getDiffResultObject2()).isNull();

	}



}