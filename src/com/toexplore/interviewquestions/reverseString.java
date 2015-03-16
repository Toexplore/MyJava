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
 * 1、翻转字符串，I am Jack  --> Jack am I
 * 
 */
public class reverseString
{

    public static void main(String[] args)
    {
        new reverseString().reverse("I am Jack", " ");
    }
    
    private static void reverse(String s, String separator)
    {
        String[] splitStrings = s.split(separator);
        for (int i = splitStrings.length - 1; i >= 0; i--)
        {
            System.out.printf("%s ", splitStrings[i]);
        }
    }
    
}
