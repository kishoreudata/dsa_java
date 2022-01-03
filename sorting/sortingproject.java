package sorting;
import binarytree.bstproject;
import com.sun.deploy.panel.ITreeNode;

import javax.swing.*;
import java.util.Scanner;
public class sortingproject {
    public static void main(String[]args){
        int i,n;
        int []a=new int[20];
//        System.out.println("enter the number of elements:");
        Scanner sc=new Scanner(System.in);
//        n=sc.nextInt();
//        System.out.println("Enter array elements");
//        for (i=0;i<n;i++)a[i]= sc.nextInt();
//        selectionsort(a,n);
//        display(a,n);
//        bubblesort(a,n);
//        display(a,n);
//        insertionsort(a,n);
//        display(a,n);
//        shellsort(a,n);
//        display(a,n);

//        int j,n1,n2;
//        int[]a1=new int[20];
//        int[]a2=new int[20];
//        int[]temp=new int[40];
//        System.out.println("Enter the number of elements in array a1: ");
//        n1=sc.nextInt();
//        System.out.println("Enter the elements in array a1: ");
//        for (j=0;j<n1;j++)a1[j]=sc.nextInt();
//        System.out.println("Enter the number of elements in array a2: ");
//        n2=sc.nextInt();
//        System.out.println("Enter the elements in array a2: ");
//        for (j=0;j<n2;j++)a2[j]=sc.nextInt();
//        mergetwo(a1,a2,temp,n1,n2);
//        System.out.println("Merged array temp is :");
//        for (j=0;j<n1+n2;j++)System.out.println(temp[j]+" ");
//        System.out.println("\n");

//        int []a={1,3,5,7, 2,4,6,9,11,14};
//        int []temp=new int[20];
//        merge(a,temp,0,3,4,9);
//        System.out.println("Array a is :");
//        for (i=0;i<=9;i++)System.out.print(a[i]+" ");
//        System.out.println("\n");
//        System.out.println("Merged array temp is :");
//        for (i=0;i<=9;i++)System.out.println(temp[i]+" ");
//        System.out.println("\n");
//        System.out.println("Enter the number of elements for merge sort");
//        int k,n3=sc.nextInt();
//        int []b=new int[20];
//        System.out.println("enter elements of array for merge sort");
//        for (k=0;k<n3;k++)b[k]=sc.nextInt();
//        mergesort(b,n3);
//        System.out.println("Sorted array is :");
//        for (k=0;k<n3;k++)System.out.println(b[k]+" ");
//        System.out.println("\n");
//        int l,n4;
//        int[]c=new int[20];
//        System.out.println("Enter no of elements for iterative merge sort");
//        n4=sc.nextInt();
//        System.out.println("Enter array elements");
//        for (l=0;l<n4;l++)c[l]=sc.nextInt();
//        iterativemergesort(c,n4);
//        display(c,n4);
//        int m,n5;
//        int[]d=new int[20];
//        System.out.println("Enter the number of elements ");
//        n5=sc.nextInt();
//        System.out.println("Enter the array elements");
//        for (m=0;m<n5;m++)d[m]=sc.nextInt();
//        quicksort(d,n5);
//        display(d,n5);
//        int p,n6;
//        int[]e=new int[20];
//        System.out.println("Enter the number of elements");
//        n6=sc.nextInt();
//        System.out.println("Enter the elements of array");
//        for (p=0;p<n6;p++)e[p]=sc.nextInt();
//        bstsort(e,n6);
//        display(e,n6);

//        int q,n7;
//        int[]f=new int[20];
//        System.out.println("Enter the number of elements");
//        n7= sc.nextInt();
//        System.out.println("Enter the array elements");
//        for (q=1;q<=n7;q++)f[q]=sc.nextInt();
//        heapsort(f,n7);
//        //display(f,n7);
//        System.out.println("Sorted array is: ");
//        for (q=1;q<=n7;q++)System.out.print(f[q]+" ");


    }
    public static void selectionsort(int[]a,int n){
        int minindex,temp,i,j;
        for(i=0;i<n-1;i++){
            minindex=i;
            for (j=i+1;j<n;j++){
                if(a[j]<a[minindex])minindex=j;
            }
            if(i!=minindex){
                temp=a[i];
                a[i]=a[minindex];
                a[minindex]=temp;
            }
        }
    }
    public static void display(int[]a,int n){
        System.out.println("Sorted array is :");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("\n");
    }
    public static void bubblesort(int []a,int n){
        int i,j,temp,swaps;
        for (i=n-2;i>=0;i--){
            swaps=0;
            for (j=0;j<=i;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swaps++;
                }
            }
            if (swaps==0)break;
        }
    }
    public static void insertionsort(int[]a,int n){
        int i,j,temp;
        for(i=1;i<n;i++){
            temp=a[i];
            for (j=i-1;j>=0&&a[j]>temp;j--)
                a[j+1]=a[j];
            a[j+1]=temp;
        }
    }
    public static void shellsort(int[]a,int n){
        int i,j,temp,h;
        System.out.println("Enter maximum increment(odd value");
        Scanner sc=new Scanner(System.in);
        h=sc.nextInt();
        while (h>=1){
            for (i=h;i<n;i++){
                temp=a[i];
                for (j=i-h;j>=0&&a[j]>temp;j=j-h)
                    a[j+h]=a[j];
                a[j+h]=temp;
            }
            h=h-2;
        }
    }
    public static void mergetwo(int[]a1,int[]a2,int[]temp,int n1,int n2){
        int i=0,j=0,k=0;
        while ((i<=n1-1)&&(j<=n2-1)){
            if (a1[i]<a2[j])temp[k++]=a1[i++];
            else temp[k++]=a2[j++];
        }
        while (i<=n1-1)temp[k++]=a1[i++];
        while (j<=n2-1)temp[k++]=a2[j++];
    }
    public static void merge(int[]a,int[]temp,int low1,int up1,int low2,int up2){
        int i=low1,j=low2,k=low1;
        while ((i<=up1)&&(j<=up2)){
            if (a[i]<=a[j])temp[k++]=a[i++];
            else temp[k++]=a[j++];
        }
        while (i<=up1)temp[k++]=a[i++];
        while (j<=up2)temp[k++]=a[j++];
    }
    public static void mergesort(int[]a,int n){
        int []temp=new int[n];
        mergesort(a,temp,0,n-1);
    }
    public static void mergesort(int[]a,int[]temp,int low,int up){
        if (low==up)return;
        int mid=(low+up)/2;
        mergesort(a,temp,low,mid);
        mergesort(a,temp,mid+1,up);
        merge(a,temp,low,mid,mid+1,up);
        copy(a,temp,low,up);
    }
    public static void copy(int[]a,int[]temp,int low,int up){
        for(int i=low;i<=up;i++)a[i]=temp[i];
    }
    public static void iterativemergesort(int[]a,int n){
        int []temp=new int[n];
        int size=1;
        while (size <= n - 1) {
            sortpass(a,temp,size,n);
            size=size*2;
        }
    }
    public static void sortpass(int[]a,int[]temp,int size,int n){
        int i,low1,up1,low2,up2;
        low1=0;
        while (low1+size<=n-1){
            up1=low1+size-1;
            low2=low1+size;
            up2=low2+size-1;
            if (up2>=n)up2=n-1;
            merge(a,temp,low1,up1,low2,up2);
            low1=up2+1;
        }
        for (i=low1;i<=n-1;i++)temp[i]=a[i];
        copy(a,temp,n);
    }
    public static void copy(int[]a,int[]temp,int n){
        for(int i=0;i<n;i++)a[i]=temp[i];
    }
    public static void quicksort(int []a,int n){
        quicksort(a,0,n-1);
    }
    private static void quicksort(int[]a,int low, int up){
        if(low>=up)return;
        int p=partition(a,low,up);
        quicksort(a,low,p-1);
        quicksort(a,p+1,up);
    }
    private static int partition(int[]a,int low,int up){
        int temp,i,j,pivot;
        pivot=a[low];
        i=low+1;
        j=up;
        while (i<=j){
            while (a[i]<pivot && i<up)i++;
            while (a[j]>pivot)j--;
            if(i<j){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j--;
            }
            else break;
        }
        a[low]=a[j];
        a[j]=pivot;
        return j;
    }
    public static void bstsort(int[]a,int n){
        bstproject bst = new bstproject();
        for (int i=0;i<n;i++)bst.insert(a[i]);
        bst.inorder(a);
    }
    static class node{
        public node lchild;
        public int data;
        public node rchild;
        public node(int d){
            data=d;
            lchild=null;
            rchild=null;
        }
    }
    public static class bstproject{
        private node root;
        private static int k;
        public bstproject(){
            root=null;
        }
        public void inorder(int[]a){
            k=0;inorder(root,a);
        }
        private void inorder(node p,int[]a){
            if(p==null)return;
            inorder(p.lchild,a);
            a[k++]=p.data;
            inorder(p.rchild,a);
        }
        boolean isempty(){
            return (root==null);
        }
        public void insert(int x){
            root=insert(root,x);
        }
        private node insert(node p,int x){
            if(p==null)p=new node(x);
            else if (x<p.data)p.lchild=insert(p.lchild,x);
            else p.rchild=insert(p.rchild,x);
            return p;
        }
    }
    public static void heapsort(int []a,int n){
        buildheap_bottomup(a,n);
        int max;
        while (n>1){
            max=a[1];
            a[1]=a[n];
            a[n]=max;
            n--;
            restoredown(1,a,n);
        }
    }
    public static void buildheap_bottomup(int[]arr,int n){
        int i;
        for (i=n/2;i>=1;i--)restoredown(i,arr,n);
    }
    private static void restoredown(int i, int[]a,int n){
        int k=a[i];
        int lchild=2*i,rchild=lchild+1;
        while (rchild<=n){
            if(k>=a[lchild] && k>=a[rchild]){
                a[i]=k;
                return;
            }
            else if(a[lchild]>a[rchild]){
                a[i]=a[lchild];
                i=lchild;
            }
            else {
                a[i]=a[rchild];
                i=rchild;
            }
            lchild=2*i;rchild=lchild+1;
        }
        if(lchild==n&&k<a[lchild]){
            a[i]=a[lchild];
            i=lchild;
        }
        a[i]=k;
    }

}
