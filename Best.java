// to compile run : javac Best.java
// to run run: java Best 
import java.util.*;
class Best
{
  private int maxSum;
  private int maxLength;
  public Best(int[] arr)
  {
    maxSum = 0;
    int best_start = 0;
    int best_end = arr.length;
    int temp_max = 0;
    int temp_start = 0;
    for(int k=0;k<arr.length;k++)
    {
      temp_max += arr[k];
      if (temp_max > maxSum || (temp_max == maxSum && k-temp_start > best_end-best_start))
      {
        maxSum = temp_max;
        best_start = temp_start;
        best_end = k;
      }
      if (temp_max < 0)
      {
        temp_max = 0;
        temp_start = k + 1;
      }
    }
    maxLength = best_end - best_start + 1;
  }
  public int getMaxSum()
  {
    return maxSum;
  }
  public int getMaxLength()
  {
    return maxLength;
  }
  // main function
  public static void main(String[] args)
  {
    int[] data = {1, -1, 4, 9, -19, -17, 4, 5, 1, -4, 7, -5};
    Best best = new Best(data);

    System.out.println("Maximum sum = " + best.getMaxSum());
    System.out.println("Maximum length = " + best.getMaxLength());
  }
}
