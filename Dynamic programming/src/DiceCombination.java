import java.util.Scanner;

public class DiceCombination {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(dice(n));
    }
    public static  int dice(int n){
        if(n==0){
            return 1;
        }
        int mod=1000000007;

        int []dp=new int[n+1];
        dp[0]=1;
        for(int i=0;i<n+1;i++){

            for (int x=1;x<=6;x++){
                if(x>i)break;
                dp[i]=(dp[i]+dp[i-x])%mod;
            }

        }
        return dp[n];
    }



}
