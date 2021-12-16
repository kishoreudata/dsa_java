import java.util.Scanner;

public class posftixsolve {
    public static void main(String[] args) {
        posftixsolve p = new posftixsolve();
        String infix;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix expression");
        infix = sc.nextLine();
        String postfix = p.infixtopostfix(infix);
        System.out.println("Postfix expression is: " + postfix);
        System.out.println("value of expression is:  "+evaluatepostfix(postfix));
    }

    public String infixtopostfix(String infix) {
        String postfix = "";
        StackChar st = new StackChar(20);
        char next, symbol;
        for (int i = 0; i < infix.length(); i++) {
            symbol = infix.charAt(i);
            if (Character.isWhitespace(symbol)) continue;// || symbol=='\t'
            //if(symbol!='\n')continue;
            switch (symbol) {
                case '(':
                    st.push(symbol);
                    break;
                case ')':
                    while ((next = st.pop()) != '(')
                        postfix += next;
                    break;
                case '+':
                case '/':
                case '*':
                case '-':
                case '^':
                case '%':
                    while (!st.isEmpty() && precedence(st.peek()) >= precedence(symbol)) postfix += st.pop();
                    st.push(symbol);
                    break;
                default://operand
                    postfix += symbol;
                    break;
            }
        }
        while (!st.isEmpty()) postfix += st.pop();
        return postfix;
    }

    public int precedence(char symbol) {
        switch (symbol) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public static int evaluatepostfix(String postfix){
        StackInt st = new StackInt(20);
        int x,y;
        for(int i=0;i<postfix.length();i++){
            if(Character.isDigit(postfix.charAt(i)))
                st.push(Character.getNumericValue(postfix.charAt(i)));
            else {
                x=st.pop();
                y=st.pop();
                switch (postfix.charAt(i)){
                    case '+':st.push(y+x); break;
                    case '-':st.push(y-x); break;
                    case '*':st.push(y*x); break;
                    case '/':st.push(y/x); break;
                    case '%':st.push(y%x);break;
                    case '^':st.push(power(y,x)); break;
                }
            }
        }
        return st.pop();
    }
    public static int power(int b,int a){
        int c=1;
        for(int i=0;i<a;i++)c*=b;
        return c;
    }
    static class StackInt{
        private int[] stackarray;
        private int top;
        public StackInt(){
            stackarray=new int[10];top=-1;
        }
        public StackInt(int maxSize){
            stackarray = new int[maxSize];top=-1;
        }
        public int size(){
            return (top+1);
        }
        public int peek(){
            return stackarray[top];
        }
        public boolean isEmpty(){
            return(top==-1);
        }
        public boolean isFull(){
            return (top==stackarray.length-1);
        }
        public void push(int x){
            if(isFull()){
                System.out.println("stack overflow");
                return;
            }
            top=top+1;
            stackarray[top]=x;
        }
        public int pop(){
            int x;
            if(isEmpty()){
                System.out.println("Stack underflow");
            }
            x=stackarray[top];
            top-=1;
            return x;
        }
    }
    class StackChar {
        private char[] stackarray;
        private int top;

        public StackChar() {
            stackarray = new char[10];
            top = -1;
        }

        public StackChar(int maxSize) {
            stackarray = new char[maxSize];
            top = -1;
        }

        public void push(char x) {
            top += 1;
            stackarray[top] = x;
        }

        public char pop() {
            char x = stackarray[top];
            top -= 1;
            return x;
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public char peek() {
            return stackarray[top];
        }
    }
}
