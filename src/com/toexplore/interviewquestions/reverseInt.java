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
* 逆序打印整数，要求递归实现：输入321，输出"123"，要求必须用递归，
* 不能用全局变量，输入必须是一个参数，必须返回字符串
*/
public class reverseInt
{
    public static void main(String[] args)
    {
        System.out.println(reverseInt(4278236));
        System.out.println(reverseIntWithoutRecur(872340));
    }
    
    public static String reverseInt(int value)
    {
        StringBuilder sBuilder = new StringBuilder();
        if (value/10 == 0)
        {
            sBuilder.append(value);
        }
        else 
        {
            sBuilder.append(value%10);
            sBuilder.append(reverseInt(value/10));
        }
        return sBuilder.toString();
    }
    
    /*
     * 非递归版本
     */
    public static String reverseIntWithoutRecur(int value)
    {
        StringBuilder sBuilder = new StringBuilder();
        while(true)
        {
            if (value/10 == 0)
            {
                sBuilder.append(value);
                break;
            }
            else 
            {
                sBuilder.append(value%10);
                value = value/10;
            }
        }
        return sBuilder.toString();
    }
}
