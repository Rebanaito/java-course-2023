package edu.hw3;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {
	public CustomComparator() {
	}
	@Override
	public int compare(String o1, String o2) {
		String s1 = o1;
		String s2 = o2;
		if (s1 == null) {
			s1 = "";
		}
		if (s2 == null) {
			s2 = "";
		}
		return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
	}
}