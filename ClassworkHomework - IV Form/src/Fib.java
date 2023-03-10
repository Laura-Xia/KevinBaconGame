import java.util.HashMap;
import java.util.Scanner;

public class Fib {
  public static HashMap<Integer, Integer> m=new HashMap<Integer, Integer>();
  public static void addValue() {
	  m.put(1, 1);
	  m.put(2, 1);
  }
  public static int Fibo(int n){
    if(m.get(n)!=null){
      return m.get(n);
    }
    m.put(n, Fibo(n-1)+Fibo(n-2));
    return m.get(n);
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in); 
    addValue();
    System.out.println("How many Fibonacci numbers do you want to know: ");
    int n=s.nextInt();//number of test cases
    for(int i=0; i<n; i++){
      System.out.println("Fibonacci number at place: ");
      int p=s.nextInt();//position of fib number user wants to know
      System.out.println(Fibo(p));
    }
  }
}