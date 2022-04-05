import java.util.Scanner;

public class CoinCombination2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=s.nextInt();
        int [] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(coinComb(arr,n,sum));

    }
    public static int coinComb(int []arr,int n,int x){
        int mod=(int)1e9 +7;
        int dp[]=new int[x+1];
        dp[0] = 1;
        for ( int c: arr)
        {
            for( int i=1;  i<=x;  i++)
            {
                if( i - c >= 0)
                {
                    dp[i] += dp[i-c];
                    dp[i] %= mod;
                }
            }
        }
        return dp[x];













//This gives TLE


//     int dp[][]=new int[n+1][x+1];
//     for(int i=1;i<=n;i++){
//         for(int sum=0;sum<=x;sum++){
//             if(sum==0){
//                 dp[i][sum]=1;
//             }
//             else{
//                 int op1=(arr[i]>sum)?0:dp[i][sum-arr[i]];
//                 int op2=(i==1)?0:dp[i-1][sum];
//                 dp[i][sum]=(op1+op2)%mod;             }
//         }
//
//     }
//
//
//     return dp[n][x];
    }
}
