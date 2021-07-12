package test;

import java.util.LinkedList;
import java.util.Queue;

public class DfsTest {


    public static void main(String[] args) {

        System.out.println(getProvince2(new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        }));

        System.out.println(getProvince2(new int[][]{
                {1,0,0},{0,1,0},{0,0,1}
        }));

    }


    private static int getProvince(int city[][])
    {
        int length=city.length;
        boolean[]visited=new boolean[length];
        int count=0;
        for (int i = 0; i < length; i++) {
            if (!visited[i])
            {
                dfs(i,length,visited,city);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int i, int length, boolean[] visited, int[][] city) {
        for (int j=0;j<length;j++)
        {
            if (city[i][j]==1 && !visited[j] )
            {
                visited[j]=true;
                dfs(j,length,visited,city);
            }
        }
    }


    private static int getProvince2(int city[][])
    {
        int length=city.length;
        boolean[]visited=new boolean[length];
        int count=0;


        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!visited[i])
            {
                queue.offer(i);
                while (!queue.isEmpty())
                {
                    Integer k = queue.poll();
                    visited[k]=true;
                    for (int j=0;j<length;j++)
                    {
                        if (city[k][j]==1 && !visited[j] )
                        {
                            queue.offer(j);
                        }
                    }

                }
                count++;
            }
        }

        return count;
    }


}
