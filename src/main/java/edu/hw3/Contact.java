package edu.hw3;

import java.util.Arrays;

public record Contact(String firstName, String lastName) {
    private final static String ASC = "ASC";
    private final static String DESC = "DESC";

    public static Contact[] parseContacts(String[] contacts, String order) {
        if (invalidArguments(contacts, order)) {
            return new Contact[0];
        }

        for (int i = 0; i < contacts.length; i++) {
            var split = contacts[i].split(" ");
            if (split.length != 2) {
                return new Contact[0];
            }
            contacts[i] = split[1] + " " + split[0];
        }
        Arrays.sort(contacts);

        return makeList(contacts, order);
    }

    private static boolean invalidArguments(String[] contacts, String order) {
        if (contacts == null || order == null) {
            return true;
        }
        return (!order.equals(ASC) && !order.equals(DESC));
    }

    private static Contact[] makeList(String[] contactsReversed, String order) {
        var contactList = new Contact[contactsReversed.length];

        if (order.equals(ASC)) {
            for (int j = 0; j < contactsReversed.length; j++) {
                var split = contactsReversed[j].split(" ");
                contactList[j] = new Contact(split[1], split[0]);
            }
        } else {
            for (int j = 0; j < contactsReversed.length; j++) {
                var split = contactsReversed[contactsReversed.length - 1 - j].split(" ");
                contactList[j] = new Contact(split[1], split[0]);
            }
        }
        return contactList;
    }
}
