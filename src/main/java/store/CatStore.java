package store;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatStore {
    private final List<Cat> cats = List.of(new Cat("Кошка1"), new Cat("Кошка2"));

    public List<Cat> findAll() {
        return cats;
    }
}
