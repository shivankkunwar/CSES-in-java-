import java.util.Scanner;

public class RemovingDigits {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(DigitRemove(n));
    }
    public static  int DigitRemove(int n){
        int [] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            int minSteps=Integer.MAX_VALUE;
            while(temp!=0){
                int di=temp%10;
                temp=temp/10;
                if(di==0)continue;
                minSteps=Math.min(minSteps,1+dp[i-di]);
            }
            dp[i]=minSteps;
        }
        return dp[n];
    }
}
