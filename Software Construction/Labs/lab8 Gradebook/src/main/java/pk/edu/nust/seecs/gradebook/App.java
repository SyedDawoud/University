package pk.edu.nust.seecs.gradebook;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pk.edu.nust.seecs.bo.cloBO;
import pk.edu.nust.seecs.bo.contentBO;
import pk.edu.nust.seecs.bo.studentBO;
import pk.edu.nust.seecs.bo.teacherBO;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App.
 * <p>
 * This executes everything.
 */
public class App {
    
    public static void main(String[] args) {
     
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student obj = (Student) context.getBean("student");
        obj.toString();
        //contentBO sbo = (contentBO) context.getBean("contentBO");
        
        System.out.println("Done");
    }
    
}
