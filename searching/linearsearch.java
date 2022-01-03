package searching;

import java.util.Scanner;

public class linearsearch {
    public static int lsearch(int[]a,int n,int searchvalue){
        for (int i=0;i<n;i++){
            if(a[i]==searchvalue)return i;
        }
        return -1;
    }
    public static void main(String[]args){
        int i,n,searchvalue,index;
        int[]a=new int[100];
        System.out.println("Enter the number of elements");
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
//        System.out.println("Enter the elements");
//        for (i=0;i<n;i++)a[i]= sc.nextInt();
//        System.out.println("Enter the search value");
//        searchvalue=sc.nextInt();
//        index=lsearch(a,n,searchvalue);
//        if(index==-1)System.out.println("Value "+searchvalue+" not present in the array");
//        else System.out.println("Value "+searchvalue+" present at index "+index);

        System.out.println("Enter the elements in sorted order");
        for (i=0;i<n;i++)a[i]= sc.nextInt();
        System.out.println("Enter the search value");
        searchvalue=sc.nextInt();
        index=lsearchsorted(a,n,searchvalue);
        if(index==-1)System.out.println("Value "+searchvalue+" not present in the array");
        else System.out.println("Value "+searchvalue+" present at index "+index);

    }
    public static int sentinelsearch(int[]a,int n,int searchvalue){
        a[n]=searchvalue;
        int i=0;
        while (searchvalue!=a[i])i++;
        if(i<n)return i;
        else return -1;
    }
    public static int lsearchsorted(int[]a,int n ,int searchvalue){
        int i;
        for(i=0;i<n;i++){
            if (a[i]>=searchvalue)break;
        }
        if(a[i]==searchvalue)return i;
        else return -1;
    }

}
