// you can also use imports, for example:
 import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//A brute force approach to finding spare seats. Each possible combination is checked, the spare combos are then capped at 2 if more than 2 exist.

class Solution {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        String str[] = S.split(" ");
        List<String> reserved = new ArrayList<String>();
        int free =0;
        
        reserved= Arrays.asList(str);
        
        for(int i=1; i<=N; i++){
            int spare=0;
            int middle=0;

            if(!reserved.contains(i+"B")&&!reserved.contains(i+"C")&&!reserved.contains(i+"D")&&!reserved.contains(i+"E")){
                spare++;
            }
            if(!reserved.contains(i+"D")&&!reserved.contains(i+"E")&&!reserved.contains(i+"F")&&!reserved.contains(i+"G")){
                
                middle=1;
            }
            if(!reserved.contains(i+"F")&&!reserved.contains(i+"G")&&!reserved.contains(i+"H")&&!reserved.contains(i+"J")){
                spare++;
                                System.out.println("Test"+i);

            }
            if (spare==0 && middle ==1){
                spare=1;
            }
            if(spare>2){
                spare=2;
            }
            free+=spare;
        }
        return free;
    }
}