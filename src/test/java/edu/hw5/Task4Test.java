package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
	@Test
	@DisplayName("Invalid password")
	void invalidPassword() {
		String password = "InvalidPassword123";
		assertThat(Task4.validPassword(password)).isFalse();
	}

	@Test
	@DisplayName("Valid passwords")
	void validPassword() {
		String password = "~!@#$%^&*|";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "password!";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "p@ssword";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "pa~~word";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "pass#ord";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "pa$$word!";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "passwor^";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "%assword!";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "pas&word";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "passw*rd!";
		assertThat(Task4.validPassword(password)).isTrue();

		password = "pass|word";
		assertThat(Task4.validPassword(password)).isTrue();
	}
}
