import java.util.Arrays;

public class InsertionSort {
    static public void main(String[] args){
        int[] pool = {85, 93, 52, 48, 37};
        insertionSort(pool);
        System.out.printf("Sorted Array: %s\n", Arrays.toString(pool));
    }

    static void insertionSort(int[] pool) {
        int n = pool.length;
        int temp;
        boolean dragged;

        for (int i = 0; i < n - 1; i++) {
            if (pool[i] > pool[i + 1]) {
                // swap
                temp = pool[i];
                pool[i] = pool[i + 1];
                pool[i + 1] = temp;
                for (int j = i; j > 0; j--) {
                    dragged = false;
                    if (pool[j - 1] > pool[j]) {
                        // swap
                        temp = pool[j];
                        pool[j] = pool[j - 1];
                        pool[j - 1] = temp;
                        dragged = true;
                    }

                    if(!dragged) break;
                }
            }
        }
    }
}
