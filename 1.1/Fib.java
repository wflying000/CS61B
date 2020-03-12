public class Fib{
	public static int fib(int n){
		int a = -1;
		int b = 1;
		int i = 0;
		int t = 0;
		while(i <= n){
			t = b;
			b = a + b;
			a = t;
			i++;
		}
		return b;
	}

	public static int fib2(int n, int k, int f0, int f1){
		if(n == k){
			return f0;
		}
		return fib2(n, k + 1, f1, f0 + f1);
	}

	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			System.out.println(fib(i) + " ");
		}
	}
}