/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.bo;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;

/**
 *
 * @author Dawoud Ali
 */
public class cloBO {

    private CloDao clodao;

    public Clo findClo(int id) {
        return clodao.getCloById(id);
    }

    //    The lonesome people
    public Clo saveClo(String name, String description, String plo, String btlevel) {
        Clo clo = new Clo();
        clo.setName(name);
        clo.setDescription(description);
        clo.setPlo(plo);
        clo.setBtLevel(btlevel);
        clodao.addClo(clo);
        return clo;

    }
    public void UpdateClo(Clo c){
        clodao.updateClo(c);
    }

    public CloDao getClodao() {
        return clodao;
    }

    public void setClodao(CloDao clodao) {
        this.clodao = clodao;
    }
    
    
    

}
