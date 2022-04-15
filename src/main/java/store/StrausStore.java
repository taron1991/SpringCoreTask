package store;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StrausStore {

    private final List<Straus> strauses = List.of(new Straus("Страус1"), new Straus("Страус2"));

    public List<Straus> findAll() {
        return strauses;
    }
}
