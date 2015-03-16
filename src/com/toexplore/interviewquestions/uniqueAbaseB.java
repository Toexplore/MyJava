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
 * 两个字符串A、B，从A中剔除存在于B中的字符
 * 如A：hello world
 * B: er
 * 经过剔除之后，A的结果为：hllo wold
 *
 */
public class uniqueAbaseB
{
    public static void main(String[] args)
    {
        System.out.println(new uniqueAbaseB().uniqueString("hello world", "er"));
    }
    public String uniqueString(String A, String B)
    {
        int[] hash = new int[256];
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < B.length(); i++)
        {
            hash[B.charAt(i)] = 1;
        }
        
        for (int i = 0; i < A.length(); i++)
        {
            if(hash[A.charAt(i)] == 0)
            {
                sBuilder.append(A.charAt(i));
            }
        }
        
        return sBuilder.toString();
    }
}
