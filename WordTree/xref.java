//xref.java
//Implements Tree.java and Queue.java 

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        boolean debug = true;
        int index = 0;
        String filename;

        if(args.length == 2 && args[0].equals("-d")){
            debug = true;
            index = 1;
        }else if(args.length == 2 && !args[0].equals("-d")){
            System.out.println("Usage: xref [-d] filename");
            System.exit(1);
        }else {
            debug = false;
            index = 0;
        }



        filename = args[index];
        


        try {
            processFile(filename, debug);
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
        }
        auxlib.exit();
    }

}

