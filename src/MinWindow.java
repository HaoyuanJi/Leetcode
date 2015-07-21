import java.util.*;

public class MinWindow {
    public static String minWindow(String S, String T) {
        if(S == null || S.equals("")) return "";
        if(T == null || T.equals("")) return "";
        HashMap<Character,Integer> match = new HashMap<Character,Integer>();
        HashMap<Character,Integer> count = new HashMap<Character,Integer>();
        
        for(int i = 0; i < T.length(); i++)
        {
            if(match.containsKey(T.charAt(i)))
               match.put(T.charAt(i),match.get(T.charAt(i)) + 1);
            else
               match.put(T.charAt(i),1);
        }
           
        //System.out.println(match.get('a'));
        int Slen = S.length();
        int Tlen = T.length();
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int currentlength = 0;
        String minwin = "";
        
        while(end < Slen)
        {
            Character item = S.charAt(end);
            if(match.containsKey(item))
            {
                if(count.containsKey(item))
                {
                    if(count.get(item) < match.get(item))
                        currentlength++;
                    count.put(item,count.get(item) + 1);
                }
                else
                {
                    count.put(item, 1);
                    currentlength++;
                    
                }
             } 
                if(currentlength == Tlen)
                {
                    Character item_begin = S.charAt(start);
                    while(start < end && (!count.containsKey(item_begin) || count.get(item_begin) > match.get(item_begin)))
                    {
                        if(count.containsKey(item_begin) && count.get(item_begin) > match.get(item_begin))
                             count.put(item_begin, count.get(item_begin)-1);
                        start++;
                        item_begin = S.charAt(start);
                       
                    }
                    if(end - start + 1 < min)
                    {

                        min = end - start + 1;
                        minwin = S.substring(start, end+1);
                    }
                    
                    
                }
            
            end++;
        }
        //System.out.println(min);
        return minwin;
    }
    
    public static void main(String[] args)
    {
    	System.out.println(minWindow("aa","aa"));
    }
}
