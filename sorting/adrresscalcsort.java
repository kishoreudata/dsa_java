package sorting;
import java.util.Scanner;

public class adrresscalcsort {
     static class node{
          public node next;
          public int data;
          public node(int d){
               data=d;
               next=null;
          }
     }
     static class sortedLL{
          private node start;
          public sortedLL(){start=null;}
          public void insertinorder(int data){
               node p,temp;
               temp=new node(data);
               if (start==null||data<start.data){
                    temp.next=start;
                    start=temp;
                    return;
               }
               p=start;
               while (p.next!=null&&p.next.data<=data)p=p.next;
               temp.next=p.next;
               p.next=temp;
          }
     }
     public static void hashsort(int[]a,int n){
          int i,j,x;
          sortedLL[]list=new sortedLL[6];
          for (i=0;i<6;i++)list[i]=new sortedLL();
          int max=0;
          for (i=0;i<n;i++){
               if(a[i]>max)
                    max=a[i];
          }
          for (i=0;i<n;i++){
               x= Hash(a[i],max);
               list[x].insertinorder(a[i]);
          }
          node p;
          i=0;
          for (j=0;j<=5;j++){
               p=list[j].start;
               while (p!=null){
                    a[i++]=p.data;
                    p=p.next;
               }
          }
     }
     public static int Hash(int x,int large){
          float temp;
          temp=(float) x/large;
          return (int)temp*5;
     }
     static void main(String[]args){
          int i,n;
          int[]a=new int[20];
          System.out.println("Enter the number of elements :");
          Scanner sc=new Scanner(System.in);
          n= sc.nextInt();
          System.out.println("Enter the elements");
          for (i=0;i<n;i++)a[i]=sc.nextInt();
          hashsort(a,n);
          System.out.println("Sorted array is :");
          for (i=0;i<n;i++)System.out.print(a[i]+" ");
          System.out.println("\n");
     }
}
