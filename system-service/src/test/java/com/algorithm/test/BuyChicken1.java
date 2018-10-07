package com.algorithm.test;

public class BuyChicken1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,z;
		for(x=0;x<=20;x++)
		{
			for(y=0;y<=33;y++)
			{
				z=100-x-y;
				if(z%3==0&&x*5+y*3+z/3==100)
					System.out.println(x+":"+y+":"+z);
			}
		}
	}

}
