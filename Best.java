import java.util.*;
class Best_info
{
  int best_max, best_start, best_end;
}
class Best
{
  static int[] get_best_cycle(int[] A)
  {
    int[] negativeA = new int[A.length];
    int sum = 0;
    for(int i = 0 ; i<A.length; i++)
    {
      negativeA[i] = A[i]*(-1);
      sum += A[i];
    }
    Best_info best_x  = maximum(A);
    Best_info best_y  = maximum(negativeA);

    int sum_simple = best_x.best_max;
    int sum_cycle = sum + best_y.best_max;
    int size_simple = best_x.best_end- best_x.best_start + 1;
    int size_cycle = A.length - best_y.best_end + best_x.best_start + 1;
    if (sum_simple>sum_cycle || (sum_simple == sum_cycle && size_simple <= size_cycle))
    {
      return get_sub_array(A, best_x.best_start, best_x.best_end);
    } else
    {
      System.out.println("asdsa");
        return get_sub_array(A, best_y.best_end + 1, best_y.best_start -1);
    }
  }
  static int[] get_sub_array(int[] A, int start, int end)
  {
    int size;
    int[] ans = null;
    if (end > start)
    {
      size = end - start + 1;
      ans = new int[size];
      for (int i = 0;i<size; i++)
      {
        ans[i] = A[start + i];
      }
    }
    else
    {
      size = A.length - start + end + 1;
      ans = new int[size];
      System.out.println(size);
      for (int i = 0;i<size; i++)
      {
        ans[i] = A[(start + i) % A.length];
      }
    }
    return ans;
  }
  static Best_info maximum(int[] A)
  {
    int best_max = 0;
    int best_start = 0;
    int best_end = A.length;
    int temp_max = 0;
    int temp_start = 0;
    for(int k=0;k<A.length;k++)
    {
      temp_max += A[k];
      if (temp_max > best_max || (temp_max == best_max && k-temp_start< best_end-best_start))
      {
        best_max = temp_max;
        best_start = temp_start;
        best_end = k;
      }
      if (temp_max < 0)
      {
        temp_max = 0;
        temp_start = k + 1;
      }
    }
    Best_info best = new Best_info();
    best.best_max = best_max;
    best.best_end = best_end;
    best.best_start = best_start;
    // return best_end - best_start + 1;
    // return best_max;
    // return best_start;
    return best;
  }



  // main function
  public static void main(String[] args)
  {
    // int[] A = {-4,1,2,3,-50,2,4,-30};
    // Best_info best  = maximum(A);
    // System.out.println(best.best_end-best.best_start+1);

    int[] A = {4,2,-15,1,2,3,-100};
    System.out.println(Arrays.toString(get_best_cycle(A)));
  }
}
