package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.transaction.Transactional;

public class Main {

    private static StandardServiceRegistry registry;
    private static SessionFactory sf;
    private static Session session;

    public static void main(String[] args) {
        registry = new StandardServiceRegistryBuilder()
            .configure().build();
        sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

        session = sf.openSession();

        Item item = new Item();
        item.setId(8);
        item.setImage(new byte[]{25,24,56,83,72,56,23,56});
        item.setName("Kostya");
        item.setSexType(SexType.MAN);

      //  save(item);

        Item result = getById(8);
        System.out.println(result);

    }

    @Transactional
    public static void save(Item item) {
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }

    @Transactional
    public static Item getById(int id) {
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        return item;
    }
}
