package pk.edu.nust.seecs.gradebook;

import java.io.FileNotFoundException;
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
import pk.edu.nust.seecs.csvSaver.CSVExport;
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

    public static void main(String[] args) throws FileNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//         Initial Save and Getting each Object Back
        contentBO onlyBo = (contentBO) context.getBean("contentBO");
        studentBO studentbo = (studentBO) context.getBean("studentBO");
        courseBO coursebo = (courseBO) context.getBean("courseBO");
        teacherBO teacherbo = (teacherBO) context.getBean("teacherBO");
        gradeBO gradebo = (gradeBO) context.getBean("gradeBO");
        cloBO clobo = (cloBO) context.getBean("cloBO");

        Student s = studentbo.saveStudent("Syed Dawoud Sheraz");

        Teacher t1 = teacherbo.saveTeacher("Fahad Satti");
        Teacher t2 = teacherbo.saveTeacher("Atifa Kanwal");
        Teacher t3 = teacherbo.saveTeacher("Komal Malik");
        Teacher t4 = teacherbo.saveTeacher("Sohail Iqbal");
        Teacher t5 = teacherbo.saveTeacher("Ayesha Kanwal");
        Teacher t6 = teacherbo.saveTeacher("Imran Malik");

        Course course1 = coursebo.saveCourse("Sc", null, null, 4, t1);
        Course course2 = coursebo.saveCourse("NM", null, null, 3, t2);
        Course course3 = coursebo.saveCourse("TBW", null, null, 2, t3);
        Course course4 = coursebo.saveCourse("FM", null, null, 3, t4);
        Course course5 = coursebo.saveCourse("SQE", null, null, 3, t5);
        Course course6 = coursebo.saveCourse("ML", null, null, 4, t6);

        Clo clo = clobo.saveClo("Clo 1", "Programming Guide", null, null);

        Content content1 = onlyBo.saveContent("Quiz 1", " Quiz 1: JDBC", null, null, course1);
        Content content2 = onlyBo.saveContent("Quiz 1", " Quiz 1: Iterations", null, null, course2);
        Content content3 = onlyBo.saveContent("Quiz 1", " Quiz 1: Seven C", null, null, course3);
        Content content4 = onlyBo.saveContent("Quiz 1", " Quiz 1: Puzzle", null, null, course4);
        Content content5 = onlyBo.saveContent("Quiz 1", " Quiz 1: Buhat Bura Quiz", null, null, course5);
        Content content6 = onlyBo.saveContent("Quiz 1", " Quiz 1: Python", null, null, course6);

        Grade grade1 = gradebo.saveGrade("Quiz 1", 10, content1);
        Grade grade2 = gradebo.saveGrade("Quiz 1", 10, content2);
        Grade grade3 = gradebo.saveGrade("Quiz 1", 10, content3);
        Grade grade4 = gradebo.saveGrade("Quiz 1", 10, content4);
        Grade grade5 = gradebo.saveGrade("Quiz 1", 10, content5);
        Grade grade6 = gradebo.saveGrade("Quiz 1", 10, content6);

//        Updating
        Set<Course> Courses = new HashSet<>(0);
        Set<Course> Courses1 = new HashSet<>(0);
        Set<Course> Courses2 = new HashSet<>(0);
        Set<Course> Courses3 = new HashSet<>(0);
        Set<Course> Courses4 = new HashSet<>(0);
        Set<Course> Courses5 = new HashSet<>(0);
        Set<Course> Courses6 = new HashSet<>(0);

        Courses.add(course1);
        Courses.add(course2);
        Courses.add(course3);
        Courses.add(course4);
        Courses.add(course5);
        Courses.add(course6);

        Courses1.add(course2);
        Courses2.add(course3);
        Courses3.add(course4);
        Courses4.add(course5);
        Courses5.add(course6);
        Courses6.add(course1);

        Set<Student> studs = new HashSet<>(0);
        studs.add(s);

        Set<Content> contentSet = new HashSet<>(0);
        Set<Content> contentSet1 = new HashSet<>(0);
        Set<Content> contentSet2 = new HashSet<>(0);
        Set<Content> contentSet3 = new HashSet<>(0);
        Set<Content> contentSet4 = new HashSet<>(0);
        Set<Content> contentSet5 = new HashSet<>(0);

        contentSet.add(content1);
        contentSet1.add(content2);
        contentSet2.add(content3);
        contentSet3.add(content4);
        contentSet4.add(content5);
        contentSet5.add(content6);

        Set<Grade> gradeSet = new HashSet<>(0);
        Set<Grade> gradeSet1 = new HashSet<>(0);
        Set<Grade> gradeSet2 = new HashSet<>(0);
        Set<Grade> gradeSet3 = new HashSet<>(0);
        Set<Grade> gradeSet4 = new HashSet<>(0);
        Set<Grade> gradeSet5 = new HashSet<>(0);
        gradeSet.add(grade1);
        gradeSet1.add(grade2);
        gradeSet2.add(grade3);
        gradeSet3.add(grade4);
        gradeSet4.add(grade5);
        gradeSet5.add(grade6);

        List<Clo> cloList = new ArrayList<>();
        cloList.add(clo);

////       Saving the Updated Objects
        teacherbo.updateTeacherWithCourses(t2.getTeacherId(), Courses1);
        teacherbo.updateTeacherWithCourses(t3.getTeacherId(), Courses2);
        teacherbo.updateTeacherWithCourses(t4.getTeacherId(), Courses3);
        teacherbo.updateTeacherWithCourses(t5.getTeacherId(), Courses4);
        teacherbo.updateTeacherWithCourses(t6.getTeacherId(), Courses5);
        teacherbo.updateTeacherWithCourses(t1.getTeacherId(), Courses6);

        coursebo.updateCourseWithContents(course1.getCourseid(), contentSet);
        coursebo.updateCourseWithContents(course2.getCourseid(), contentSet1);
        coursebo.updateCourseWithContents(course3.getCourseid(), contentSet2);
        coursebo.updateCourseWithContents(course4.getCourseid(), contentSet3);
        coursebo.updateCourseWithContents(course5.getCourseid(), contentSet4);
        coursebo.updateCourseWithContents(course6.getCourseid(), contentSet5);

        coursebo.updateCourseWithStudents(course1.getCourseid(), studs);
        coursebo.updateCourseWithStudents(course2.getCourseid(), studs);
        coursebo.updateCourseWithStudents(course3.getCourseid(), studs);
        coursebo.updateCourseWithStudents(course4.getCourseid(), studs);
        coursebo.updateCourseWithStudents(course5.getCourseid(), studs);
        coursebo.updateCourseWithStudents(course6.getCourseid(), studs);

        studentbo.updateStudentWithCourses(s.getStudentId(), Courses);

        onlyBo.UpdateContentWith_Grades(content1.getContentId(), gradeSet);
       // onlyBo.UpdateContentWith_Students(content1.getContentId(), studs);
        //onlyBo.UpdateContentWith_Clo(content1.getContentId(), cloList);

        onlyBo.UpdateContentWith_Grades(content2.getContentId(), gradeSet1);
      //  onlyBo.UpdateContentWith_Students(content2.getContentId(), studs);
        //onlyBo.UpdateContentWith_Clo(content2.getContentId(), cloList);

        onlyBo.UpdateContentWith_Grades(content3.getContentId(), gradeSet2);
      //  onlyBo.UpdateContentWith_Students(content3.getContentId(), studs);
        //onlyBo.UpdateContentWith_Clo(content3.getContentId(), cloList);

        onlyBo.UpdateContentWith_Grades(content4.getContentId(), gradeSet3);
      //  onlyBo.UpdateContentWith_Students(content4.getContentId(), studs);
        //onlyBo.UpdateContentWith_Clo(content4.getContentId(), cloList);

        onlyBo.UpdateContentWith_Grades(content5.getContentId(), gradeSet4);
      //  onlyBo.UpdateContentWith_Students(content5.getContentId(), studs);
        //onlyBo.UpdateContentWith_Clo(content5.getContentId(), cloList);

        onlyBo.UpdateContentWith_Grades(content6.getContentId(), gradeSet5);
      //  onlyBo.UpdateContentWith_Students(content6.getContentId(), studs);
        // onlyBo.UpdateContentWith_Clo(content6.getContentId(), cloList);

        CSVExport csv = new CSVExport();
        csv.setStudentList(studentbo.allStudents());
        csv.setTeacherList(teacherbo.allTeacher());
        csv.setGradeList(gradebo.allGrades());
        csv.setCourseList(coursebo.allCourses());
        csv.setCloList(onlyBo.allContent());

        csv.exportStudents();
        csv.exportTeachers();
        csv.exportGrades();
        csv.exportCourses();
        csv.exportContents();
        System.out.println("Done");
    }

}
