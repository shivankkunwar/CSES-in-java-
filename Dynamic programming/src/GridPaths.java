import java.util.Scanner;

public class GridPaths
{
    public static void main(String[] args) {


    Scanner s=new Scanner(System.in);

    int n=s.nextInt();
    int [][] arr=new int[ n+1][n+1];
        for(int i=1;i<n+1;i++){
    String str=" "+s.next();

    char [] ch=str.toCharArray();//taking String as input as its given without space

    for(int j=1;j<n+1;j++){
        if(ch[j]=='.'){
            arr[i][j]=0;

        }else {
            arr[i][j] = 1;
        }

    }}

        System.out.println(GridPaths(arr,n));

}
    public static int GridPaths(int [][] arr ,int n){
        int [][]dp=new int [n+1][n+1];
        int mod=(int)1e9+7;

        for(int i=n;i>=1;i--){
            for(int j=n;j>=1;j--){

                if(i==n&&j==n){
                    dp[i][j]=1;
                }else{
                    int ob1=(i==n)?0:dp[i+1][j];
                    int ob2=(j==n)?0:dp[i][j+1];
                    dp[i][j]=(ob1+ob2)%mod;
                    if(arr[i][j]==1){
                        dp[i][j]=0;
                    }
                }
            }
        }
        if(arr[n][n]==1){
            return 0;
        }else{
            return dp[1][1];
        }

    }
}
