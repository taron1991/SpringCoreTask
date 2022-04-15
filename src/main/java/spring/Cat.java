package spring;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet  {
    private String name;

    @Override
    public void say() {
        System.out.println("Cat " + name + "say: Miy Miy");
    }
}
