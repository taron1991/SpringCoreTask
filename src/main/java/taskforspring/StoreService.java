package taskforspring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StoreService {
    private final SessionFactory sessionFactory;
    private final StatisticService statisticService;

    public boolean add(User user) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            statisticService.writeSuccessEvent(MessageSuccess.SAVE_SUCCESS);
            return true;
        } catch (Exception e) {
            statisticService.writeErrorEvent(MessageErrors.SAVE_ERROR);
            return false;
        }
    }

    public boolean update(User user) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            statisticService.writeSuccessEvent(MessageSuccess.UPDATE_SUCCESS);
            return true;
        } catch (Exception e) {
            statisticService.writeErrorEvent(MessageErrors.UPDATE_ERROR);
            return false;
        }
    }

    public boolean delete(User user) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.delete(user);
            session.getTransaction().commit();
            statisticService.writeSuccessEvent(MessageSuccess.DELETE_SUCCESS);
            return true;
        } catch (Exception e) {
            statisticService.writeErrorEvent(MessageErrors.DELETE_ERROR);
            return false;
        }
    }
}
