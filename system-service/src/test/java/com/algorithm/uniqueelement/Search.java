package com.algorithm.uniqueelement;

public class Search   
{  
    public static void main(String[] args)  
    {  
        int[] a = {3, 3, 3, 4, 4, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9};  
          
        search(a);  
          
        search2(a);  
    }  
      
    //好理解，但比较次数多  
    public static void search(int[] a)  
    {  
        int count = 0;  
          
        if(a[0] != a[1])  
            count++;  
          
        if(a[a.length-2] != a[a.length-1])  
            count++;  
          
        if(count < 2)  
        {  
            for(int i=1; i<a.length-1; i++)  
            {  
                if(a[i] != a[i-1] && a[i] != a[i+1])  
                {  
                    count++;  
                      
                    if(count == 2)  
                        break;  
                }  
            }  
        }  
  
        if(count >= 2)  
            System.out.println("Find!");  
        else  
            System.out.println("Not find!");  
    }  
      
    //比较次数少一点  
    public static void search2(int[] a)  
    {  
        int count = 0;  
          
        for(int i=0; i<a.length-1; )  
        {  
            if(a[i] != a[i+1])  
            {  
                if(i > 0 && a[i] != a[i-1])  
                    count++;  
                else if(i == 0)  
                    count++;  
                  
                if(i < a.length-2 && a[i+1] != a[i+2])  
                    count++;  
                else if(i == a.length-2)  
                    count++;  
                  
                if(count == 2)  
                    break;  
            }  
              
            i = i + 2;  
        }  
          
        //数组a有奇数个元素时，比较最后两个元素是否相同  
        if(a.length % 2 != 0 && a[a.length-1] != a[a.length-2])  
            count++;  
          
        if(count >= 2)  
            System.out.println("Find!");  
        else  
            System.out.println("Not find!");  
    }  
} 
