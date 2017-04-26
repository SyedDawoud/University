/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Grade;

/**
 *
 * @author Dawoud Ali
 */
public class gradeBO {
    
    private GradeDao gradedao;
    
    
    public Grade findGrade(int id){
        return gradedao.getGradeById(id);
    }
    
    public List<Grade> allGrades(){
        return gradedao.getAllGrades();
    }
    
     public Grade saveGrade(String name, int score, Content c) {
        Grade grade = new Grade();
        grade.setName(name);
        grade.setScore(score);
        grade.setContentItem(c);
        gradedao.addGrade(grade);
        return grade;

    }
     
     public void UpdateGrade(Grade grade){
         gradedao.updateGrade(grade);
     }

    public GradeDao getGradedao() {
        return gradedao;
    }

    public void setGradedao(GradeDao gradedao) {
        this.gradedao = gradedao;
    }
     
     
}
