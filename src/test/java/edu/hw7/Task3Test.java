package edu.hw7;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    @DisplayName("Synchronized implementation method test")
    void syncMethodTest() {
        SyncDB db = new SyncDB();

        Person person = new Person(1337, "Oleg Tinkov", "Moscow", "+79876543210");
        db.add(person);

        var byName = db.findByName(person.name());
        assertThat(byName.isEmpty()).isFalse();
        assertThat(byName.get(0).id()).isEqualTo(person.id());

        var byAddress = db.findByAddress(person.address());
        assertThat(byAddress.isEmpty()).isFalse();
        assertThat(byAddress.get(0).id()).isEqualTo(person.id());

        var byPhone = db.findByPhone(person.phoneNumber());
        assertThat(byPhone.isEmpty()).isFalse();
        assertThat(byPhone.get(0).id()).isEqualTo(person.id());

        db.delete(person.id());

        byName = db.findByName(person.name());
        assertThat(byName).isNull();

        byAddress = db.findByAddress(person.address());
        assertThat(byAddress).isNull();

        byPhone = db.findByPhone(person.phoneNumber());
        assertThat(byPhone).isNull();
    }

    @Test
    @DisplayName("Synchronized implementation valid entries add then delete test")
    void syncValidTest1() {
        SyncDB db = new SyncDB();
        int threadCount = 256;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
            threads[i] = new Thread(() -> {
                db.add(person);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int j = i;
            threads[i] = new Thread(() -> {
                db.delete(j);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Synchronized implementation valid entries add with delete test")
    void syncValidTest2() {
        SyncDB db = new SyncDB();
        int threadCount = 256;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
            threads[i] = new Thread(() -> {
                db.add(person);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(threadCount);

        for (int i = threadCount; i < threadCount * 2; i++) {
            int j = i - threadCount;
            if (i % 2 == 0) {
                threads[j] = new Thread(() -> {
                    db.delete(j);
                });
            } else {
                Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
                threads[j] = new Thread(() -> {
                    db.add(person);
                });
            }
        }

        assertThat(db.size()).isEqualTo(threadCount);
    }

    @Test
    @DisplayName("Synchronized implementation invalid entries test")
    void syncInvalidTest() {
        SyncDB db = new SyncDB();

        db.add(new Person(0, "Joe Biden", "White House", "+00000000"));
        db.add(new Person(0, "Donald Trump", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Joe Biden").size()).isEqualTo(1);

        db.add(new Person(-1, "Barack Obama", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, null, "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName(null)).isNull();

        db.add(new Person(1, "", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("")).isNull();

        db.add(new Person(1, "Barack Obama", null, "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "White House", null));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "White House", ""));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();
    }

    @Test
    @DisplayName("Read-write lock implementation method test")
    void rwMethodTest() {
        RWDB db = new RWDB();

        Person person = new Person(1337, "Oleg Tinkov", "Moscow", "+79876543210");
        db.add(person);

        var byName = db.findByName(person.name());
        assertThat(byName.isEmpty()).isFalse();
        assertThat(byName.get(0).id()).isEqualTo(person.id());

        var byAddress = db.findByAddress(person.address());
        assertThat(byAddress.isEmpty()).isFalse();
        assertThat(byAddress.get(0).id()).isEqualTo(person.id());

        var byPhone = db.findByPhone(person.phoneNumber());
        assertThat(byPhone.isEmpty()).isFalse();
        assertThat(byPhone.get(0).id()).isEqualTo(person.id());

        db.delete(person.id());

        byName = db.findByName(person.name());
        assertThat(byName).isNull();

        byAddress = db.findByAddress(person.address());
        assertThat(byAddress).isNull();

        byPhone = db.findByPhone(person.phoneNumber());
        assertThat(byPhone).isNull();
    }

    @Test
    @DisplayName("Read-write lock implementation valid entries add then delete test")
    void rwValidTest1() {
        RWDB db = new RWDB();
        int threadCount = 256;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
            threads[i] = new Thread(() -> {
                db.add(person);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int j = i;
            threads[i] = new Thread(() -> {
                db.delete(j);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Read-write lock implementation valid entries add with delete test")
    void rwValidTest2() {
        RWDB db = new RWDB();
        int threadCount = 256;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
            threads[i] = new Thread(() -> {
                db.add(person);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
                throw new RuntimeException();
            }
        }
        assertThat(db.size()).isEqualTo(threadCount);

        for (int i = threadCount; i < threadCount * 2; i++) {
            int j = i - threadCount;
            if (i % 2 == 0) {
                threads[j] = new Thread(() -> {
                    db.delete(j);
                });
            } else {
                Person person = new Person(i, "John Doe", "42 Baker st.", "+79876543210");
                threads[j] = new Thread(() -> {
                    db.add(person);
                });
            }
        }

        assertThat(db.size()).isEqualTo(threadCount);
    }

    @Test
    @DisplayName("Read-write lock implementation invalid entries test")
    void rwInvalidTest() {
        RWDB db = new RWDB();

        db.add(new Person(0, "Joe Biden", "White House", "+00000000"));
        db.add(new Person(0, "Donald Trump", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Joe Biden").size()).isEqualTo(1);

        db.add(new Person(-1, "Barack Obama", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, null, "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName(null)).isNull();

        db.add(new Person(1, "", "White House", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("")).isNull();

        db.add(new Person(1, "Barack Obama", null, "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "", "+000000000"));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "White House", null));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();

        db.add(new Person(1, "Barack Obama", "White House", ""));
        assertThat(db.size()).isEqualTo(1);
        assertThat(db.findByName("Barack Obama")).isNull();
    }
}