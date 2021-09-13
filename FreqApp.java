package week08;

import java.util.*;

public class FreqApp{
    public static void main(String[]args){
        Random r = new Random();
        
        FrequencyGenerator f = new FrequencyGenerator(r);
        System.out.println(f.nextWord(5));
    }
}
