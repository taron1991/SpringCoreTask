package store;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogStore {

    private final List<Dog> dogs = List.of(new Dog("Собака1"), new Dog("Собака2"));

    public List<Dog> findAll() {
        return dogs;
    }
}
