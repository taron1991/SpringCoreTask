package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class House {
    private Person person;

    @Autowired
    public House(Person person) {
        this.person = person;
    }

    public void houseMethod() {
        person.say();
    }
}
