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
 * 请实现以下功能，解密一个给定字符串，解密的规则是将两个数字间
 * （前面没有数字的情况下 算开头喝数字间）的字符串重复数字次数，
 * 数字不会超过int表示的范围，比如a2bc3d1，解密后的字符串
 * 为aabcbcbcd
 * 
 */
public class decode
{
    
    public static void main(String[] args)
    {
        System.out.println(decode("a2bc3d1"));
        System.out.println(decode("love1you2and3me1"));
    }
    
    public static String decode(String str)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
            {
                for (int j = 0; j < str.charAt(i) - '0'; j++)
                {
                    result.append(temp);
                }
                temp.delete(0, temp.length());
            }
            else
            {
                temp.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}

