import java.util.Arrays;

public class SelectionSort {
    static public void main(String[] args){
        int[] pool = {85, 93, 52, 48, 37};
        selectionSort(pool);
        System.out.printf("Sorted Array: %s", Arrays.toString(pool));
    }

    static void selectionSort(int[] pool){
        int n = pool.length;
        int smallest, temp;

        for(int i = 0; i < n; i++){
            smallest = i;
            for(int j = i; j < n; j++){
                if(pool[smallest] > pool[j]) smallest = j;
            }
            //swap
            temp = pool[i];
            pool[i] = pool[smallest];
            pool[smallest] = temp;
        }
    }
}
