//Nama : M. Imam Pratama
//NIM : 09021281722063
//Kelas : IF REG A '17

// package mystack;

/**
 *
 * @author Riska
 */
public class MyStack {

    public static class StackList {

        public class StackNode {

            private int value;
            private StackNode next;

            public StackNode(int newValue) {
                this.value = newValue;
                this.next = null;
            }

            // Implementasikan fungsi get
            public int getValue() {
                return this.value;
            }

            public StackNode getNext() {
                return this.next;
            }

            // Implementasikan fungsi set
            public void setValue(int newValue) {
                this.value = newValue;
            }

            public void setNext(StackNode newNext) {
                this.next = newNext;
            }

        }

        public StackNode head;
        public int size;

        public StackList() {
            this.size = 0;
            this.head = null;
        }

        // Implementasi isEmpty()
        public boolean isEmpty() {
            if (this.size == 0)
                return true;
            else
                return false;
        }

        // Implementasi push, pop, peek, & printStack

        public void push(int data) {
            if (isEmpty()) {
                this.head = new StackNode(data);
            } else {
                StackNode pointer = this.head;
                while (pointer.getNext() != null) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(new StackNode(data));
            }
            this.size++;
        }

        public StackNode pop() {
            StackNode returnNode = null;
            if (!isEmpty()) {
                if (this.size == 1) {
                    returnNode = this.head;
                    this.head = null;
                } else {
                    StackNode pointer = this.head;
                    while (pointer.getNext().getNext() != null) {
                        pointer = pointer.getNext();
                    }
                    returnNode = pointer.getNext();
                    pointer.setNext(null);
                }
                this.size--;
            } else {
                System.out.println("Stack kosong!");
            }
            return returnNode;
        }

        public int peek() {
            if (!isEmpty()) {
                if (this.size == 1) {
                    return this.head.getValue();
                } else {
                    StackNode pointer = this.head;
                    while (pointer.getNext().getNext() != null) {
                        pointer = pointer.getNext();
                    }
                    return pointer.getNext().getValue();
                }
            } else {
                System.out.println("Stack kosong!");
                return -1;
            }
        }

        public void printStack() {
            System.out.print("[");
            if (!isEmpty()) {
                StackNode pointer = this.head;
                while (pointer.getNext() != null) {
                    System.out.print(pointer.getValue() + ", ");
                    pointer = pointer.getNext();
                }
                System.out.print(pointer.getValue());
            }
            System.out.println("]");
        }
    }

    public static class StackArray {
        public int mymax = 10;

        public int[] value;
        public int top;
        public int size; // Tak terpakai... 🤔

        public StackArray() {
            // Implementasi konstruktor
            this.value = new int[mymax];
            this.top = 0;
            this.size = mymax - 1; // Tak terpakai... 🤔
        }

        // Implementasi isEmpty() dan isFull()
        public boolean isEmpty() {
            if (this.top == 0)
                return true;
            else
                return false;
        }

        public boolean isFull() {
            if (this.top == this.mymax)
                return true;
            else
                return false;
        }

        // Implementasi fungsi push, pop, peek, & printStack
        public int push(int data) {
            if (!isFull()) {
                this.value[this.top] = data;
                this.top++;
            } else {
                System.out.println("Stack sudah penuh!");
            }
            return data;
        }

        public int pop() {
            if (!isEmpty()) {
                this.top--;
                return this.value[this.top];
            } else {
                System.out.println("Stack kosong!");
                return -1;
            }
        }

        public int peek() {
            if (!isEmpty())
                return this.value[this.top - 1];
            else
                System.out.println("Stack kosong...");
            return -1;
        }

        public void printStack() {
            System.out.print("[");
            for (int i = 0; i < this.top; i++) {
                System.out.print(this.value[i]);
                if (i != this.top - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }

        public void sort() {
            for (int i = 0; i < top - 1; i++) {
                for (int j = 0; j < top - i - 1; j++) {
                    if (this.value[j] > this.value[j + 1]) {
                        int temp = this.value[j];
                        this.value[j] = this.value[j + 1];
                        this.value[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        // Panggil StackList
        StackList sl = new StackList();
        int temp;
        sl.push(5);
        sl.push(6);
        sl.push(7);
        sl.push(8);
        sl.printStack();
        System.out.println("Isi teratas stack list = " + sl.peek());
        temp = sl.pop().getValue();
        System.out.println("Isi teratas stack list = " + sl.peek());

        // Panggil StackArray
        StackArray sa = new StackArray();
        sa.push(10);
        sa.push(11);
        sa.push(12);
        sa.push(13);
        sa.printStack();
        System.out.println("Isi teratas stack list = " + sa.peek());
        temp = sa.pop();
        System.out.println("Isi teratas stack list = " + sa.peek());

        // StackArray baru utk testing sorting stack
        StackArray sa2 = new StackArray();

        // Push 10-1
        for (int i = 10; i > 0; i--) {
            sa2.push(i);
        }

        sa2.printStack();

        // Pop 5 kali
        for (int i = 0; i < 5; i++) {
            sa2.pop();
        }

        sa2.printStack();

        // Sorting stacknya
        sa2.sort();

        sa2.printStack();

        printBinary(156);
    }

    static void printBinary(int decimal) {
        StackArray binaryStack = new StackArray();
        while (decimal != 1) {
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }
        binaryStack.push(1);

        String binary = "";
        while (!binaryStack.isEmpty()) {
            // System.out.print(binaryStack.pop());
            binary += binaryStack.pop();
        }
        System.out.println(binary);

        // Sorting array
        int[] arr = { 8, 7, 6, 5, 4, 7, 4, 3, 1, 3, -2 };

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort(arr, 11);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int stackSize) {
        for (int i = 0; i < stackSize - 1; i++) {
            for (int j = 0; j < stackSize - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}