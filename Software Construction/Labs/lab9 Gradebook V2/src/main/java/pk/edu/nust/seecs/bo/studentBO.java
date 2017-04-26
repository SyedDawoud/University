
package pk.edu.nust.seecs.bo;

import java.util.List;
import java.util.Set;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;

/**
 *
 * @author Dawoud Ali
 * @version 1.0
 */
public class studentBO {
    
    private StudentDao studentdao;
    
    public Student findStudent(int id){
        return studentdao.getStudentById(id);
    }
    
    public List<Student> allStudents(){
        return studentdao.getAllStudents();
    }
    
    
    //    Get id of saved person
    public Student saveStudent(String name) {
        Student s = new Student();
        s.setName(name);
        this.studentdao.addStudent(s);
        return s;

    }
     public Student updateStudentWithCourses(int id, Set<Course> courseSet) {
        Student s = studentdao.getStudentById(id);
        s.setCourses(courseSet);
        studentdao.updateStudent(s);
        return s;
    }
     
     public void UpdateStudent(Student s){
         studentdao.updateStudent(s);
     }

    public StudentDao getStudentdao() {
        return studentdao;
    }

    public void setStudentdao(StudentDao studentdao) {
        this.studentdao = studentdao;
    }
    
     
     
}
