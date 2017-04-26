
package pk.edu.nust.seecs.bo;

import java.util.List;
import java.util.Set;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 *
 * @author Dawoud Ali
 * @version 1.0
 */

//Teacher BO. It will save, update and get the teacher based on the values
public class teacherBO {
    
    private TeacherDao teacherdao;
    
//    Find the Being with Id
    public Teacher findTeacher(int id){
        return teacherdao.getTeacherById(id);
          
    }
//    Save the Lonely Teacher
    public Teacher saveTeacher(String name) {
        Teacher t = new Teacher();
        t.setName(name);
        teacherdao.addTeacher(t);
        return t;

    }
    public List<Teacher> allTeacher(){
        return teacherdao.getAllTeachers();
    }
    
    
//    Updating the Teacher Later
     public Teacher updateTeacherWithCourses(int id, Set<Course> courseSet) {
        Teacher t = teacherdao.getTeacherById(id);
        t.setCourses(courseSet);
        
        teacherdao.updateTeacher(t);
        return t;
    }

     public void UpdateTeacher(Teacher t){
         teacherdao.updateTeacher(t);
     }
     
    public TeacherDao getTeacherdao() {
        return teacherdao;
    }

    public void setTeacherdao(TeacherDao teacherdao) {
        this.teacherdao = teacherdao;
    }
     
     
    
}
