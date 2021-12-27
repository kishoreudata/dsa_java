import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;
public class recursionproject {
    public static void main(String[] args) {
        recursionproject pq = new recursionproject();
        int choice,n;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Factorial of a number");
            System.out.println("2.Print numbers from n to 1");
            System.out.println("3.Print numbers from 1 to n");
            System.out.println("4.Sum of digits of a number");
            System.out.println("5.Binary form of a number");
            System.out.println("6.Octal form of a number");
            System.out.println("7.Hexadecimal form of a number");
            System.out.println("8.Power of a number");
            System.out.println("9.GCD");
            System.out.println("10.Fibonacci series");
            System.out.println("11.Tower of Hanoi");
            System.out.println("12.Quit");

            System.out.print("Enter your choice \t");
            choice = sc.nextInt();
            if (choice == 12) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    long fact = pq.factorial(n);
                    System.out.println(n+"!="+fact);
                    break;
                case 2:
                    System.out.print("Enter n \t");
                    n = sc.nextInt();
                    pq.print1(n);
                    break;
                case 3:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    pq.print2(n);
                    break;
                case 4:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    int ans = pq.sumdigits(n);
                    System.out.println("sum of digits in "+n+" is :"+ans);
                    break;
                case 5:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    System.out.print("Binary form is :");
                    //pq.convertbase(n,2);
                    pq.tobinary(n);
                    System.out.println(" ");
                    break;
                case 6:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    System.out.print("Octal  form is :");
                    pq.convertbase(n,8);
                    System.out.println(" ");
                    break;
                case 7:
                    System.out.print("Enter n\t");
                    n = sc.nextInt();
                    System.out.print("Hexadecimal form is :");
                    pq.convertbase(n,16);
                    System.out.println(" ");
                    break;
                case 8:
                    System.out.print("Enter number and its power ");
                    double x=sc.nextInt();
                    n=sc.nextInt();
                    double f =pq.power(x,n);
                    System.out.println(x+" to the power "+n+" is :"+f);
                    break;
                case 9:
                    System.out.println("Enter two numbers to find their gcd");
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    n=gcd(a,b);
                    System.out.println("GCD = "+n);
                    break;
                case 10:
                    System.out.println("Enter n");
                    n= sc.nextInt();
                    System.out.println("Fibonacci series of "+n+" is : \n");
                    for(int i=0;i<=n;i++){
                        System.out.print(fib(i)+" ");
                    }
                    break;
                case 11:
                    System.out.println("Enter the number of disks");
                    n= sc.nextInt();
                    hanoi(n,'A','B','C');
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
    public static long factorial(int n){
        if(n==0)return 1;
        else return n*factorial(n-1);
    }
    public static void print1(int n){
        if(n==0)return;
        System.out.print(n+" ");
        print1(n-1);
    }
    public static void print2(int n){
        if(n==0)return;
        print2(n-1);
        System.out.print(n+" ");
    }
    public static int sumdigits(int n){
        if(n/10==0)return n;
        else return sumdigits(n/10)+n%10;
    }
    public static void tobinary(int n){
        if(n==0)return;
        tobinary(n/2);
        System.out.print(n%2);
    }
    public static void convertbase(int n, int b){
        if(n==0)return;
        convertbase(n/b,b);
        int remainder=n%b;
        if(remainder<10)System.out.print(remainder);
        else
            System.out.print((char)(remainder-10+'A'));
    }
    public static double power(double x, int n){
        if(n==0)return 1;
        else return x*power(x,n-1);
    }
    public static int gcd(int a,int b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
    public static int fib(int n){
        if(n==0)return 0;
        else if(n==1)return 1;
        else return (fib(n-1)+fib(n-2));
    }
    public static void hanoi(int n, char source,char temp,char dest){
        if(n==1){
            System.out.println("move disk "+n+" from "+source+" -->"+dest);
            return;
        }
        hanoi(n-1,source,dest,temp);
        System.out.println("move disk "+n+" from "+source+"-->"+dest);
        hanoi(n-1,temp,source,dest);
    }

}
    