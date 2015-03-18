/**
 * Copyleft (C) 2014 ToExplore
 *
 * Email:  wangf_solar@163.com
 * QQ:     806241138
 * WeiBo:  ToExplore
 * wechat: bigMufasa
 */
package com.toexplore.interviewquestions;


/**
 * 将给定的整数转为字符串，整数有正负之分
 * 
 */
public class itoa
{

    public static void main(String[] args)
    {
        String result = itoa(-100);
    }
    public static String itoa(int value)
    {
        StringBuilder sb = new StringBuilder();
        boolean isPositive = true;
        if (value < 0)
        {
            isPositive = false;
        }
        
        value = Math.abs(value);
        while(true)
        {
            if (value != 0)
            {
                sb.append(value % 10);
                value = value / 10;
            }
            else {
                break;
            }
        }
        if (!isPositive)
        {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}

