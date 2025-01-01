
import java.util.Arrays;

public class minAbsDiff{
    public static int minSum(int a[],int b[],int n){

            Arrays.sort(a);
            Arrays.sort(b);

            int sum=0;

            for(int i=0;i<n;i++){
                sum += Math.abs(a[i]-b[i]);
            }

        return sum;        
    }
    public static void main(String args[]){
        int a[] ={4,1,8,7};
        int b[] ={2,3,6,5};
        int n = a.length;
        System.out.print("Minimum abslute: "+minSum(a,b,n));
    }
}