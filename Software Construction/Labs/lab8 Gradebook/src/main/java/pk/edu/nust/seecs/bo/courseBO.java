package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;

/**
 *
 * @author Dawoud Ali
 */
public class courseBO {
    
    CourseDao dao;
    
    public courseBO() {
        dao = new CourseDao();
    }
// Update via DAO

    public void updateClo(Course cloId) {
        
        dao.updateCourse(cloId);
        
    }

    public CourseDao getDao() {
        return dao;
    }

    public void setDao(CourseDao dao) {
        this.dao = dao;
    }
    
    

    // Get Only One CLO
    public Course getCourse(int cloId) {
        
        return dao.getCourseById(cloId);
        
    }

    // Get the lists of all the employees
    public List<Course> getAll() {
        return dao.getAllCourses();
        
    }

    // Adding the Clo
    public void addCourse(Course content) {
        dao.addCourse(content);
    }

    // Deleting the Clo
    public void deleteCourse(int contentid) {
        dao.deleteCourse(contentid);
    }
}
