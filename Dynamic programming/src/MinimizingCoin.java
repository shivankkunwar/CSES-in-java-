import java.util.Scanner;

public class MinimizingCoin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(coin(n, sum, arr));
    }

    public static int coin(int n, int x, int[] arr) {
        int[] dp=new int[x+1];
        dp[0]=1;

        int mod=(int)1e9+7;
        for (int i = 1; i <= x; i++) {
            dp[i]=0;
            for (int coin_value : arr){
                if(coin_value<=i) {
                    dp[i] = (dp[i] + dp[i - coin_value]) % mod;

                }

            }
        }
        return dp[x];



    }
}