import java.util.Scanner;
public class heapproject {
    public static void main(String[] args){
        heapproject h=new heapproject(20);
        int choice,value;
        Scanner sc=new Scanner(System.in);
        int []a1={99999,1,4,5,7,9,10};
        int n1=a1.length-1;
        bottomup(a1,n1);
        for(int i=1;i<=n1;i++)
            System.out.println(a1[i]+" ");
        System.out.println("\n");
        int []a2={99999,1,4,5,7,9,10};
        int n2=a2.length-1;
        topdown(a2,n2);
        for(int i=1;i<=n1;i++)
            System.out.println(a2[i]+" ");
        System.out.println("\n");
        while (true){
            System.out.println("1.Insert");
            System.out.println("2.Delete root");
            System.out.println("3.Display");
            System.out.println("4.Exit");
            System.out.println("Enter your choice :");
            choice=sc.nextInt();
            if(choice==4)break;
            switch (choice){
                case 1:
                    System.out.println("Enter the value to be inserted : ");
                    value=sc.nextInt();
                    h.insert(value);
                    break;
                case 2:
                    System.out.println("Maximum value is "+h.deleteroot());
                    break;
                case 3:
                    h.display();
                    break;
                default:System.out.println("Wrong choice");
                        break;
            }
        }
    }
    private int[]a;
    private int n;
    public heapproject(){
        a=new int[10];
        n=0;
        a[0]=99999;
    }
    public heapproject(int maxSize){
        a=new int[maxSize];
        n=0;
        a[0]=99999;
    }
    public void insert(int value){
        n++;
        a[n]=value;
        restoreup(n);
    }
    private void restoreup(int i){
        int k=a[i];
        int iparent=i/2;
        while (a[iparent]<k){
          a[i]=a[iparent];
          i=iparent;
          iparent=i/2;
        }
        a[i]=k;
    }
    public int deleteroot(){
        if (n==0)System.out.println("Heap is empty");
        int maxvalue=a[1];
        n--;
        restoredown(1);
        return maxvalue;
    }
    private void restoredown(int i){
        int k=a[i];
        int lchild=2*i,rchild=lchild+1;
        while (rchild<=n){
            if(k>=a[lchild]&&k>=a[rchild]){
                a[i]=k;return;
            }
            else if(a[lchild]>a[rchild]){
                a[i]=a[lchild];
                i=lchild;
            }
            else {
                 a[i]=a[rchild];
                 i=rchild;
            }
            lchild=2*i;
            rchild=2*i+1;
        }
        if(lchild==n&&k<a[lchild]){
            a[i]=a[lchild];
            i=lchild;
        }
        a[i]=k;
    }
    public void display(){
        for (int i = 1; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.println("\n");
    }
    public static void bottomup(int[]a,int n){
        for(int i=n/2;i>=1;i--)
            restoredown(i,a,n);
    }
    public static void topdown(int []a,int n){
        for (int i=2;i<=n;i++)
            restoreup(i,a);
    }
    public static void restoreup(int i,int[]a){
        int k=a[i];
        int iparent=i/2;
        while (a[iparent]<k){
            a[i]=a[iparent];
            i=iparent;
            iparent=i/2;
        }
        a[i]=k;
    }
    public static void restoredown(int i, int[]a, int n){
        int k=a[i];
        int lchild=2*i,rchild=lchild+1;
        while (rchild<=n){
            if(k>=a[lchild]&&k>=a[rchild]){
                a[i]=k;return;
            }
            else if(a[lchild]>a[rchild]){
                a[i]=a[lchild];
                i=lchild;
            }
            else {
                a[i]=a[rchild];
                i=rchild;
            }
            lchild=2*i;
            rchild=2*i+1;
        }
        if(lchild==n&&k<a[lchild]){
            a[i]=a[lchild];
            i=lchild;
        }
        a[i]=k;
    }

}
