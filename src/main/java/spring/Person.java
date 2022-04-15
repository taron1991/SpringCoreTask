package spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet cat;

    @Autowired
    public Person(Pet cat) {
        this.cat = cat;
    }

    public void say() {
        cat.say();
    }
}
