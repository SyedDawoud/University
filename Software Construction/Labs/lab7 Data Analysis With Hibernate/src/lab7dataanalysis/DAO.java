package lab7dataanalysis;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dawoud Ali
 */
public class DAO {

    public Session current_session = null;

    public DAO() {
        HibernateUtil.createSessionFactory();
        current_session = HibernateUtil.getSessionFactory().openSession();
    }

    public void saveData(ArrayList<Data> data) {

        Transaction t = current_session.beginTransaction();
        for (Data onePiece : data) {
//            Query query = current_session.createQuery("update Data set userid=?");
//            query.setParameter(0, onePiece.getUserid());
//            int status = query.executeUpdate();
//            System.out.println(status);
            current_session.persist(onePiece);

        }
        t.commit();

    }

    public List<Data> getNotInCurrentScheme(String scheme) {

        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.ne("scheme", scheme));
        return query.list();

    }

//     Mean True Time of Each Round
    public ArrayList<Float> meanOfRound(String scheme) {

        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();
        ArrayList<Float> time = new ArrayList<Float>();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {
            if (d.getStatus1().equals("TRUE") == true) {
                sum += d.getTime1();
            }

            if (d.getStatus2().equals("TRUE") == true) {
                sum += d.getTime2();
            }

            if (d.getStatus3().equals("TRUE") == true) {
                sum += d.getTime3();
            }

            if (d.getStatus4().equals("TRUE") == true) {
                sum += d.getTime4();
            }

            if (d.getStatus5().equals("TRUE") == true) {
                sum += d.getTime5();
            }

            mean_per_round += ((sum / 5));
            time.add(mean_per_round);
            sum = 0;
            mean_per_round = 0;
            total++;

        }
        return time;

    }

//    Gives Overall Mean of the total TRUE Challenges in the current Scheme
    public float meanOfChallenge(String scheme) {
        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {
            if (d.getStatus1().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus2().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus3().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus4().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus5().equals("TRUE") == true) {
                sum += 1;
            }

            mean_per_round += ((sum / 5));
            sum = 0;

            total++;

        }
        return mean_per_round / total;
    }

//     SD Of the Round i.e. based on the challenge
    public float SDRound(String scheme) {

        float mean = this.meanOfChallenge(scheme);

        float sd = 0;
        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {

            if (d.getStatus1().equals("TRUE") == true) {
                sum += d.getTime1();
            }

            if (d.getStatus2().equals("TRUE") == true) {
                sum += d.getTime2();
            }

            if (d.getStatus3().equals("TRUE") == true) {
                sum += d.getTime3();
            }

            if (d.getStatus4().equals("TRUE") == true) {
                sum += d.getTime4();
            }

            if (d.getStatus5().equals("TRUE") == true) {
                sum += d.getTime5();
            }

            mean_per_round += ((sum / 5));

            sd += Math.pow((mean - mean_per_round), 2);
            sum = 0;
            mean_per_round = 0;

            total++;

        }

        return (float) (Math.sqrt(sd / total));

    }
    
    
    
     public float SDRoundCorrectness(String scheme) {

        float mean = this.meanOfChallenge(scheme);

        float sd = 0;
        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {

            if (d.getStatus1().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus2().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus3().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus4().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus5().equals("TRUE") == true) {
                sum += 1;
            }
            
            if (d.getStatus6().equals("TRUE") == true) {
                sum += 1;
            }
            
            if (d.getStatus7().equals("TRUE") == true) {
                sum += 1;
            }

            mean_per_round += ((sum / 7));

            sd += Math.pow((mean - mean_per_round), 2);
            sum = 0;
            mean_per_round = 0;

            total++;

        }

        return (float) (Math.sqrt(sd / total));

    }
     
     
     
     public float meanTaskG(String scheme){
         Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {
            if (d.getStatusFinal().equals("TRUE") == true) {
                sum += d.getTimeTotal();
            }     

            total++;

        }
        return sum / total;
         
     }
    

//     Task H 
    public float OverAllError(String scheme) {

        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {
            if (d.getStatus1().equals("FALSE") == true) {
                sum += 1;
            }

            if (d.getStatus2().equals("FALSE") == true) {
                sum += 1;
            }

            if (d.getStatus3().equals("FALSE") == true) {
                sum += 1;
            }

            if (d.getStatus4().equals("FALSE") == true) {
                sum += 1;
            }

            if (d.getStatus5().equals("TRUE") == true) {
                sum += 1;
            }

            if (d.getStatus5().equals("FALSE") == true) {
                sum += 1;
            }

            if (d.getStatus5().equals("FALSE") == true) {
                sum += 1;
            }

            mean_per_round += ((sum / 7));
            sum = 0;

            total++;

        }
        return mean_per_round / total;

    }
    
//     Task f
    public float correctPasswordInput(String scheme) {

        Criteria query = current_session.createCriteria(Data.class);
        query.add(Restrictions.eq("scheme", scheme));

        List<Data> dataList = query.list();

        float sum = 0;
        float total = 0;

        float mean_per_round = 0;

        for (Data d : dataList) {
            if (d.getStatusFinal().equals("TRUE") == true) {
                sum += 1;
            }     

            total++;

        }
        return sum / total;

    }
    
    
    

}
