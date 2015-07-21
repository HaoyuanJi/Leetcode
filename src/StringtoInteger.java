
public class StringtoInteger {
	   public static int atoi(String str) {
	        String removewhite = str.trim();
	        
	         //Pattern p = Pattern.compile("\\d+");
	        /// Matcher m = p.matcher(removewhite);
	        // if(m.matches() == false) return 0;
	        if(removewhite == null || removewhite.equals("")) return 0;
	        
	        boolean ifnegative = false;
	        if(removewhite.charAt(0) == '-')
	        {
	            ifnegative = true;
	            removewhite = removewhite.substring(1);
	        }
	        else if(removewhite.charAt(0) == '+')
	            removewhite = removewhite.substring(1);
	        
	        if(removewhite.charAt(0) > '9' || removewhite.charAt(0) < '0')
            {
               return 0;
            }
	           
	        //System.out.println(removewhite);
	        long result = 0;
	        long multi = 1;
	        for(int i = removewhite.length() - 1; i >= 0; i--)
	        {
	            if(removewhite.charAt(i) > '9' || removewhite.charAt(i) < '0')
	            {
	                result = 0;
	                multi = 1;
	                continue;
	            }
	            
	            result += (removewhite.charAt(i) - '0') * multi;
	            System.out.println(result);
	            multi *= 10;
	            
	            if(result > Integer.MAX_VALUE) 
	            {
	            	
	            	if(ifnegative)
	                   result = Integer.MAX_VALUE + 1;
	            	else
	            		result = Integer.MAX_VALUE;
	                break;
	            }
	        }
	        return ifnegative? (int)-result:(int)result;
	        
	    }
	   
	   public static void main(String[] args)
	   {
		   System.out.println(atoi("    10522545459"));
		   //System.out.println(Integer.MAX_VALUE);
	   }

}
