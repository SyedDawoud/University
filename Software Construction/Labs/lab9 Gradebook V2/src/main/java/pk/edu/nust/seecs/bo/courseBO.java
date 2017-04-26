package pk.edu.nust.seecs.bo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 *
 * @author Dawoud Ali
 */
public class courseBO {

    private CourseDao coursedao;

    public Course findCourse(int id) {
        return coursedao.getCourseById(id);
    }

    //    Course Can't be saved without Teacher
    public Course saveCourse(String title, Date start, Date end, int credit, Teacher t) {
        Course c = new Course();
        c.setClasstitle(title);
        c.setStartsOn(start);
        c.setEndsOn(end);
        c.setCreditHours(credit);
        c.setTeacher(t);
        coursedao.addCourse(c);
        return c;

    }

    public List<Course> allCourses(){
        return coursedao.getAllCourses();
    }
    
    
    //     Course Updation With Content
    public Course updateCourseWithContents(int id, Set<Content> content) {
        Course c = coursedao.getCourseById(id);
        c.setContents(content);
        coursedao.updateCourse(c);
        return c;

    }
//    Course Updation with Students

    public Course updateCourseWithStudents(int id, Set<Student> student) {
        Course c = coursedao.getCourseById(id);
        c.setStudents(student);
        coursedao.updateCourse(c);
        return c;
    }
    
    
    public void UpdateCourse(Course c){
        coursedao.updateCourse(c);
    }

    public CourseDao getCoursedao() {
        return coursedao;
    }

    public void setCoursedao(CourseDao coursedao) {
        this.coursedao = coursedao;
    }

}
