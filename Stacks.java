public class Stacks {
    char stk[];
    int size;
    int top = -1;

    Stacks(int size) {
        this.size = size;
        stk = new char[size];
    }

    void push(char data) {
        if (isFull()) {
            System.out.println("Stack overflow");
        } else {
            // top++;
            stk[++top] = data;
        }
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return 'f';
        } else {
            return stk[top--];
        }
    }

    char peek() {
        return stk[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {

    }
}