package Lab1;
public class Opseg {
  public int min(int[] arr) {
        int pred=-1;
        int succ=1;
        for (int i=0;i<arr.length;i++)
        {
            if (pred != arr[i]-1 && pred!=-1)
                succ++;
            pred=arr[i];
        }
        return succ;
    }
}
