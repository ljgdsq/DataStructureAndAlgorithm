package test;

public class KMPTest {
    public static void main(String[] args) {

    }



    private static int kmp(String str,String pattern)
    {
        char[] strArray=str.toCharArray();
        char[] patternArray=pattern.toCharArray();

        int i=0;
        int j=0;

        int next[]=new int[patternArray.length];
        fillNext(patternArray,next);
        while (i<strArray.length&&j<patternArray.length)
        {
            if (j==-1 || strArray[i]==patternArray[j])
            {
                i++;j++;
            }else
            {
                j=next[j];
            }

        }

        if (j==patternArray.length)
            return i-j;
        return -1;

    }

    private static void fillNext(char[] pattern,int next[])
    {
        next[0]=-1;
        int i=0,j=-1;

        while (i<pattern.length)
        {
            if (j==-1||pattern[i]==pattern[j])
            {
                ++i;
                ++j;
                next[i]=j;
            }else
                j=next[j];
        }
    }


    private static int[] findNext(String pattern)
    {

        int[]next=new int[pattern.length()];

        char[]p=pattern.toCharArray();
        next[0]=-1;
        int i=0;
        int j=-1;
        while (i<p.length)
        {
            if (j==-1||p[i]==p[j])
            {
                i++;
                j++;
                next[i]=j;
            }else
            {
                j=next[j];
            }
        }

        return next;
    }

    private static int kmp(char[] str,String pattern){

        int[]next=findNext(pattern);
        int i=0,j=0;
        char[]p=pattern.toCharArray();

        while (i<str.length&&j<p.length)
        {
            if (j==-1||str[i]==p[j])
            {
                i++;
                j++;
            }else
            {
                j=next[j];
            }
        }

        if (j==p.length)
            return i-j;

        return -1;

    }
}
