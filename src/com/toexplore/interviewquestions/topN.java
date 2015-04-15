package com.toexplore.interviewquestions;

import java.util.Arrays;

public class topN
{
    //java api
    public static int[] findTopNValues(int[] oldValues, int n)
    {
        Arrays.sort(oldValues);
        int[] result = Arrays.copyOf(oldValues, n);
        return result;
    }
    
    //quick sort
    public static void quickSort(Integer[] A, int low, int high) {  
        int i = low;
        int j = high;
        int temp = A[i];
        
        if (i < j)
        {
            while (i < j)
            {
                while(i < j && A[j] > temp)
                {
                    j--;
                }
                if( i < j)
                {
                    A[i] = A[j];
                    i++;
                }
                
                while (i < j && A[i] < temp)
                {
                    i++;
                }
                if (i < j)
                {
                    A[j] = A[i];
                    j--;
                }
            }
            
            A[i] = temp;
            quickSort(A, i + 1, high);
            quickSort(A, low, i - 1);
        }
          
    }  
    


    public static void main(String[] args)
    {
        //java api
        int[] values = findTopNValues(new int[]{4,12,4,5,9,9,7,100,394}, 5);
        
        //quick sort
        Integer[] list = {4,12,3,5,9,9,7,100,394};
        quickSort(list, 0,list.length - 1 );
        Integer[] result = Arrays.copyOf(list, 5);
        for( Integer num : result)
        {
            System.out.println(num);
        }
    }
    
   
    
    
}
