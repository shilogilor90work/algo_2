
// to run :
  // javac buckets_edges.java
  // java buckets_edges
public class buckets_edges {

  static int getI(int k, int n)
  {
    return k/(n+1);
  }
  static int getJ(int k, int n)
  {
    return k%(n+1);
  }
  static int getIndex(int i, int j,int n)
  {
    return (n+1)*i+j;
  }

  static int NumberOfEdgesInBottleProblem(int p, int q)
  {
    int i,j,index;
    int counter = 0;
    for(int k = 0;k<(p+1)*(q+1); k ++)
    {
      i = getI(k,p);
      j = getJ(k,p);
      index = getIndex(0,j,p);

      if (k != index)
      {
        counter++;
      }
      index = getIndex(i,0,p);
      if (k != index)
      {
        counter++;
      }
      index = getIndex(q,j,p);
      if (k != index)
      {
        counter++;
      }
      index = getIndex(i,p,p);
      if (k != index)
      {
        counter++;
      }
      index = getIndex(i+j-Math.min(i+j,p),Math.min(i+j,p),p);
      if (k != index)
      {
        counter++;
      }
      index = getIndex(Math.min(i+j,q),i+j-Math.min(i+j,q),p);
      if (k != index)
      {
        counter++;
      }
    }
    return counter;
  }
  public static void main(String[] args)
  {
    int p = 5;
    int q = 3;
    int value = NumberOfEdgesInBottleProblem(p,q);
    System.out.println(value);
  }
}

