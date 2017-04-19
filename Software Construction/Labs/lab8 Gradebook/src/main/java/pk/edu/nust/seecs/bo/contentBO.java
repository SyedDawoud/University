package pk.edu.nust.seecs.bo;

import java.util.List;
import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;

/**
 *
 * @author Dawoud Ali
 */
public class contentBO {
    
    ContentDao dao;
    
    public contentBO() {
        dao = new ContentDao();
    }
// Update via DAO

    public void updateClo(Content cloId) {
        
        dao.updateContent(cloId);
        
    }

    public ContentDao getDao() {
        return dao;
    }

    public void setDao(ContentDao dao) {
        this.dao = dao;
    }
    

    // Get Only One CLO
    public Content getClo(int cloId) {
        
        return dao.getContentById(cloId);
        
    }

    // Get the lists of all the employees
    public List<Content> getAll() {
        return dao.getAllContents();
        
    }

    // Adding the Clo
    public void addContent(Content content) {
        dao.addContent(content);
    }

    // Deleting the Clo
    public void deleteContent(int contentid) {
        dao.deleteContent(contentid);
    }
}
