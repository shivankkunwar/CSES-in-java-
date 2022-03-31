import java.util.Scanner;

public class BookShopKnap01 {//giving TLE
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n=s.nextInt();
        int x= s.nextInt();
        int [] cost=new int[n+1];
        int [] pages= new int[n+1];
        for(int i=1;i<=n;i++){
            cost[i]=s.nextInt();
        }
        for (int i=1;i<=n;i++){
            pages[i]=s.nextInt();
        }
        System.out.println(Book(cost,pages,n,x));

    }
    public  static  int  Book(int []cost,int []pages,int n,int x){
        int dp[][]= new int[n+1][x+1];



        for(int i=0;i<=n;i++){
            for(int money=0;money<=x;money++){
                if(i==0||money==0){
                    dp[i][money]=0;
                }else{
                    int op1=(i==1)?0:(dp[i-1][money]);
                    int op2=(money<cost[i])?0:pages[i]+dp[i-1][money-cost[i]];
                    dp[i][money]=Math.max(op1,op2);
                }
            }
        }
        return dp[n][x];
//

    }
}
