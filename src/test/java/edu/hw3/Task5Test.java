package edu.hw3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
	@Test
	@DisplayName("Valid contact list test 1")
	void validList1() {
		var list = Contact.parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC");
		assertThat(list).isNotNull();
		assertThat(list.length).isEqualTo(4);
		assertThat(list[0].firstName() + " " + list[0].lastName()).isEqualTo("Thomas Aquinas");
		assertThat(list[1].firstName() + " " + list[1].lastName()).isEqualTo("Rene Descartes");
		assertThat(list[2].firstName() + " " + list[2].lastName()).isEqualTo("David Hume");
		assertThat(list[3].firstName() + " " + list[3].lastName()).isEqualTo("John Locke");
	}

	@Test
	@DisplayName("Valid contact list test 2")
	void validList2() {
		var list = Contact.parseContacts(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC");
		assertThat(list).isNotNull();
		assertThat(list.length).isEqualTo(3);
		assertThat(list[0].firstName() + " " + list[0].lastName()).isEqualTo("Carl Gauss");
		assertThat(list[1].firstName() + " " + list[1].lastName()).isEqualTo("Leonhard Euler");
		assertThat(list[2].firstName() + " " + list[2].lastName()).isEqualTo("Paul Erdos");
	}

	@Test
	@DisplayName("Invalid list 1")
	void invalidList1() {
		var list = Contact.parseContacts(new String[] {}, "DESC");
		assertThat(list).isNotNull();
		assertThat(list.length).isEqualTo(0);
	}

	@Test
	@DisplayName("Invalid list 2")
	void invalidList2() {
		var list = Contact.parseContacts(null, "DESC");
		assertThat(list).isNotNull();
		assertThat(list.length).isEqualTo(0);
	}

	@Test
	@DisplayName("No last name")
	void noLastName() {
		var list = Contact.parseContacts(new String[] {"John Doe", "Matt", "Axel"}, "ASC");
		assertThat(list).isNotNull();
		assertThat(list.length).isEqualTo(3);
		assertThat(list[0].firstName()).isEqualTo("Axel");
		assertThat(list[1].firstName()).isEqualTo("John");
		assertThat(list[2].firstName()).isEqualTo("Matt");
	}
}