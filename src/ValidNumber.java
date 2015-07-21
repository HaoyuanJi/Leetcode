import java.util.regex.*;


public class ValidNumber {
    public static boolean isNumber(String s) {
    	String check = s.trim();
    	if(check == null || check.equals("") || check.equals(".")) return false;
    	Pattern p_1 = Pattern.compile("^([+-]?)\\d+$");
    	Matcher m_1 = p_1.matcher(check);
    	boolean is_int = m_1.matches();
    	
    	Pattern p_2 = Pattern.compile("^(\\d+)?(\\.)(\\d+)?$");
    	Matcher m_2 = p_2.matcher(check);
    	boolean is_float1 = m_2.matches();
    	
    	Pattern p_3 = Pattern.compile("^([+-]{1})(\\d+)(\\.)(\\d+)?$");
    	Matcher m_3 = p_3.matcher(check);
    	boolean is_float2 = m_3.matches();
    	
    	Pattern p_4 = Pattern.compile("^([+-]{1})(\\.)(\\d+)$");
    	Matcher m_4 = p_4.matcher(check);
    	boolean is_float3 = m_4.matches();
    	
    	Pattern p_5 = Pattern.compile("^((\\d+)?(\\.)(\\d+)?[Ee]{1}([+-]?\\d+))$");
    	Matcher m_5 = p_5.matcher(check);
    	boolean is_sci1 = m_5.matches();
    	
    	Pattern p_6 = Pattern.compile("^(([+-]{1})(\\d+)(\\.)(\\d+)?[Ee]{1}([+-]?\\d+))$");
    	Matcher m_6 = p_6.matcher(check);
    	boolean is_sci2 = m_6.matches();
    	
    	Pattern p_7 = Pattern.compile("^(([+-]{1})(\\.)(\\d+)[Ee]{1}([+-]?\\d+))$");
    	Matcher m_7 = p_7.matcher(check);
    	boolean is_sci3 = m_7.matches();
    	
    	Pattern p_8 = Pattern.compile("^(([+-]?)\\d+[Ee]{1}([+-]?\\d+))$");
    	Matcher m_8 = p_8.matcher(check);
    	boolean is_sci4 = m_8.matches();
    	
    	Pattern p_9 = Pattern.compile("^([+-]?)\\.$");
    	Matcher m_9 = p_9.matcher(check);
    	boolean not_good1 = m_9.matches();
    	
    	Pattern p_10 = Pattern.compile("^(([+-]?)\\.[Ee]{1}([+-]?\\d+))$");
    	Matcher m_10 = p_10.matcher(check);
    	boolean not_good2 = m_10.matches();
    	
        return !not_good1 && !not_good2 && (is_int || is_float1 || is_float2 || is_float3 || is_sci1 || is_sci2 || is_sci3 || is_sci4);
    }
	
    public static void main(String args[])
    {
    	System.out.println(isNumber(".e9"));
    }

}
