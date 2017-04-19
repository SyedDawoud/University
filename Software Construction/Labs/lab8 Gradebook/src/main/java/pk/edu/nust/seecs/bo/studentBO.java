package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Student;

/**
 *
 * @author Dawoud Ali
 */
public class studentBO {
    
    StudentDao dao;
    
    public studentBO() {
        dao = new StudentDao();
    }
// Update via DAO

    public StudentDao getDao() {
        return dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public void updateStudent(Student cloId) {
        
        dao.updateStudent(cloId);
        
    }

    // Get Only One CLO
    public Student getStudent(int cloId) {
        
        return dao.getStudentById(cloId);
        
    }

    // Get the lists of all the employees
    public List<Student> getAll() {
        return dao.getAllStudents();
        
    }

    // Adding the Clo
    public void addStudent(Student clo) {
        dao.addStudent(clo);
    }

    // Deleting the Clo
    public void deleteStudent(int cloid) {
        dao.deleteStudent(cloid);
    }
}
