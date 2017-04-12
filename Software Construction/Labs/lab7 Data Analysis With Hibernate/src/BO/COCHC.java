
package BO;
import java.util.ArrayList;
import java.util.List;
import lab7dataanalysis.DAO;
import lab7dataanalysis.Data;

/**
 *
 * @author Dawoud Ali
 */

public class COCHC {
    
    float mean_percentage_challenge;
    float standard_deviation_per_challenge;
    ArrayList<Float> mean_per_round;
    float standard_deviation_rounds;
    
    
    float mean_correct_login_time;
    
    float overAllError;
    float correctPasswords;
    
    List<Data> results;
    DAO access;
    public COCHC(){
        access=new DAO();
        mean_per_round=new ArrayList<Float>();
    }
    
    public void showNotInScheme(){
        results=access.getNotInCurrentScheme("CO-CHC");
        for(Data data:results){
            System.out.println(data.getScheme());
            System.out.println(data.getId());
            System.out.println(data.getUserid());
            
        }
        
    }

    
    
    public void sdRound(){
        standard_deviation_rounds=access.SDRound("CO-CHC");
    }
    
    
    public void sdChallenge(){
        standard_deviation_per_challenge=access.SDRoundCorrectness("CO-CHC");
    }
    
    
    public void meanError(){
        overAllError=access.OverAllError("CO-CHC");
        
    }
    
    
    public void meanCorrectLoginTime(){
        mean_correct_login_time=access.meanTaskG("CO-CHC");
    }
    
    public void CorrectPass(){
        correctPasswords=access.correctPasswordInput("CO-CHC");
    }

    public float getMean_correct_login_time() {
        return mean_correct_login_time;
    }

    public void setMean_correct_login_time(float mean_correct_login_time) {
        this.mean_correct_login_time = mean_correct_login_time;
    }

    
    public float getCorrectPasswords() {
        return correctPasswords;
    }

    public void setCorrectPasswords(float correctPasswords) {
        this.correctPasswords = correctPasswords;
    }
    
    
    
    

    public float getOverAllError() {
        return overAllError;
    }

    public void setOverAllError(float overAllError) {
        this.overAllError = overAllError;
    }
    
    
    
    public float getMean_percentage_challenge() {
        return mean_percentage_challenge;
    }

    public void setMean_percentage_challenge(float mean_percentage_challenge) {
        this.mean_percentage_challenge = mean_percentage_challenge;
    }

    public float getStandard_deviation_per_challenge() {
        return standard_deviation_per_challenge;
    }

    public void setStandard_deviation_per_challenge(float standard_deviation_per_challenge) {
        this.standard_deviation_per_challenge = standard_deviation_per_challenge;
    }

    public ArrayList<Float> getMean_per_round() {
        return mean_per_round;
    }

    public void setMean_per_round(ArrayList<Float> mean_per_round) {
        this.mean_per_round = mean_per_round;
    }

    public float getStandard_deviation_rounds() {
        return standard_deviation_rounds;
    }

    public void setStandard_deviation_rounds(float standard_deviation_rounds) {
        this.standard_deviation_rounds = standard_deviation_rounds;
    }
    
    
    
    public void MeanPerChallenge(){
        
       mean_percentage_challenge=access.meanOfChallenge("CO-CHC");
    }
    
    public void MeanPerRound(){
        mean_per_round=access.meanOfRound("CO-CHC");
    }

    public float getMean_percentage_round() {
        return mean_percentage_challenge;
    }

    public void setMean_percentage_round(float mean_percentage_round) {
        this.mean_percentage_challenge = mean_percentage_round;
    }

    public List<Data> getResults() {
        return results;
    }

    public void setResults(List<Data> results) {
        this.results = results;
    }

    public DAO getAccess() {
        return access;
    }

    public void setAccess(DAO access) {
        this.access = access;
    }
    
    
}
