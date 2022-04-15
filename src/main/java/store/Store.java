package store;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Store {

    private final DogStore dogStore;
    private final CatStore catStore;
    private final StrausStore strausStore;

    public List<Cat> findAllCats() {
        return catStore.findAll();
    }

    public List<Dog> findAllDogs() {
        return dogStore.findAll();
    }

    public List<Straus> findAllStrauses() {
        return strausStore.findAll();
    }
}
