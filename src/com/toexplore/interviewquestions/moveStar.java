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
 * 给定一个字符串，这个字符串为 * 号和26个字母的任意组合，
 * 现在需要把字符串中的*号都移动到最左侧，而字符串中的字母
 * 移到最右侧并保持相对顺序不变，要求时间和空间复杂度最小。
 * 如ab*c*d --> **abcd
 *
 */
public class moveStar
{
    
    public static void main(String[] args)
    {
        new moveStar().moveStar("*ac*d*");
    }
    public void moveStar(String s)
    {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for(int i = length - 1; i >= 0; i--)
        {
            if (charArray[i] != '*')
            {
                length--;
                charArray[length] = charArray[i];               
            }
        }
        
        for (int i = 0; i < length; i++)
        {
            charArray[i] = '*';
        }
        System.out.println(charArray);
    }
}
