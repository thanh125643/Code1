/******************************************************************************
 *  
 *  Generate combinations by transposing adjacent elements using the
 *  Lexicalgraphic algorithm.
 *
 * 
 *  
 *  012   (2 1)
 *  021   (1 0)
 *  201   (2 1)
 *  210   (0 1)
 *  120   (1 2)
 *  102   (0 1)
 *
 ******************************************************************************/
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class LexicalgraphicCombination {

    public Writer fileOut;
    private FileReader reader;
    private Scanner fileIn;
    private Vector<String> m;
    private Vector<Integer> c;
    private int t;
    public LexicalgraphicCombination(String output_name)
    {
        try{
                fileOut = new FileWriter(output_name); 
           }catch(IOException e)
               {    System.out.println(e); }
    }
    public void visit()
    {
    	try{
    		for(int i = 1; i<=t;i++)
    		    fileOut.write("Write code here ");
    		fileOut.write("\n");
    	    
    	}
    	 catch(IOException e)
    	{
    	 	System.out.println(e);
    	}
    }
    public  void comLexicalgraphic(int nt) {
    	
    	//write code here
    }
    
    private boolean readFile(String input_name)
    {
            try
            {
              reader = new FileReader(input_name);
              fileIn = new Scanner(reader);
              m = new Vector<String>();
              while(fileIn.hasNext())
              {
                String  value = fileIn.next();
                m.addElement(value);
              }
              fileIn.close();
            
              return true;
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        return false;
    }
    public static void main(String[] args) {
        
        String input_name = args[0];
        String output_name = args[1];
        int nSubSize = Integer.parseInt(args[2]);
        try{
               LexicalgraphicCombination jt = new LexicalgraphicCombination(output_name);
               jt.readFile(input_name);
               //call your method 
               jt.comLexicalgraphic(nSubSize);
               //
               jt.fileOut.close();
           }
           catch(IOException e)
           {
                System.out.print(e.getMessage());
           }
    }
}
