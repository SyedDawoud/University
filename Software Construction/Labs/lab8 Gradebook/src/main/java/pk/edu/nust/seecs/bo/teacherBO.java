package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 *
 * @author Dawoud Ali
 */
public class teacherBO {

    public TeacherDao getDao() {
        return dao;
    }

    public void setDao(TeacherDao dao) {
        this.dao = dao;
    }
    
    TeacherDao dao;
    
    public teacherBO() {
        dao = new TeacherDao();
    }
// Update via DAO

    public void updateTeacher(Teacher cloId) {
        
        dao.updateTeacher(cloId);
        
    }

    // Get Only One CLO
    public Teacher getTeacher(int cloId) {
        
        return dao.getTeacherById(cloId);
        
    }

    // Get the lists of all the employees
    public List<Teacher> getAll() {
        return dao.getAllTeachers();
        
    }

    // Adding the Clo
    public void addTeacher(Teacher content) {
        dao.addTeacher(content);
    }

    // Deleting the Clo
    public void deleteTeacher(int contentid) {
        dao.deleteTeacher(contentid);
    }
}
