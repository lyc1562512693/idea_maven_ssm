package applet.algorithm.sort;

import java.util.Arrays;

public class OrderUtils {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,3,4,9,8,7,7,3};
        //bubble(arr);
        //insert(arr);
        select(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        Arrays.stream(arr).forEach((i)-> System.out.print(i+","));
    }

    /**
     * 冒泡排序，当一次都没有发生元素交换则退出遍历
     * @param arr
     */
    public static void bubble(int[] arr){
        boolean flag ;
        for(int i = 0;i<arr.length-1;i++){
            flag = false;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];;
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
           if(!flag){break;}
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void select(int[] arr){
        for(int i= 0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
