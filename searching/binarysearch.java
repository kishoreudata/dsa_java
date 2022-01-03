package searching;

import java.util.Scanner;

public class binarysearch {
    public static int bsearch(int[]a,int n,int searchvalue){
        return bsearch(a,0,n-1,searchvalue);
    }
    public static int bsearch(int[]a,int first,int last,int searchvalue){
        if (first>last)return -1;
        int mid=(first+last)/2;
        if (searchvalue>a[mid])return bsearch(a,mid+1,last,searchvalue);
        else if(searchvalue<a[mid])return bsearch(a,first,mid-1,searchvalue);
        else return mid;
    }
    public static void main(String[]args){
        int i,n,searchvalue,index;
        int[]a=new int[100];
        System.out.println("Enter the number of elements");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("Enter the elements in sorted order");
        for (i=0;i<n;i++)a[i]=sc.nextInt();
        System.out.println("Enter the search value");
        searchvalue=sc.nextInt();
        index=bsearch(a,n,searchvalue);
        if(index==-1)System.out.println("Value "+searchvalue+" not present in the array");
        else System.out.println("Value "+searchvalue+" present at index "+index);

    }
}
