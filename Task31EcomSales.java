import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Task31EcomSales {

    int[] product_cat = new int[25000];
    String[] pay_method = new String[25000]; 
    double[] time_on_Site = new double[25000]; 
    int[] clicks = new int[25000];
    String[] date = new String[25000]; 
    int noofrecords =0;
    ArrayList<Integer> ar = new ArrayList<Integer>();
    double value[] = new double[25000];


    public void data() {
          int i=0;
        String l ="";  
        
        FileReader f;
        try {
            f = new FileReader("purchase_details.csv");
            BufferedReader br = new BufferedReader(f);
            l= br.readLine(); 
            while ((l = br.readLine())!= null){
                noofrecords++;
                String[] data = l.split(",");
                product_cat[i] = Integer.parseInt(data[2]);
                pay_method[i] = data[3]; 
                date[i] = data[0];
                value[i] =  Double.parseDouble(data[4]);
                time_on_Site[i] = Double.parseDouble(data[5]);
                clicks[i] = Integer.parseInt(data[6]);
                i++; 
            }
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
    }


    public void unq_prod_categories(){
        int i=0; 
        boolean uniques[] =new boolean[noofrecords];
        int unq_cat[] = new int[noofrecords];
            for(i = 0; i < noofrecords-1; i++) {
                uniques[i] = true;
                for(int j = 0; j < noofrecords-1; j++) {
                    if(product_cat[i] == product_cat[j] && i != j) {
                        uniques[j] = false;
                    }
                }
            } 
        System.out.println("The unique product categories are: ");
        for(int k = 0; k < noofrecords-1; k++) {
            if(uniques[k]) {
                System.out.println(product_cat[k]);
                ar.add(product_cat[k]);            
            }
        }   
    }

    public void daywise_highestProdCat_sales(){

        int count=0; String unq_date;

        boolean uniques[] =new boolean[noofrecords];
            for(int i = 0; i < noofrecords-1; i++) {
                uniques[i] = true;
                for(int j = 0; j < noofrecords-1; j++) {
                    if(date[i].equals(date[j]) && i != j) {
                        uniques[j] = false;
                    }
                }
            } 
            ArrayList<String> ar1 = new ArrayList<String>();
            for(int k = 0; k < noofrecords-1; k++) {
                if(uniques[k]) {
                    System.out.println(date[k]);
                    ar1.add(date[k]);
                }
            }
            System.out.println(ar.size());
            double tempvalue[] = new double[ar.size()];
            for(int i = 0; i < noofrecords-1; i++) {
                for(int k=0; k<ar1.size(); k++){
                    if(ar1.get(k).equals(date[i])){
                        for(int j=0; j< ar.size(); j++){
                            if(ar.get(j).equals(product_cat[i])){
                                tempvalue[j] = tempvalue[j]+ value[i];                              
                            }
                        }        
                    }
                }       
            }
            // int categ[] = new int[ar.size()];

            double temp[] = new double[ar.size()];
            for(int i=0; i<temp.length; i++){
                temp[i] = tempvalue[i];
            }
            Arrays.sort(temp);
            // System.out.println(categ[categ.length-1]);
            int templind=0, temphind=0;
            for(int i=0; i<tempvalue.length -1; i++){
                if(temp[temp.length-1] == tempvalue[i]){
                    temphind=i;
                }
                if(temp[0] == tempvalue[i]){
                    templind=i;
                }
            }

            System.out.println("Daywise highest selling product category is: "+ar.get(temphind));
            System.out.println("Daywise lowest selling product category is: "+ar.get(templind));




                    




                    
                
        } 




    public void preferredModeOFPayments(){

        String payment1 = "credit"; int pay1=0, pay2=0;
        String payment2 = "paypal";

        for(int i=0; i<noofrecords-1; i++){
            if(pay_method[i].equals(payment1)){
                pay1++;
            }
            else pay2++;
        }

        if(pay1>pay2){
            System.out.println("\nPreferred mode of payment for customer is: "+payment1);
        }else System.out.println("\nPreferred mode of payment for customer is: "+payment2);


    }

    public void maxProdCatSales(){

        int categ[] = new int[ar.size()];
        for(int i=0; i<noofrecords-1; i++){

            for(int j=0; j<ar.size()-1; j++){
                if(product_cat[i] == ar.get(j)){
                    categ[j]++; 
                }
            }
        }

        int temp[] = new int[categ.length];
        for(int i=0; i<categ.length-1; i++){
            temp[i] = categ[i];
        }
        Arrays.sort(categ);
        System.out.println(categ[categ.length-1]);
        int tempind=0;
        for(int i=0; i<temp.length -1; i++){
            if(categ[categ.length-1] == temp[i]){
                tempind=i;
            }
        }
        
        System.out.println("\nProduct category which sold maximum number of times is: "+ar.get(tempind));

    }


    public void prodCatMaxnoofsales(){

        double categ[] = new double[ar.size()];
        for(int i=0; i<noofrecords-1; i++){
            for(int j=0; j<ar.size()-1; j++){
                if(product_cat[i] == ar.get(j)){
                    categ[j] = value[i];
                }
            }
        }
        double temp[] = new double[categ.length];
        for(int i=0; i<categ.length-1; i++){
            temp[i] = categ[i];
        }
        Arrays.sort(categ);
        System.out.println(categ[categ.length-1]);
        int tempind=0;
        for(int i=0; i<temp.length -1; i++){
            if(categ[categ.length-1] == temp[i]){
                tempind=i;
            }
        }

        System.out.println("product_category which has generated the maximum amount of total sales is: "+ar.get(tempind));


    }


    public void siteTimeComparisons(){
        double tempgrt15=0.0, templs15=0.0;
        for(int i=0; i<noofrecords-1; i++){
            if(time_on_Site[i] > 15.0){
                tempgrt15 = tempgrt15+ value[i];
            }else{
                templs15 = templs15+ value[i];
            }
        }
        if(tempgrt15>templs15){
            System.out.println("\nSpending more than 15 minutes of time on site generates more sales");
        }
    }

    public void avgnofclicks(){
        int tempclicks=0;
        for(int i=0; i<noofrecords-1; i++){
            tempclicks = tempclicks+ clicks[i];
        }

        int res = tempclicks/noofrecords;
        System.out.println("\navg number of clicks made by the customers before making their purchasing decision are: "+res);
    }














}



