
import java.util.Arrays;
import java.util.Collections;

public class chocolaProblem{
    public static void main(String args[]){
        Integer costVer[] = {2,1,3,1,4};//m-1
        Integer costHor[] = {2,1,4};//n-1
        
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;

        int cost=0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<=costHor[h]){//Vertical Cut
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }else{//Horozontal Cut
                cost += (costVer[v]*hp);
                vp++;  
                v++;
            }
        }
        while(h<costHor.length){ //Remaining Horizontal Cut
            cost += (costHor[h]*vp);
            hp++;
            h++;
        }
        while(v<costVer.length){//Remaining Vertical Cut
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }

        //Minimum Cost of cuts
        System.out.println("Minimum Cost: "+cost);
    }
}