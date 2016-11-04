// Queens.java
// Christopher Smith
// List all solutions to n-queens problem

class Queens{


    public static void main(String[] args){
        
        int i, n = 0;
        int y;
        int[] A;
        
        if(args.length == 1){
             n = Integer.parseInt(args[0]);
        }else if(args.length == 2){
            n = Integer.parseInt(args[1]);
        }
        
        //Finds if the user wants the solutions printed
        if(args.length == 0){
            System.out.println("Usage: Queens [-v] number");
            System.out.println("Option: -v  verbose output, print all solutions");
        }

        int[] X = new int[n];
        int x = 0;
        for(int j=X.length-1; j >= 0; j--){
            X[j] = X.length - x;
            x++;
        }

        if(args[0].equals("-v")){
            nextPermutation(X);
        }else {
            nextPermutation1(X);
        }    
    }


    static void nextPermutation(int[] A) {
        
        int count = 0;
        int x = factorial(A.length) - 1;
        for(int y = 0; y < x; y++){

            
            int i = A.length - 1;
            while (i > 0 && A[i - 1] >= A[i])
                i--;
            
            if (i <= 0){
                reverseArray(A);
                i = A.length - 1;
            }
            
            int j = A.length - 1;
            while (A[j] <= A[i - 1])
                j--;
           
            // Swap the pivot with j
            int temp = A[i - 1];
            A[i - 1] = A[j];
            A[j] = temp;


    
            // Reverse the portion after pivot
            j = A.length - 1;
            while (i < j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }

            if(isSolution(A) == true){
                printArray(A);
                count++;
            }
        }
        System.out.println(A.length+"-Queens has "+count+" solutions.");
    
        // Successfully computed the next permutation
    }

    static void nextPermutation1(int[] A) {
        
        int count = 0;
        int x = factorial(A.length) - 1;
        for(int y = 0; y < x; y++){

            
            int i = A.length - 1;
            while (i > 0 && A[i - 1] >= A[i])
                i--;
            
            if (i <= 0){
                reverseArray(A);
                i = A.length - 1;
            }
            
            int j = A.length - 1;
            while (A[j] <= A[i - 1])
                j--;
           
            // Swap the pivot with j
            int temp = A[i - 1];
            A[i - 1] = A[j];
            A[j] = temp;


    
            // Reverse the portion after pivot
            j = A.length - 1;
            while (i < j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }

            if(isSolution(A) == true){
                count++;
            }
        } 
        System.out.println(A.length+"-Queens has "+count+" solutions.");
    
        // Successfully computed the next permutation
    } 


    static boolean isSolution(int[] A) {
        
        int n = A.length;
        int k = n*(n-1)/2;
        int i, j, horDis, vertDis;

        for(i=0; i<n; i++){
            for(j=i+1; j<=(n-1); j++){

                horDis = j-i;
                vertDis = A[j] - A[i];

                if(vertDis < 0){
                    vertDis = vertDis*-1;
                }

                if(horDis == vertDis){
                    return false;
                }

            }
        }
        return true;
    }

    //Helper Functions

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static void printArray(int[] A){
            System.out.print("(");
            for(int i=0; i<A.length; i++){
                System.out.print(A[i]);
                if(i <A.length -1){
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            System.out.println();
        }

    static void reverseArray(int[] A){
        int i =0, j=A.length-1;
        while(i<j){
            swap(A, i, j);
            i++;
            j--;
        }
    } 

    static int factorial(int n){
        int product = 1, i = 1;
        while(i<=n){
            product *= i;
            i++;
        }
        return product;
    } 
}
