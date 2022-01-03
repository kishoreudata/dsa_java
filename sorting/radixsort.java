package sorting;

import com.sun.jmx.snmp.agent.SnmpUserDataFactory;

import java.util.Scanner;

public class radixsort {
    static class node{
        public node next;
        public int data;
        public node(int d){
            data=d;
            next=null;
        }
    }
    public static node radixsort(node start){
        node[]rear=new node[10];
        node[]front=new node[10];
        int leastsigpos=1;
        int mostsigpos=digitsinmax(start);
        int i,dig;
        node p;
        for (int k=leastsigpos;k<=mostsigpos;k++){
            for (i=0;i<=9;i++){
                rear[i]=null;
                front[i]=null;
            }
            for (p=start;p!=null;p=p.next){
                dig=digit(p.data,k);
                if (front[dig]==null)front[dig]=p;
                else rear[dig].next=p;
                rear[dig]=p;
            }
            i=0;
            while (front[i]==null)i++;
            start=front[i];
            while (i<=8){
                if (rear[i+1]!=null)rear[i].next=front[i+1];
                else rear[i+1]=rear[i];
                i++;
            }
            rear[9].next=null;
        }
        return start;
    }
    public static int digitsinmax(node start){
        int max=0;
        node p=start;
        while (p != null) {
            if(p.data>max)max=p.data;
            p=p.next;
        }
        int ndigits=0;
        while (max!=0){
            ndigits++;
            max/=10;
        }
        return ndigits;
    }
    public static int digit(int n,int k){
        int d=0,i;
        for (i=1;i<=k;i++){
            d=n%10;
            n/=10;
        }
        return d;
    }
    public static void main(String[]args){
        node temp,p;
        int i,n,data;
        System.out.println("Enter number of elements in the list: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        node start=null;
        System.out.println("Enter the elements in list");
        for (i=1;i<=n;i++){
            data=sc.nextInt();
            temp=new node(data);
            if (start==null)start=temp;
            else {
                p=start;
                while (p.next!=null)
                    p=p.next;
                p.next=temp;
            }
        }
        start=radixsort(start);
        System.out.println("Sorted list is : ");
        p=start;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println("\n");
    } 
}
