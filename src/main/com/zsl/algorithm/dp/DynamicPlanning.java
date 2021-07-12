package main.com.zsl.algorithm.dp;

public class DynamicPlanning {
    /*
     *从数组中选出n个不相邻的数，其和最大
     */

    public static void main(String[] args) {

        int []m=new int[]{1,2,3,4};
        System.out.println(maxMoney(m,m.length-1));
        System.out.println(maxMoney1(m));

    }


    private static  int maxMoney(int[] m, int index)
    {
        if (m==null||index<0) return 0;

        if (index==0) return m[0];


        return Math.max(maxMoney(m,index-1),maxMoney(m,index-2)+m[index]);
    }


    private static  int maxMoney1(int[] m)
    {

//        int[]dp=new int[m.length];
        int dpL; //dp[i-1]
        int dpR;//dp[i-2]

        dpL=m[0];
        dpR=Math.max(m[0],m[1]);
        for (int i=2;i<m.length;i++)
        {
            int dp=Math.max(dpR,dpL+m[i]);
            dpL=dpR;
            dpR=dp;
        }

        return dpR;
    }

}
