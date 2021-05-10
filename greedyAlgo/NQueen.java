package greedyAlgo;
import java.util.*;
public class NQueen{
    
    void print(int board[][],int N)
    {int count=0;
        for(int i=0;i<N;i++) 
        {
            for(int j=0;j<N;j++) {
                if(board[i][j]==1) {
            	    count++;
            	    System.out.print((i+1)+","+(j+1)+ " ");
            }
            }
            System.out.println();
        }
        System.out.println("Number Of Queens " +count);
    }
  
    boolean isSafe(int board[][], int row, int col,int N)
    {
        int i,j;
  
        for (i=0;i<col;i++)
            if (board[row][i]==1)
                return false;
  
        for (i=row,j=col;i>=0 && j>=0;i--,j--)
            if (board[i][j]==1)
                return false;
  
        for (i=row,j=col;j>=0 && i<N;i++,j--)
            if (board[i][j]==1)
                return false;
  
        return true;
    }
  
    boolean solveNQ(int board[][], int col,int N)
    {
        if (col>=N)
            return true;
  
        for (int i=0;i<N;i++) 
        {    
            if (isSafe(board,i,col,N)) 
            {    
                board[i][col]=1;
  
                if (solveNQ(board,col+1,N)==true)
                    return true;
  
                board[i][col]=0;
            }
        }
        return false;
    }
  
    boolean solveNQ(int N)
    {
        int b[][]=new int[N][N];
  
        if (solveNQ(b,0,N)==false) {
            System.out.print("Solution does not exist");
            return false;
        }
  
        print(b,N);
        return true;
    }
  
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Value ");
        int n=sc.nextInt();
        
        NQueen q = new NQueen();
        q.solveNQ(n);
    }
}