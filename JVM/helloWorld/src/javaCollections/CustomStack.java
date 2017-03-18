package javaCollections;

// Q7 Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
// and an additional operation getMin() which should return minimum element from the SpecialStack. (Expected complexity ­ O(1))
public class CustomStack {
    private int top;
    private int stack[];
    private int size = 0;
    private int min = Integer.MAX_VALUE;
    public CustomStack(int size) {
        this.size = size;
        if (size < 1) {
            size = this.size = 10;
        }
        stack = new int[size];
        top = size;

        initStack();
    }

    private void initStack() {
        for (int count = 0; count < size; count++) {
            stack[count] = -1;
        }
    }


    public int getMin() {
        if(isEmpty())return -1;
        return min;
    }

    public int getSize() {
        return size;
    }

    public void push(int num) {
        stack[--top] = num;
        min = stack[top] < min ? stack[top] : min;
    }

    public int pop() {
        int val=stack[top];
        stack[top++]=-1;

        if (val == min) {
            resetMin();
        }

        return val;
    }

    private void resetMin() {
        int min = Integer.MAX_VALUE;

        for (int count = 0; count < size; count++) {
            min = (stack[count] < min && stack[count] != -1) ? stack[count] : min;
        }

        this.min = min;
    }

    public boolean isEmpty() {
        return top == size;
    }

    public boolean isFull() {
        return top == 0;
    }
    public static void main(String[] args) {
        CustomStack s = new CustomStack(5);
        System.out.println(" isEmpty : " + s.isEmpty());
        s.push(8);
        s.push(9);
        s.push(7);
        s.push(6);
        s.push(5);
        System.out.println(" isFull : " + s.isFull());
        System.out.println(" minimum : " + s.getMin());
        System.out.println("pop : " + s.pop());
        System.out.println("pop : " + s.pop());
        System.out.println(" minimum : " + s.getMin());
    }

}
