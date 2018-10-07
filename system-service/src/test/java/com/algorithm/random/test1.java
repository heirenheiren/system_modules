package com.algorithm.random;

import java.util.Random;



//给一个大小为100的（整型）数组，分配0-1000的随机数100个，但这100个数不能重复，
//然后把它从小到大排序，并输出来。（时间10分钟）
//我把它变了一下数组大小为101，感觉效率比较高。算法如下：
/*
* 采用插入排序法,产生一个随机数就插入，在排序的过程中也就是排出重复的过程；
* 比先分配好100个数，这个过程中要比较是否重复，然后再排序，效率要高。
*/
public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Random r = new Random();
      int[] list = new int[101];  //多分配一个，有利于采用插入法
      int len = 1;  //动态记录已分配的数组长度
      list[1] = r.nextInt(1000);
      int j;
      while(true)
      {
          int num= r.nextInt(1000);
          //刚产生的随机数如果是最大值
          if (num > list[len])
          {
              len++;
              list[len] = num;
          }
          else if (num < list[len]) 
          {
              list[0] = num;
               for (j = len - 1; list[0] < list[j]; j--)
                  ; //不移动元素，因为有可能是重复的
              if (list[0] > list[j] || (j == 0 && list[0] == list[j]))
              {
                  //判断不是重复的再一起移动，完全不影响效率
                  for (int k = len; k > j; k--)
                  {
                      list[k + 1] = list[k];
                  }
                  list[j + 1] = list[0];
                  len++;  //记录分配的个数
              }
          }
          //随机分配100个后，就跳出，不再分配
          if (len > 99)
              break;
      }
      //打印输出
      for (int i = 1; i < 101; i++)
      {
          System.out.println(i+": "+list[i]); 
      }
	}

}
