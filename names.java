import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


 class Name{

    private String n;
    private int d;

    public String getName(){
        return n;

    }
    public Integer gInteger(){
        return d;
    }

    public Name(String name, int i){
        n=name;
        d=i;
    }

}

 class rNumeral{
        public int numeral(char i){
        if(i=='I'){
            return 1;}
        if(i=='V'){
            return 5;}
        if(i=='X'){
            return 10;}
        if(i=='L'){
            return 50;}
            else{return 0;}
    }

   public int decimal(String value){
        int result = 0;
        for (int i=0; i<value.length();i++){
            int va1 = numeral(value.charAt(i));
            if (i+1<value.length()){
                int va2 = numeral(value.charAt(i+1));
                if (va1>=va2){
                    result+=va1;
                }else{
                    result=-result - va1;
                    
                }
        
        }else{
            result+=va1;
        }
        }
        return result;
    }
}

public class Solution {

    // Complete the getSortedList function below.
    static List<String> getSortedList(List<String> names) {
        List<Name> sorted = new ArrayList<Name>();
        for(int i=0; i< names.size(); i++){
            String str = names.get(i);
            String[] split = str.split("\\s+");
            rNumeral r = new rNumeral();
            Name name = new Name(split[0],r.decimal(split[1]));
        }
        Collections.sort(names, new Comparator<String>() {
         public int compare( String s1, String s2){
            String[] split1 = s1.split("\\s+");
            String[] split2 = s2.split("\\s+");
            rNumeral r = new rNumeral();
             String n1 = split1[0];
             String n2 = split2[0];
             int sComp = n1.compareTo(n2);

             if(sComp!=0){
                 return sComp;
             }

            Integer r1 = r.decimal(split1[1]);
            Integer r2 = r.decimal(split2[1]);

             return r1.compareTo(r2);
         }   
        });
return names;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int namesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < namesCount; i++) {
            String namesItem = bufferedReader.readLine();
            names.add(namesItem);
        }

        List<String> res = getSortedList(names);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(res.get(i));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}