package edu.hw3;

public class Cluster {
	public static String[] clusterize(String input) {
		if (input == null) {
			return null;
		}
		int count = countClusters(input);
		if (count == 0) {
			return null;
		}
		String[] clusters = new String[count];
		fillClusters(clusters, input);
		return clusters;
	}

	private static int countClusters(String input) {
		int count = 0;
		int left = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				left++;
			} else if (input.charAt(i) == ')') {
				left--;
				if (left == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void fillClusters(String[] clusters, String input) {
		int count = 0;
		int left = 0;
		int j = 0;
		int prev = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				left++;
			} else if (input.charAt(i) == ')') {
				left--;
				if (left == 0) {
					clusters[j] = input.substring(prev, i+1);
					prev = i + 1;
					j++;
				}
			}
		}
	}
}