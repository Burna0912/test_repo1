import java.io.*;
import java.util.*;

public class main {
    public static class MyStack<E> extends Vector<E> {
        public E push(E item) {
            add(item);
            return item;
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            } else {
                E poppedElement = get(size() - 1);
                remove(size() - 1);
                return poppedElement;
            }
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            } else {
                return get(size() - 1);
            }
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int search(Object o) {
            int i = indexOf(o);
            if (i >= 0) {
                return size() - i;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack<Integer> stack = new MyStack<>();
        List<String> outputMessages = new ArrayList<>();
        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                Integer num = Integer.valueOf(command[1]);
                stack.add(num);
            } else if (command[0].equals("pop")) {
                if (stack.isEmpty()) {
                    outputMessages.add("Stack is empty.");
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
        }

        outputMessages.forEach(System.out::println);
        Integer peekedNumber = stack.isEmpty() ? null : stack.get(stack.size() - 1);
        System.out.println("Peek: " + (peekedNumber != null ? peekedNumber : "Stack is empty."));
        System.out.println("Is Stack empty? " + (stack.isEmpty() ? "true" : "false"));
        Integer position = stack.search(3);
        System.out.println("Position of 3: " + (position != -1 ? position : "-1"));

    }
}