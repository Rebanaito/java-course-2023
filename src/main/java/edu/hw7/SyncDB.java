package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class SyncDB implements PersonDatabase {
    public SyncDB() {
    }

    private final static Logger LOGGER = Logger.getLogger("SyncDBLogger");
    private final HashMap<Integer, Person> byID = new HashMap<Integer, Person>();
    private final HashMap<String, List<Person>> byName = new HashMap<String, List<Person>>();
    private final HashMap<String, List<Person>> byAddress = new HashMap<String, List<Person>>();
    private final HashMap<String, List<Person>> byPhone = new HashMap<String, List<Person>>();

    @Override
    public synchronized void add(Person person) {
        if (invalidPerson(person)) {
            return;
        }

        byID.put(person.id(), person);

        if (!byName.containsKey(person.name())) {
            byName.put(person.name(), new ArrayList<>());
        }
        byName.get(person.name()).add(person);

        if (!byAddress.containsKey(person.address())) {
            byAddress.put(person.address(), new ArrayList<>());
        }
        byAddress.get(person.address()).add(person);

        if (!byPhone.containsKey(person.phoneNumber())) {
            byPhone.put(person.phoneNumber(), new ArrayList<>());
        }
        byPhone.get(person.phoneNumber()).add(person);
    }

    @Override
    public synchronized void delete(int id) {
        if (!byID.containsKey(id)) {
            return;
        }

        Person person = byID.get(id);

        byID.remove(id);

        byName.get(person.name()).removeIf(p -> p.id() == id);
        if (byName.get(person.name()).isEmpty()) {
            byName.remove(person.name());
        }

        byAddress.get(person.address()).removeIf(p -> p.id() == id);
        if (byAddress.get(person.address()).isEmpty()) {
            byAddress.remove(person.address());
        }

        byPhone.get(person.phoneNumber()).removeIf(p -> p.id() == id);
        if (byPhone.get(person.phoneNumber()).isEmpty()) {
            byPhone.remove(person.phoneNumber());
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        if (name == null) {
            return null;
        }
        return byName.get(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        if (address == null) {
            return null;
        }
        return byAddress.get(address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        if (phone == null) {
            return null;
        }
        return byPhone.get(phone);
    }

    @Override
    public synchronized int size() {
        return byID.size();
    }

    private boolean invalidPerson(Person person) {
        if (byID.containsKey(person.id()) || person.id() < 0) {
            return true;
        }

        if (person.name() == null || person.address() == null || person.phoneNumber() == null) {
            LOGGER.info("Null values inside added Person: " + person.toString());
            return true;
        }

        if (person.name().isEmpty() || person.address().isEmpty() || person.phoneNumber().isEmpty()) {
            LOGGER.info("Empty string values inside added Person: " + person.toString());
            return true;
        }

        return false;
    }
}
