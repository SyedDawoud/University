package lab7dataanalysis;

import BO.CHC;
import BO.Rogue;
import BO.COCHC;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dawoud Ali
 */
public class Lab7DataAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        CSVParser1 cv = new CSVParser1();
//
//        cv.populateList();
//        DAO dao = new DAO();
//        //dao.saveData(cv.dataList);
//        System.out.println(cv.dataList.size());
        
        Rogue chc=new Rogue();
        chc.MeanPerChallenge();
        chc.MeanPerRound();
        chc.sdRound();
        chc.meanError();
        chc.CorrectPass();
        chc.sdChallenge();
        chc.meanCorrectLoginTime();
        
        ArrayList<Float> fl=chc.getMean_per_round();
        
//        for(float f:fl){
//            System.out.println(f);
//        }
        
        chc.showNotInScheme();
        System.out.println("Mean Percentage Rounds :" +chc.getMean_percentage_round() +" seconds");
        System.out.println("Mean Percentage Rounds :" +chc.getMean_percentage_round() +" seconds");
        System.out.println("Standard Deviation Rounds :" +chc.getStandard_deviation_rounds());
        
        System.out.println("Overall Error :" +chc.getOverAllError() * 100);
        
        System.out.println("Correct Logins :" +chc.getCorrectPasswords());
        System.out.println("SD Challenge :" +chc.getStandard_deviation_per_challenge());
        System.out.println("Time for Correct Login :" +chc.getMean_correct_login_time());
        System.out.println("Done");

    }

}
