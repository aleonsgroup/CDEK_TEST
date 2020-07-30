package rest;

import dao.TaskDAO;
import dao.TaskDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.Persistence;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TaskDAO getTaskDAO() {
        return new TaskDAOImpl(Persistence.createEntityManagerFactory("PersistenceH2").createEntityManager());
    }

}
