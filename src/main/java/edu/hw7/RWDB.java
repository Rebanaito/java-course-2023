package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class RWDB implements PersonDatabase {
    public RWDB() {
    }

    private final static Logger LOGGER = Logger.getLogger("SyncDBLogger");
    private final static ReentrantReadWriteLock RWLOCK = new ReentrantReadWriteLock();
    private final static Lock WRITE_LOCK = RWLOCK.writeLock();
    private final static Lock READ_LOCK = RWLOCK.readLock();
    private final HashMap<Integer, Person> byID = new HashMap<Integer, Person>();
    private final HashMap<String, List<Person>> byName = new HashMap<String, List<Person>>();
    private final HashMap<String, List<Person>> byAddress = new HashMap<String, List<Person>>();
    private final HashMap<String, List<Person>> byPhone = new HashMap<String, List<Person>>();

    @Override
    public void add(Person person) {
        if (invalidPerson(person)) {
            return;
        }

        WRITE_LOCK.lock();

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

        WRITE_LOCK.unlock();
    }

    @Override
    public void delete(int id) {
        WRITE_LOCK.lock();
        if (!byID.containsKey(id)) {
            WRITE_LOCK.unlock();
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

        WRITE_LOCK.unlock();
    }

    @Override
    public List<Person> findByName(String name) {
        if (name == null) {
            return null;
        }

        READ_LOCK.lock();
        List<Person> people = byName.get(name);
        READ_LOCK.unlock();
        return people;
    }

    @Override
    public List<Person> findByAddress(String address) {
        if (address == null) {
            return null;
        }

        READ_LOCK.lock();
        List<Person> people = byAddress.get(address);
        READ_LOCK.unlock();
        return people;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        if (phone == null) {
            return null;
        }

        READ_LOCK.lock();
        List<Person> people = byPhone.get(phone);
        READ_LOCK.unlock();
        return people;
    }

    @Override
    public int size() {
        READ_LOCK.lock();
        int size = byID.size();
        READ_LOCK.unlock();

        return size;
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
