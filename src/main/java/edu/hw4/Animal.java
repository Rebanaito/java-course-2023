package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public record Animal(
        String name,
        Type type,
        Sex sex,
        int age,
        int height,
        int weight,
        boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    @SuppressWarnings("MagicNumber")
    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static List<Animal> sortByHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> sortByWeight(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).toList().subList(0, k);
    }

    public static Map<Type, Integer> countTypes(List<Animal> animals) {
        Map<Animal.Type, Integer> count = new HashMap<Type, Integer>();
        var iterator = animals.listIterator();
        while (iterator.hasNext()) {
            var a = iterator.next();
            var val = count.get(a.type);
            if (val != null) {
                count.put(a.type, val + 1);
            } else {
                count.put(a.type, 1);
            }
        }
        return count;
    }

    public static Animal longestName(List<Animal> animals) {
        Comparator<Animal> nameLengthComparator = new Comparator<Animal>() {

            @Override
            public int compare(final Animal o1, final Animal o2) {
                // let your comparator look up your car's color in the custom order
                return Integer.compare(o1.name.length(), o2.name.length());
            }
        };
        return animals.stream().max(nameLengthComparator).get();
    }

    public static Animal.Sex sexMajority(List<Animal> animals) {
        Animal.Sex majority = Sex.M;
        long males = animals.stream().filter(s -> s.sex == Sex.M).count();
        long females = animals.stream().filter(s -> s.sex == Sex.F).count();
        if (females > males) {
            majority = Sex.F;
        }
        return majority;
    }

    public static Map<Animal.Type, Animal> heaviestAnimal(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviest = new HashMap<Animal.Type, Animal>();
        var iterator = animals.listIterator();
        while (iterator.hasNext()) {
            var a = iterator.next();
            var val = heaviest.get(a.type);
            if (val != null) {
                if (val.weight < a.weight) {
                    val = a;
                }
                heaviest.put(a.type, val);
            } else {
                heaviest.put(a.type, a);
            }
        }
        return heaviest;
    }

    public static Animal oldestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(Animal::age)).get();
    }

    public static Optional<Animal> heaviestAnimalBelow(List<Animal> animals, int k) {
        return animals.stream().filter(s -> s.height < k).max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer pawsTotal(List<Animal> animals) {
        Integer count = 0;
        var iterator = animals.listIterator();
        while (iterator.hasNext()) {
            var a = iterator.next();
            count += a.paws();
        }
        return count;
    }

    public static List<Animal> pawsNotEqualAge(List<Animal> animals) {
        return animals.stream().filter(s -> s.paws() != s.age).toList();
    }

    @SuppressWarnings("MagicNumber")
    public static List<Animal> largeBiters(List<Animal> animals) {
        return animals.stream().filter(s -> s.height > 100 && s.bites()).toList();
    }

    public static Integer heavierThan(List<Animal> animals, int weight) {
        return Math.toIntExact(animals.stream().filter(s -> s.weight > weight).count());
    }

    public static List<Animal> longNames(List<Animal> animals) {
        return animals.stream().filter(s -> s.name.split(" ").length > 2).toList();
    }

    public static boolean hasDogsTallerThan(List<Animal> animals, int k) {
        return animals.stream().anyMatch(s -> s.type == Type.DOG && s.height > k);
    }

    public static Integer totalWeightBetweenAges(List<Animal> animals, int k, int l) {
        var iterator = animals.stream().filter(s -> s.age >= k && s.age <= l).toList().listIterator();
        int count = 0;
        while (iterator.hasNext()) {
            var a = iterator.next();
            count += a.weight;
        }
        return count;
    }

    public static List<Animal> sortByTypeSexName(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::type)
                .thenComparing(Comparator.comparing(Animal::sex)
                        .thenComparing(Comparator.comparing(Animal::name)))).toList();
    }

    public static boolean spidersVsDogsBites(List<Animal> animals) {
        var dogs = animals.stream().filter(s -> s.type == Type.DOG).toList();
        var spiders = animals.stream().filter(s -> s.type == Type.SPIDER).toList();
        float dogRatio = (float) dogs.stream().filter(s -> s.bites).count() / dogs.size();
        float spiderRatio = (float) spiders.stream().filter(s -> s.bites).count() / spiders.size();
        return spiderRatio > dogRatio;
    }

    public static Optional<Animal> heaviestFish(List<Animal>[] animals) {
        Optional<Animal> bigBoy = Optional.empty();
        for (List<Animal> animal : animals) {
            if (animal == null) {
                continue;
            }
            var heavy = animal.stream().filter(s -> s.type == Type.FISH).max(Comparator.comparingInt(Animal::weight));
            if (heavy.isPresent()) {
                if (bigBoy.isEmpty()) {
                    bigBoy = heavy;
                } else if (heavy.get().weight > bigBoy.get().weight) {
                    bigBoy = heavy;
                }
            }
        }
        return bigBoy;
    }

    public static Map<String, Set<ValidationError>> badEntriesSet(List<Animal> animals) {
        HashMap<String, Set<ValidationError>> map = new HashMap<>();
        var listIter = animals.listIterator();
        while (listIter.hasNext()) {
            var animal = listIter.next();
            Set<ValidationError> errors = new HashSet<>();
            if (animal.weight < 1) {
                errors.add(new ValidationError("InvalidWeight"));
            }
            if (animal.height < 1) {
                errors.add(new ValidationError("InvalidHeight"));
            }
            if (animal.age < 0) {
                errors.add(new ValidationError("InvalidAge"));
            }
            if (!errors.isEmpty()) {
                map.put(animal.name, errors);
            }
        }
        return map;
    }

    public static Map<String, String> badEntriesString(List<Animal> animals) {
        HashMap<String, String> map = new HashMap<>();
        var listIter = animals.listIterator();
        while (listIter.hasNext()) {
            var animal = listIter.next();
            StringBuilder builder = new StringBuilder();
            if (animal.weight < 1) {
                builder.append("Weight");
            }
            if (animal.height < 1) {
                builder.append("Height");
            }
            if (animal.age < 0) {
                builder.append("Age");
            }
            if (!builder.isEmpty()) {
                map.put(animal.name, builder.toString());
            }
        }
        return map;
    }
}
