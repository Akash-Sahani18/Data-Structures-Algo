

public class ActivitySelection{
    public static void activity(int si[],int fi[],int n){

        System.out.println("Following Activities Selected");
        int i=0;
        int count=0;
            System.out.print(i+ " ");
                for(int j=1;j<n;j++){
                if(si[j]>=fi[i]){
                    System.out.print(j+" ");
                    ++count;
                    i=j;
            }
        }
        System.out.println();
            System.out.print("Total Activities: "+count+ " ");
    }
    public static void main(String args[]){
        int si[] = {1,3,0,5,8,5};
        int fi[] = {2,4,6,7,9,9};
        int n=si.length;
        activity(si,fi,n);
    }
}