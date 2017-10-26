package com.java.algorithm;

/**
 * Created by zhaojw
 * Date: 2017/10/25
 * Time: 18:17
 * 题目描述： 一个二维数组，每一行从左到右递增，每一列从上到下递增．输
 *          入一个二维数组和一个整数，判断数组中是否含有整数。
 * @author: zhaojw
 */
public class FindTo2Array {

    public static void find(int[][] arrys,int num){
        if (arrys==null||(arrys!=null&&arrys.length==0)){
            return;
        }
        /*
        列从大到小查，若遇到
         */
        int cloums=arrys[0].length-1;
        int row=0;
        while(row<arrys.length&&cloums>=0){
            int temp=arrys[row][cloums];
            if (temp>num){
                cloums--;
            }else if (temp<num){
                row++;
            }else {
                System.err.println("arrys["+cloums+"]["+row+"]="+num);
                break;
            }
        }
    }

    public static void main(String[] args){
        int[][] testarray=new int[4][4];
        testarray[0][0]=1;
        testarray[0][1]=2;
        testarray[0][2]=8;
        testarray[0][3]=9;
        testarray[1][0]=2;
        testarray[1][1]=4;
        testarray[1][2]=9;
        testarray[1][3]=12;
        testarray[2][0]=4;
        testarray[2][1]=7;
        testarray[2][2]=10;
        testarray[2][3]=13;
        testarray[3][0]=6;
        testarray[3][1]=8;
        testarray[3][2]=11;
        testarray[3][3]=15;
        find(testarray, 1);
    }
}
