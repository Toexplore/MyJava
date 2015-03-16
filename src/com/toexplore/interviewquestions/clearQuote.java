/**
 * Copyleft (C) 2014 ToExplore
 *
 * Email:  wangf_solar@163.com
 * QQ:     806241138
 * WeiBo:  ToExplore
 * wechat: bigMufasa
 */
package com.toexplore.interviewquestions;

import java.util.*;

/**
 * 去除括号内的字符，如ab(cd(ef)g)h --> abh
 * 
 */
public class clearQuote
{
    public static void main(String[] args)
    {
        clearquote("ab(cd(ef)g)h");
    }

    private static void clearquote(String s)
    {
        Stack<Object> sStack = new Stack<Object>();
        for(int i = 0; i < s.length();  i++)
        {
            if (s.charAt(i) != ')')
            {
                sStack.push((Object)s.charAt(i));
            }
            else
            {
                while(true)
                {
                    if (sStack.peek().toString().equals("(") == true)
                    {
                        sStack.pop();
                        break;
                    }
                    sStack.pop();
                }
            }
        }
        
        System.out.println(sStack.toString());
    }
}
