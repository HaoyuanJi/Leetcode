import java.util.ArrayList;
import java.util.Stack;
public class Leetcode1 {	
	
	// The most difficult thing is to trim the space and other annoying details
	 public static String reverseWords(String s) {
	        
		 Stack<String> tempsen = new Stack<String>();
	        char[] temp = s.toCharArray();
	        ArrayList<Character> word = new ArrayList<Character>();
	        StringBuffer sb = new StringBuffer();
	        int countspace = 0;
	        boolean start = false;
	        
	        for(int i = 0; i< temp.length; i++)
	        {
	           char letter = temp[i];
	           if(letter==' ')
	           {
	           	   countspace++;
	               if(countspace > 1 || start == false)
	               {
                     continue;
	               }
	               else{
	        	      for (char cc:word)
	        	      {
	        		    sb.append(cc);
	        	      }
	                  String tempword = sb.toString();
	                  tempsen.push(tempword);
	                  sb = new StringBuffer();
	                  word.clear();
	               }
	           }
	           else
	           {
	           	   start = true;
	           	   countspace = 0;
	               word.add(letter);
	           }
	        }
	   if(!word.isEmpty())
	   {
  	   for (char cc:word)
  	   {
  		   sb.append(cc);
  	   }
        String tempword = sb.toString();
        tempsen.push(tempword);
	   }    
	        StringBuffer sb2 = new StringBuffer();
	        
	        while(!tempsen.empty())
	        {
	            String newword = tempsen.pop();
	            sb2.append(newword);
	            sb2.append(' ');
	        }
	        
	        if (sb2.length()>0)
	        {
	         sb2.deleteCharAt(sb2.length()-1);
	        }
	        return sb2.toString();
	        
	    }
	 
	 public static void main(String args[])
	 {
		 String input = "jijoji  uy rttnnnp juipi o hyo drdtdrtdt ftyu";
		 String output = reverseWords(input);
		 System.out.print(output);
		 
	 }

}
