//TeamSearch.java
//Program has user type name of NBA franchise and it provides them with their 
//contact number.

import java.util.Scanner;
import java.io.*;

class TeamSearch{
    
    public static void main(String[] args) throws IOException{
        
        //declare some variables
        int i = 0;
        int totQ=0, nFound=0;
        String[] names;
        String query, solution;
        Scanner businessDB = new Scanner(new File(args[0]));
        Scanner sc = new Scanner(System.in);

        int arrayLen = businessDB.nextInt();   //declare length of array
 
        names = new String[arrayLen];          //allocate space for array

        businessDB.nextLine();

        
        while(businessDB.hasNext()){            //assign array values
            names[i] = businessDB.nextLine();
            i++;    
        }
        
        sort(names);                          //sort array using mergesort
        
        String[][] records = split(names);    //split the array to form records
        
        while(true){
	        System.out.print("Enter team name for phone number or press enter to quit:");
            query = sc.nextLine();
            
            if(query.length() == 0){
                break;
            }
            
            solution = find(records, query);        //find element using binary search
            System.out.println(solution);
            if(solution.equals("NOT FOUND")){
                nFound++;
            }


            
            totQ++;
        }
    }
    
    //----------------------------------------------------------------------------

    //parts of this code taken from Data Structures & Algorithms in Java(Robert Lafore)
    //use binary search to find element 
    static String find(String[][] X, String target){
        
        int lowerBound = 0;
        int upperBound = X.length - 1;
        int curIn;
        int result;
        String answer;

        while(true){

	        curIn = (lowerBound + upperBound)/2;
            result = target.compareTo(X[curIn][0]);

            if(result == 0){
		        answer = X[curIn][1];
		        break;
            }else if(lowerBound > upperBound){
		        answer = "NOT FOUND";
		        break;
            }else{
                if(result > 0){
		    lowerBound = curIn + 1;
                }else{
		    upperBound = curIn - 1;
                }
            }
        }  
        return answer;  
    }

    //----------------------------------------------------------------------------
    
    //sort an unordered array using merge sort
    static void sort(String[] main){
     
        int i;
        int lenMain = main.length;
        String[] left;
        String[] right;

        if(lenMain >= 2){
            int mid = lenMain/2;

            left = new String[mid];
            right = new String[lenMain - mid];

            for(i=0; i < mid; i++){
		        left[i] = main[i];
            }

            for(i=mid; i<lenMain; i++){
		        right[i-mid] = main[i];
            }

            sort(left);
            sort(right);
            merge(left, right, main);
        }
    }

    //----------------------------------------------------------------------------
 
    //merge the sorted parts of the array
    static void merge(String[] left, String[] right, String[] main){
        
        int lenL = left.length;
        int lenR = right.length;
        int result;
        int i = 0, j = 0, k = 0;
        
        while(i<lenL && j<lenR){
            result = left[i].compareTo(right[j]);
            
            if(result <= 0){
		        main[k] = left[i];
		        i++;
            }else{
		        main[k] = right[j];
		        j++;
            }
            k++;
        }

        while(i<lenL){
	        main[k] = left[i];
	        k++;
	        i++;
        }
        
        while(j<lenR){
	        main[k] = right[j];
	        k++;
	        j++;
        }
    }

    //----------------------------------------------------------------------------
    
    //split the array to create database of records
    static String[][] split(String[] X){
    
        String string;
        String[][] splitArray = new String[X.length][2];

        for(int i=0; i<X.length; i++){
            for(int j=0; j<2; j++){

                string = X[i];
                String[] parts = string.split(",");
                splitArray[i][j] = parts[j];
            }
        }

        return splitArray;
    }
}