import dao.TaskDAO;
import model.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestSmoke {

    @Autowired
    private TaskDAO taskDAO;

    //проверяю фильтр, если дата задания входит
    @Test
    public void checkFilterWithValidDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Task task = new Task(format.parse("2020-03-09"), "15:45", true);
        taskDAO.add(task);
        assertEquals(1, taskDAO.get(format.parse("2020-03-08"),format.parse("2020-03-10")).size());
        assertEquals(1, taskDAO.get(format.parse("2020-03-08"),format.parse("2020-03-10"),1).size());
    }

    //проверяю фильтр, если дата задания не входит
    @Test
    public void checkFilterWithInvalidDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Task task = new Task(format.parse("2020-03-09"), "15:45", true);
        taskDAO.add(task);
        assertEquals(0, taskDAO.get(format.parse("2020-03-10"),format.parse("2020-03-11")).size());
        assertEquals(0, taskDAO.get(format.parse("2020-03-10"),format.parse("2020-03-11"),1).size());
    }

    //проверяю фильтр на граничном значении
    @Test
    public void checkFilterDateBoundaryValues() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Task task = new Task(format.parse("2020-03-09"), "15:45", true);
        taskDAO.add(task);
        assertEquals(3, taskDAO.get(format.parse("2020-03-09"),format.parse("2020-03-09")).size());
        assertEquals(1, taskDAO.get(format.parse("2020-03-09"),format.parse("2020-03-09"),1).size());
    }


}
