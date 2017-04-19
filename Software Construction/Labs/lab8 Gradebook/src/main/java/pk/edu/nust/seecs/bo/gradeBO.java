package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Grade;
import pk.edu.nust.seecs.gradebook.entity.Student;

/**
 *
 * @author Dawoud Ali
 */
public class gradeBO {
    
    GradeDao dao;
    
    public gradeBO() {
        dao = new GradeDao();
    }
// Update via DAO

    public void updateClo(Grade cloId) {
        
        dao.updateGrade(cloId);
        
    }

    public GradeDao getDao() {
        return dao;
    }

    public void setDao(GradeDao dao) {
        this.dao = dao;
    }

    // Get Only One CLO
    public Grade getClo(int cloId) {
        
        return dao.getGradeById(cloId);
        
    }

    // Get the lists of all the employees
    public List<Grade> getAll() {
        return dao.getAllGrades();
        
    }

    // Adding the Clo
    public void addClo(Grade clo) {
        dao.addGrade(clo);
    }

    // Deleting the Clo
    public void deleteGrade(int cloid) {
        dao.deleteGrade(cloid);
    }
}
