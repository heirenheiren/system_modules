package com.algorithm.magicsquare;

public class MagicSquare1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicSquare1.set(5);
	}
	public static void set(int N)
    {
		int i, j, key;     
	    int [][] square = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};     
	    i = 0;     
	    j = (N+1) / 2;    
	    for(key = 1; key <= N*N; key++)
	    {         
	        if((key % N) == 1) 
	            i++;         
	        else {            
				   i--;             
				   j++;         
		          }     
	      if(i == 0)             
				   i = N;         
		   if(j > N)             
		           j = 1;         
			 square[i][j] = key;     
	   }     
	   for(i = 1; i <= N; i++) 
	 {         
	   for(j = 1; j <= N; j++)             
		   System.out.println( square[i][j]);   
	   System.out.println("\n");  
	 }     
    }
}
