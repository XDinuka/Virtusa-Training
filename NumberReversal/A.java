import java.util.Scanner;
class A {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.nextLine());
		sc.close();
		int y = 0;
		x *= 10;
		while (x > 0) {
				x /= 10;
				y = y * 10 + (x % 10);
		}
		y /= 10;
		System.out.println(y);
	}
}