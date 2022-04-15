package store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Store store = context.getBean(Store.class);
        store.findAllCats();
        store.findAllDogs();
        store.findAllStrauses();
    }
}
