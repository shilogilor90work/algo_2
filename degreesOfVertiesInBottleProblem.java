
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
  public class degreesOfVertiesInBottleProblem
  {
  public static int getI(int k,int n)
  {
    return k/(n+1);
  }
  public static int getJ(int k,int n)
  {
    return k%(n+1);
  }
  public static int getIndex(int i,int j,int n)
  {
    return (n+1)*i+j;
  }
  public static int[] degrees(int p,int q)
  {
    int size=(p+1)*(q+1);
    int[] mat=new int[size];
    for(int k=0;k<=size-1;k++)
    {
    int  i=getI(k,p);
    int  j=getJ(k,p);
      int index=getIndex(0,j,p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
      index=getIndex(i,0,p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
      index=getIndex(q,j,p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
      index=getIndex(i,p,p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
      index=getIndex(i+j-(Math.min(i+j,p)),Math.min(i+j,p),p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
      index=getIndex((Math.min(i+j,q)),i+j-Math.min(i+j,q),p);
      if(k!=index)
      {
        mat[k]+=1;
        mat[index]+=1;
      }
    }
    Arrays.sort(mat);
    return mat;
  }

  public static void main(String args[])
	{
    int i=2,j=1;
    int[] mat=degrees(i,j);
    for(int n=(i+1)*(j+1)-1;n>=0;n--)
    System.out.print(","+mat[n]);

      }
    }
