import java.util.Scanner;

public class arrayDescription {
    public static void main(String[] args) {
        int mod=(int )1e9+7;
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int dp[][]=new int [m+2][n+2];
        int [] arr= new int[n+1];
        for( int i=1;i<n+1;i++){
            arr[i]=s.nextInt();

        }
        System.out.println(solve(n,m,arr));
    }
    public static int solve(int n,int m,int[] arr){
        int dp[][] = new int[n+2][m+2];
        int mod=(int)1e9+7;
        for(int i=1;i<=n;i++){
            for(int x=1;x<=m;x++){
                if( i==1){
                    if(arr[i]==0||arr[i]==x)
                        dp[i][x]=1;
                    else
                        dp[i][x]=0;
                }else{
                    if(arr[i]==0||arr[i]==x){
                        dp[i][x] = ((dp[i-1][x-1] + dp[i-1][x])%mod + dp[i-1][x+1])%mod;
                    }else{
                        dp[i][x]=0;
                    }
                }
            }
        }
        int ans=0;
        for(int x=1;x<=m;x++){
            ans=(ans+dp[n][x])%mod;
        }
        return ans;
    }
}
