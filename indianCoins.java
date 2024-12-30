import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class indianCoins{
    public static void main(String args[]){

        Integer deno[] = {1,2,5,10,20,50,100,500,2000};
           int amt=121;

        Arrays.sort(deno, Comparator.reverseOrder());
        
        ArrayList<Integer> ans = new ArrayList<>();

            int count=0;
            for(int i=0;i<deno.length;i++){
                if(deno[i]<=amt){
                    while(deno[i]<=amt){
                        ans.add(deno[i]);
                        count++;
                        amt-=deno[i];
                    }
                }
            }
        System.out.println("Total deno Count:"+count);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}