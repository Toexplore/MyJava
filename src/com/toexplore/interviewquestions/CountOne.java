/**
 * Copyleft (C) 2014 ToExplore
 *
 * Email:  wangf_solar@163.com
 * QQ:     806241138
 * WeiBo:  ToExplore
 * wechat: bigMufasa
 */
package com.toexplore.interviewquestions;

/*
 * int类型的数据时32位的，怎么知道一个32位的二进制数据有多少个1
 * 参见编程之美P119
 */
public class CountOne
{
    public static void main(String[] args)
    {
        countOne(1);
        countOne(2);
        countOne(7);
        countOne(2338);
        
        countOne2(1);
        countOne2(2);
        countOne2(7);
        countOne2(2338);
        
        countOne3(1);
        countOne3(2);
        countOne3(7);
        countOne3(2338);
    }
    
    public static void countOne(int value)
    {
        int num = 0;
        while(value != 0)
        {
            num +=(value & 1);
            value = value >> 1;
        }
        System.out.println("1的个数为：" + num);
    }
    
    public static void countOne2(int value)
    {
        int num = 0;
        while(value != 0)
        {
            num += value % 2;
            value = value/2;
        }
        System.out.println("1的个数为:" + num);
    }
    
    public static void countOne3(int value)
    {
        int num = 0;
        while(value != 0)
        {
            value &= (value - 1);
            num++;
        }
        System.out.println("1的个数为:" + num);
    }
}
