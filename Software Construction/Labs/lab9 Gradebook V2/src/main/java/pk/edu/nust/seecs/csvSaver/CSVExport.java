/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.csvSaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Grade;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 *
 * @author Dawoud Ali
 */
public class CSVExport {

    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Grade> gradeList;
    private List<Course> courseList;
    private List<Content> contentList;
//   Setting up the things to Store

    public CSVExport() {

        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        gradeList = new ArrayList<>();
        courseList = new ArrayList<>();
        contentList = new ArrayList<>();

    }

    public void exportStudents() throws FileNotFoundException {

        PrintWriter print = new PrintWriter(new File("Students.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Id,");
        sb.append("Name, ");
        sb.append("Courses \n");
        for (Student st : studentList) {
            sb.append(st.getStudentId().toString() + ",");
            sb.append(st.getName() + ",");

            for (Course cs : st.getCourses()) {
                sb.append(cs.getClasstitle());
                sb.append(";");

            }
            sb.append("\n");

        }

        print.write(sb.toString());
        print.close();

    }

    public void exportTeachers() throws FileNotFoundException {

        PrintWriter print = new PrintWriter(new File("Teachers.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Id,");
        sb.append("Name, ");
        sb.append("Courses \n");
        for (Teacher st : teacherList) {
            sb.append(st.getTeacherId().toString() + ",");
            sb.append(st.getName() + ",");

            for (Course cs : st.getCourses()) {
                sb.append(cs.getClasstitle());
                sb.append(",");

            }
            sb.append("\n");

        }

        print.write(sb.toString());
        print.close();

    }

    public void exportGrades() throws FileNotFoundException {

        PrintWriter print = new PrintWriter(new File("Grades.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Id,");
        sb.append("Name, ");
        sb.append("Score, ");
        sb.append("Content \n");
        for (Grade st : gradeList) {
            sb.append(st.getGradeId().toString() + ",");
            sb.append(st.getName() + ",");
            sb.append(st.getScore().toString() + ",");

            sb.append(st.getContentItem().getTitle() + " ," + st.getContentItem().getDescription());
            sb.append("\n");

        }

        print.write(sb.toString());
        print.close();

    }

    public void exportCourses() throws FileNotFoundException {

        PrintWriter print = new PrintWriter(new File("Courses.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Id,");
        sb.append("Title, ");
        sb.append("Start, ");
        sb.append("End, ");
        sb.append("Credit Hours, ");
        sb.append("Contents, ");
        sb.append("Teacher, ");
        sb.append("Students \n");
        for (Course st : courseList) {
            sb.append(st.getCourseid().toString() + ",");
            sb.append(st.getClasstitle() + ",");
            sb.append(st.getStartsOn() + ",");
            sb.append(st.getEndsOn() + ",");
            sb.append(st.getCreditHours() + ",");
            for (Content ct : st.getContents()) {
                sb.append(ct.getTitle() + "; " + ct.getDescription() + " ");

            }
            sb.append(",");
            sb.append(st.getTeacher().getName() + ",");

            for (Student student : st.getStudents()) {
                sb.append(student.getName() + " ;");

            }

            sb.append("\n");

        }

        print.write(sb.toString());
        print.close();

    }

    public void exportContents() throws FileNotFoundException {

        PrintWriter print = new PrintWriter(new File("Contents.csv"));
        StringBuilder sb = new StringBuilder();

        sb.append("Id,");
        sb.append("Title, ");
        sb.append("Description, ");
        sb.append("Start, ");
        sb.append("End, ");
        sb.append("Students, ");
        sb.append("Course, ");
        sb.append("Grades, ");
        sb.append("Clo \n ");
        for (Content st : contentList) {
            sb.append(st.getContentId().toString() + ",");
            sb.append(st.getTitle() + ",");
            sb.append(st.getDescription() + ",");
            sb.append(st.getStarttime() + ",");
            sb.append(st.getEndtime() + ",");

            for (Student student : st.getStudents()) {
                sb.append(student.getName() + " ;");

            }
            sb.append(",");

            sb.append(st.getCourse().getClasstitle() + ",");

            for (Grade ct : st.getGrades()) {
                sb.append(ct.getName() + "; " + ct.getScore().toString() + " ");

            }
            sb.append(",");
            for (Clo clo : st.getClo()) {
                sb.append(clo.getName() + " ;");
            }

            sb.append("\n");

        }

        print.write(sb.toString());
        print.close();

    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Content> getCloList() {
        return contentList;
    }

    public void setCloList(List<Content> cloList) {
        this.contentList = cloList;
    }

}
