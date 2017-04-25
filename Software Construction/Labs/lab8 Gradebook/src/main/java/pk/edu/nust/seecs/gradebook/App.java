package pk.edu.nust.seecs.gradebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pk.edu.nust.seecs.bo.cloBO;
import pk.edu.nust.seecs.bo.contentBO;
import pk.edu.nust.seecs.bo.courseBO;
import pk.edu.nust.seecs.bo.gradeBO;
import pk.edu.nust.seecs.bo.studentBO;
import pk.edu.nust.seecs.bo.teacherBO;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Grade;
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
//         Initial Save and Getting each Object Back
        contentBO onlyBo = (contentBO) context.getBean("contentBO");
        studentBO studentbo = (studentBO) context.getBean("studentBO");
        courseBO coursebo = (courseBO) context.getBean("courseBO");
        teacherBO teacherbo = (teacherBO) context.getBean("teacherBO");
        gradeBO gradebo = (gradeBO) context.getBean("gradeBO");
        cloBO clobo = (cloBO) context.getBean("cloBO");
        Student s = studentbo.saveStudent("Dravid part 2");
        Teacher t = teacherbo.saveTeacher("Drago");
        Course course = coursebo.saveCourse("Sc", null, null, 3, t);
        Clo clo = clobo.saveClo("Clo 1", "Programming Guide", null, null);
        Content content = onlyBo.saveContent("Quiz 1", " Quiz 1: Loops", null, null, course);
        Grade grade = gradebo.saveGrade("Quiz 1", 10, content);

//        Updating
        Set<Course> Courses = new HashSet<>(0);
        Courses.add(course);
        Set<Student> studs = new HashSet<>(0);
        studs.add(s);
        Set<Content> contentSet = new HashSet<>(0);
        contentSet.add(content);

        Set<Grade> gradeSet = new HashSet<>(0);
        gradeSet.add(grade);

        List<Clo> cloList = new ArrayList<>();
        cloList.add(clo);

//       Saving the Updated Objects
        teacherbo.updateTeacherWithCourses(t.getTeacherId(), Courses);

        s = studentbo.updateStudentWithCourses(s.getStudentId(), Courses);

        coursebo.updateCourseWithContents(course.getCourseid(), contentSet);
        coursebo.updateCourseWithStudents(course.getCourseid(), studs);

        onlyBo.UpdateContentWith_Grades(content.getContentId(), gradeSet);
        onlyBo.UpdateContentWith_Students(content.getContentId(), studs);
        onlyBo.UpdateContentWith_Clo(content.getContentId(), cloList);

        System.out.println(s.toString());
        System.out.println("Done");
    }

}
