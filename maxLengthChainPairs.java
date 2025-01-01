
import java.util.Arrays;
import java.util.Comparator;

public class maxLengthChainPairs{
    public static void main(String args[]){

        

    int pairs[][] = {{5,24},{39,28},{5,50},{27,60},{50,90}};

    
        //Sorting the arr using Lambda funtion
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        int max=1;
        
        int lastEnd = pairs[0][1];
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>=lastEnd){
                max++;
                lastEnd=pairs[i][1];
            }
        }
    System.out.println("Maximum Length of Chain Pairs: "+max);
    }
}