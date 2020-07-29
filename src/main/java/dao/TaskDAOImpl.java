package dao;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

@Service
public class TaskDAOImpl implements TaskDAO{

    private EntityManager em;

    @Autowired
    public TaskDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Task task) {
        em.getTransaction().begin();
        try {
            em.persist(task);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(Long number) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public List<Task> get(Date fromDate, Date toDate) {
        return
            em.createQuery("SELECT task FROM Task task where task.date >= :fromDate AND task.date<=:toDate", Task.class)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }

    @Override
    public List<Task> get(Date fromDate, Date toDate, Long number) {
        return
                em.createQuery("SELECT task FROM Task task where task.date >= :fromDate AND task.date<=:toDate AND task.numberTask = :number", Task.class)
                        .setParameter("fromDate", fromDate)
                        .setParameter("toDate", toDate)
                        .setParameter("number", number)
                        .getResultList();
    }

    @Override
    public Task getByNumber(Long number) {
        return em.find(Task.class, number);
    }
}
