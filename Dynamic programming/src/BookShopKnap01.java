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

//        for(int i=1;i<=n;i++)
//        {
//            for(int j=0;j<=x;j++)
//            {
//                //option1 = book number i-1 is not included, hence no pages added.
//                //option2 = book number i-1 is included, hence pages are added.
//                //option1 = dp[i-1][j] ...book not included so total price(j) remains same.
//                //option2 = dp[i-1][j-price[i-1]] + page[i-1]....total price(j) decreased and pages are counted for book i-1.
//
//                dp[i][j] = dp[i-1][j];
//                if(j >= cost[i-1])
//                {
//                    dp[i][j] =Math.max (dp[i][j],dp[i-1][j-cost[i-1]] + pages[i-1]); //max of both the boxes included in dp[i][j].
//                }
//            }
//        }
//        return dp[n][x];


//

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