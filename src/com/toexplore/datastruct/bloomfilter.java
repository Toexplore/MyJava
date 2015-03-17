/**
 * Copyleft (C) 2014 ToExplore
 *
 * Email:  wangf_solar@163.com
 * QQ:     806241138
 * WeiBo:  ToExplore
 * wechat: bigMufasa
 */
package com.toexplore.datastruct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * 布隆过滤器的简单实现，其原理为，首先设置一个位图以及8个hash函数，对
 * 每个要判断的字符串进行8次hash，得到8个位置，在位图中将这8个位置置为1即可
 * 
 */
public class bloomfilter
{
    private static final int DEFAULT_SIZE = 2<<28;
    private int[] seeds = new int[]{3,5,6,11,13,31,37,61};
    private BitSet bitSet = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] hashFuns = new SimpleHash[seeds.length];
    private String path = "";
    
    public static void main(String[] args)
    {
        bloomfilter bloomfilter = new bloomfilter("F:\\GitHub\\MyJava\\src\\com\\toexplore\\datastruct\\bloomfilter.txt");
        bloomfilter.init();
        System.out.println(bloomfilter.isExit("http://baidu.com"));
    }
    public bloomfilter(String path)
    {
        for (int i = 0; i < seeds.length; i++)
        {
            hashFuns[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
        this.path = path;
    }
    
    public synchronized void add(String value)
    {
        for (SimpleHash hashFun : hashFuns)
        {
            bitSet.set(hashFun.hash(value),true);
        }
    }
    
    public synchronized boolean isExit(String value)
    {
        if (null == value)
        {
            return false;
        }
        
        for(SimpleHash hashFun : hashFuns)
        {
            if (!bitSet.get(hashFun.hash(value)))
            {
                return false;
            }
        }
        return true;
    }
    
    public void init()
    {
        File file = new File(path);
        FileInputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(file);
            long start = System.currentTimeMillis();
            read(inputStream);
            System.out.println(System.currentTimeMillis() - start);
            System.out.println(Runtime.getRuntime().totalMemory());
        } catch (Exception e)
        {
            // TODO: handle exception
        }
    }
    
    private void read(InputStream inputStream )
    {
        if (null == inputStream)
        {
            return;
        }
        
        int i = 0;
        InputStreamReader readerInputStream = null;
        try
        {
            String word = null;
            readerInputStream = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(readerInputStream);
            do{
                i++;
                word = bufferedReader.readLine();
                if (word != null && !word.trim().equals(""))
                {
                    add(word);
                }
                if (i % 10000 == 0)
                {
                    System.out.println(i);
                }
            }while(word != null);
        } catch (Exception e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                if (readerInputStream != null)
                {
                    readerInputStream.close();
                    readerInputStream = null;
                }
                if (inputStream != null)
                {
                    inputStream.close();
                    inputStream = null;
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class SimpleHash
{
    private int cap;
    private int seed;
    public SimpleHash(int cap, int seed)
    {
        this.cap = cap;
        this.seed = seed;
    }
    
    public int hash(String value)
    {
        int result = 0;
        int length = value.length();
        for (int i = 0; i < length; i++)
        {
            result = seed*result + value.charAt(i);
        }
        return (cap - 1) & result;
    }
}