package GRAPH;

import java.util.Scanner;

public class _9466 {
	//TODO 어렵다 어려워 다음에 또 복습하도록 하자
	// 이 소스는 베낀 소스이다.
	// http://haloworld.tistory.com/104
	
	static int a[]; //입력받는 배열
    static int check[]; //방문 check(시작에서부터 몇번째로 방문되는 것인지)
    static int startVertex[];   //시작정점
     
    static int dfs(int cur, int cnt, int start){
        /*이미 방문했던 정점이고
         * 시작정점이 start와 다르면 start 정점은 사이클 외에 있는 정점이므로 0을 리턴,
         * 아니면 (현재 cnt - start로부터 몇번째로 방문한 정점인지) 리턴
         */
        if(check[cur]!=0){ 
            if(start!=startVertex[cur])
                return 0;
            return cnt-check[cur];
        }
         
        check[cur]=cnt;
        startVertex[cur]=start;
        return dfs(a[cur],cnt+1, start);
    }
     
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
         
        while(t-- > 0)
        {
            int n=sc.nextInt();
            a=new int[n+1];
            check=new int[n+1];
            startVertex=new int[n+1];
             
            for(int i=1;i<=n;i++)
                a[i]=sc.nextInt();
             
            int ans=0;
            for(int i=1;i<=n;i++){
                if(check[i]==0)
                    ans+=dfs(i,1,i);
            }
            System.out.println(n-ans);
         
        }
        sc.close();
    }
}