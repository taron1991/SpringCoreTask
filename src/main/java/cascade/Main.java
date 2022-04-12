package cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*      ALL, +
        PERSIST, +
        MERGE,  +
        REMOVE,
        REFRESH, +
        DETACH;  +           */

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Driver.class)
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        Driver driver = Driver.builder()
                .surname("Нестеренко")
                .build();


        Car car1 = Car.builder()
               .name("BMW M5")
               .driver(driver)
               .build();

        Car car2 = Car.builder()
                .name("Toyota Camry")
                .driver(driver)
                .build();

        List<Car> cars = List.of(car1, car2);

        driver.setCars(cars);

        session.beginTransaction();

        Driver result = session.get(Driver.class, 8);
        List<Car> resultCars = result.getCars();

        IntStream.range(0, resultCars.size()).forEach(i -> {
            Car car = resultCars.get(i);
            car.setDriver(null);
            session.save(car);
        });

        result.setCars(null);
        session.delete(result);

        session.getTransaction().commit();

        session.close();
    }
}
