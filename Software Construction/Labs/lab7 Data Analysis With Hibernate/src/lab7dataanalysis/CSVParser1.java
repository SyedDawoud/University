/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7dataanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dawoud Ali
 */
public class CSVParser1 {

    ArrayList<Data> dataList;

    public CSVParser1() {
        dataList = new ArrayList<Data>();
    }

    public void populateList() throws FileNotFoundException, IOException {

        String filePath = "src/lab7dataanalysis/test_two-anon.csv";
        String fileToParse;

        BufferedReader buffer = new BufferedReader(new FileReader(filePath));
        File file = new File(filePath);

        Data cr = new Data();

        String txt;
        buffer.readLine();
        buffer.readLine();
        while ((txt = buffer.readLine()) != null) {

            String[] fulldata = txt.split(",");

//            Special Check to see that whether the value is zero or not
//            If not, set the total Time Taken Accordingly
            try {
                String[] check = fulldata[3].split("\"");
                if (Float.parseFloat(check[1]) == 0) {
                    continue;
                } else {
                    cr.setTimeTotal(Float.parseFloat(check[1]));
                    //System.out.println(check[1]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTimeTotal(0);
            }

//            Id Setting
            cr.setUserid(fulldata[0]);

//  Scheme Setting
            try {
                String[] check = fulldata[2].split("\"");
                cr.setScheme(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setScheme("");
            }

            //  Final Status Setting 
            try {
                String[] check = fulldata[4].split("\"");
                cr.setStatusFinal(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatusFinal("");
            }

            //   Status 1 Setting 
            try {
                String[] check = fulldata[7].split("\"");
                cr.setStatus1(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus1("");
            }

            //  Status  2 Setting 
            try {
                String[] check = fulldata[10].split("\"");
                cr.setStatus2(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus2("");
            }

            //   Status 3 Setting 
            try {
                String[] check = fulldata[13].split("\"");
                cr.setStatus3(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus3("");
            }

            //   Status 4 Setting 
            try {
                String[] check = fulldata[16].split("\"");
                cr.setStatus4(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus4("");
            }

            //   Status 5 Setting 
            try {
                String[] check = fulldata[19].split("\"");
                cr.setStatus5(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus5("");
            }

            //   Status 6 Setting 
            try {
                String[] check = fulldata[22].split("\"");
                cr.setStatus6(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus6("");
            }

            //   Status 7 Setting 
            try {
                String[] check = fulldata[25].split("\"");
                cr.setStatus7(check[1]);

            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setStatus7("");
            }
            
            
            
//       Time 1 Setting is Done Here
            
       try {
                String[] check = fulldata[6].split("\"");
               
                    cr.setTime1(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime1(0);
            }      
       
       //       Time 2 Setting is Done Here
            
       try {
                String[] check = fulldata[9].split("\"");
               
                    cr.setTime2(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime2(0);
            }      
      
       
       //       Time 3 Setting is Done Here
            
       try {
                String[] check = fulldata[12].split("\"");
               
                    cr.setTime3(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime3(0);
            }      
      
       
       //       Time 4 Setting is Done Here
            
       try {
                String[] check = fulldata[15].split("\"");
               
                    cr.setTime4(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime4(0);
            }      
      
       
       //       Time 5 Setting is Done Here
            
       try {
                String[] check = fulldata[18].split("\"");
               
                    cr.setTime5(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime5(0);
            }      
      
       
       //       Time 6 Setting is Done Here
            
       try {
                String[] check = fulldata[21].split("\"");
               
                    cr.setTime6(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime6(0);
            }      
      
       
       //       Time 7 Setting is Done Here
            
       try {
                String[] check = fulldata[24].split("\"");
               
                    cr.setTime7(Float.parseFloat(check[1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cr.setTime7(0);
            }      
      
      
              
            dataList.add(cr);
            cr = new Data();

        }

    }

}
