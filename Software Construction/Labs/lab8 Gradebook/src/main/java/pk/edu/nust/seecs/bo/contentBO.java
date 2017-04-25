package pk.edu.nust.seecs.bo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
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
public class contentBO {
    
    ContentDao contentdao;

//    Saving the Content. It requires Course for successful Save Operation
    public Content saveContent(String title, String description, Date start, Date end, Course c) {
        Content content = new Content();
        content.setTitle(title);
        content.setDescription(description);
        content.setStarttime(start);
        content.setEndtime(end);
        content.setCourse(c);
        contentdao.addContent(content);
        return content;
    }

//    Content Updations related functions
    public Content UpdateContentWith_Students(int id, Set<Student> student) {
        Content content = contentdao.getContentById(id);
        content.setStudents(student);
        contentdao.updateContent(content);
        return content;
        
    }
    
    public Content UpdateContentWith_Grades(int id, Set<Grade> grade) {
        Content content = contentdao.getContentById(id);
        content.setGrades(grade);
        contentdao.updateContent(content);
        return content;
        
    }
    
    public Content UpdateContentWith_Clo(int id, List<Clo> clo) {
        Content content = contentdao.getContentById(id);
        content.setClo(clo);
        contentdao.updateContent(content);
        return content;
    }
//    Just for Simple Update
    public void UpdateContent(Content c) {
        contentdao.updateContent(c);
        
    }
    
    public ContentDao getContentdao() {
        return contentdao;
    }
    
    public void setContentdao(ContentDao contentdao) {
        this.contentdao = contentdao;
    }
    
}
