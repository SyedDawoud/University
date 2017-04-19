package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;

/**
 *
 * @author Dawoud Ali
 */
public class cloBO {

    CloDao clodao;

    public cloBO() {
        clodao = new CloDao();
    }
// Update via DAO

    public CloDao getClodao() {
        return clodao;
    }

    public void setClodao(CloDao clodao) {
        this.clodao = clodao;
    }

    
    
    public void updateClo(Clo cloId) {

        clodao.updateClo(cloId);

    }

    // Get Only One CLO
    public Clo getClo(int cloId) {

        return clodao.getCloById(cloId);

    }

    // Get the lists of all the employees
    public List<Clo> getAll() {
        return clodao.getAllClos();

    }

    // Adding the Clo
    public void addClo(Clo clo) {
        clodao.addClo(clo);
    }

    // Deleting the Clo

    public void deleteClo(int cloid) {
        clodao.deleteClo(cloid);
    }
}
