package assigment2;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class ques1 {
    public static void main(String[] args) {
        try (
                Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the total no of floors in the building: ");
            int size = sc.nextInt();
            int[] numArray = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.printf("enter the floor size given on day %d : ", i + 1);
                numArray[i] = sc.nextInt();
            }
            int new_array[] = new int[numArray.length];
            for (int i = 0; i < numArray.length; i++) {
                new_array[i] = numArray[i];
            }
            Arrays.sort(new_array);
            int max = new_array[new_array.length - 1];
            Stack<Integer> stk = new Stack<>();
            for (int i = 0; i < numArray.length; i++) {
                System.out.printf("\n Day : %d \n", i + 1);
                if (numArray[i] == max) {
                    System.out.print(numArray[i]);
                    while (!stk.empty()) {
                        if (numArray[i] == max) {
                            Integer x = (Integer) stk.pop();
                            System.out.print(x);
                            new_array = Arrays.copyOf(new_array, new_array.length - 1);
                            max = new_array.length - 1;
                        } else {
                            Integer x = (Integer) stk.pop();
                            System.out.print(x);
                            new_array = Arrays.copyOf(new_array, new_array.length - 1);
                            max = new_array.length - 1;
                        }
                    }
                }

                else {
                    stk.push(numArray[i]);
                }
            }
        }
    }
}