import java.util.Scanner;
public class parentheses{
    public static void main(String[] args){
        String expression;
        System.out.println("Enter an expression with parentheses");
        Scanner sc = new Scanner(System.in);
        expression= sc.nextLine();
        if(isValid(expression))System.out.println("Valid expression");
        else System.out.println("Invalid expression");
    }
    public static boolean isValid(String expr){
        stackA st = new stackA();
        char ch;
        for(int i=0;i<expr.length();i++){
            if(expr.charAt(i)=='('||expr.charAt(i)=='{'||expr.charAt(i)=='[')st.push(expr.charAt(i));
            if(expr.charAt(i)==')'||expr.charAt(i)=='}'||expr.charAt(i)==']')
                if(st.isEmpty()){
                    System.out.println("right parentheses are more than left parentheses");
                    return false;
                }
                else {
                    ch=st.pop();
                    if(!matchparentheses(ch,expr.charAt(i))){
                        System.out.println("mismatched parentheses are: ");
                        System.out.println(ch+" and "+expr.charAt(i));
                        return false;
                    }
                }
        }
        if(st.isEmpty()){
            System.out.println("balanced parentheses");
            return true;
        }
        else {
            System.out.println("Left parentheses are more than right parentheses");
            return false;
        }
    }
    public static boolean matchparentheses(char leftpar, char rightpar){
        if(leftpar=='[' && rightpar==']')return true;
        if(leftpar=='(' && rightpar==')')return true;
        if(leftpar=='{' && rightpar=='}')return true;
        return false;
    }
    static class stackA{
        private char[] stackarray;
        private int top;
        public stackA(){
            stackarray = new char[10];
            top=-1;
        }
        public stackA(int maxSize){
            stackarray = new char[maxSize];
            top=-1;
        }
        public int size(){
            return top+1;
        }
        public boolean isEmpty(){
            return (top==-1);
        }
        public boolean isFull(){
            return (top==stackarray.length-1);
        }
        public void push(char x){
            if(isFull()){
                System.out.println("Stack Overflow");
                return;
            }
            top+=1;
            stackarray[top]=x;
        }
        public char pop(){
            char x;
            if(isEmpty()){
                System.out.println("Stack is empty");
                return '\n';
            }
            x=stackarray[top];
            top-=1;
            return x;
        }
    }
}
