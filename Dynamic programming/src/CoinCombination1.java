import java.util.Scanner;

public class CoinCombination1 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        int n=s.nextInt();
        int sum=s.nextInt();
        int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
        System.out.println(CoinComb1(arr,n,sum));
    }
    public static int CoinComb1(int [] arr,int n,int x){
        int[] dp=new int[x+1];
        dp[0]=1;
            int mod=(int)1e9+7;
            for (int i = 1; i <= x; i++) {
                dp[i]=0;
                for (int coin_value : arr){
                    if(coin_value<=i)
                        dp[i]=(dp[i]+dp[i-coin_value])%mod;

                }
            }
            return dp[x];

    }
}
