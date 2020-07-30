import dao.TaskDAO;
import dao.TaskDAOImpl;
import org.springframework.context.annotation.Bean;
import javax.persistence.Persistence;

public class TestConfiguration {

        @Bean
        public TaskDAO getTaskDAO() {
            return new TaskDAOImpl(Persistence.createEntityManagerFactory("PersistenceH2Test").createEntityManager());
        }

}
