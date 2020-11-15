package applet.algorithm.sort;

import java.util.*;

/**
 * 经典排序算法
 * @author Rzxuser
 *
 */
public class ClassicalOrder {

    //public static int[] arr = new int[]{1,3,5,9,10,8,2,4};
    public static int[] arr = new int[]{0,7,6,4,5,3,9,2,8};
    public static void main(String[] args) {
        //insertSort();
        //bubbleSort();
        //selectSort();
        //shellSort();
        //int[] arr = new int[]{7,6,4,8,9,2};
        //quickSort(arr,0,arr.length-1);
        //mergeSort(arr,0,arr.length -1);
        //bucketSort();
        heapSort(arr);
        Arrays.stream(arr).forEach((i) -> System.out.print(i+","));
        Collections.sort(new ArrayList<Integer>());
        Arrays.sort(new int[]{1,3});
    }
    /**
     * maopao
     */
    public static void bubbleSort(){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡优化，没有元素交换则退出
     */
    public static void bubbleSortPro(){
        for(int i = 0; i < arr.length - 1; i++){
            boolean flag = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    /**
     * 选择排序
     */
    public static void selectSort(){
        for(int i = 0; i < arr.length-1; i++){
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
    /**
     * 插入排序(对于基本有序的序列特别快)
     */
    public static void insertSort(){
        for(int i = 1;i<arr.length;i++){
            int num = arr[i];
            int j = i;
            for(; j >= 1 && num<arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            if(j != i)
                arr[j] = num;
        }
    }
    /**
     * shell(balanced insert)(先让他基本有序，在利用插入排序来排)
     */
    public static void shellSort() {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int num = arr[i];
                int j = i;
                for (; j >= gap && num > arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                if(j != i)
                    arr[j] = num;
            }
            gap = gap / 2;
        }
    }
    /**
     * quick-找中点，左右分类；左边递归，右边递归(时间复杂度：大部分情况下都是O(nlogn)，极端情况下会退化到O(n2);空间复杂度：原地排序，O(1);不稳定排序)
     */
    public static void quickSort(int[] arr,int start, int end){
        if(start < end){
            int index = simpleBubble(arr, start, end);//获取基础（中位数）位置
            //index这个位置的元素就不再参与排序了
            quickSort(arr, start, index -1);
            quickSort(arr, index+1, end);
        }
    }
    public static int simpleBubble(int[] arr, int start, int end){
        int mid = arr[start];
        while(start < end){
            while(start < end && arr[end] >= mid){
                end--;
            }
            if(start < end){
                arr[start] = arr[end];
                start++;
            }
            while(start < end && arr[start] <= mid){
                start++;
            }
            if(start < end){
                arr[end] = arr[start];
                end--;
            }
        }
        //走到这里的时候start=end，且索引start（end）左边的都比mid大，start（end）右边的都比mid小
        arr[start] = mid;
        return start;
    }
    //下面这种写法会多了几次重复的比较及赋值操作，虽然结果也是对的，但是不推荐
    public static int simpleBubble2(int[] arr, int start, int end){
        int mid = arr[start];
        while(start < end){
            while(start < end && arr[end] <= mid){
                end--;
            }
            //if(start < end){
            arr[start] = arr[end];
            //start++;
            //}
            while(start < end && arr[start] >= mid){
                start++;
            }
            //if(start < end){
            arr[end] = arr[start];
            //end--;
            //}
        }
        arr[start] = mid;
        return start;
    }
    /**
     * heap(balanced xuanzhe)
     */
    public static void heapSort(){
    //最大堆排序
        for(int i = arr.length -1; i> 0;i--){
            maxHeap(i);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }
    public static void maxHeap(int i){
        int child;
        for(int j = (i-1)/2;j>=0;j--){
            child = 2*j+1;
            if(child != i && arr[child] < arr[child + 1]){
                child++;
            }
            if(arr[j] < arr[child]){
                int temp = arr[j];
                arr[j] = arr[child];
                arr[child] = temp;
            }
        }
    }

    /**
     * 堆排序优化版（该版本较之于上面的版本，只需要第一次对所有元素堆化，而后面取出堆顶最大值后，在对剩余元素建堆时，只需要处理堆顶元素即可）
     * @param arr
     */
    public static void heapSort(int[] arr){//假设堆内元素从1开始，到n，其中arr.length = n +1;
        //建初始堆（对1~n/2索引处元素建堆）
        buildHeap(arr,arr.length - 1);
        int end = arr.length - 1;
        while(end > 1){
            int temp = arr[1];
            arr[1] = arr[end];
            arr[end] = temp;
            heapify(arr,1,--end);
        }
    }
    public static void buildHeap(int[] arr, int n){
        for(int i = n/2; i >= 1; i--){
            heapify(arr,i,n);
        }
    }
    public static void heapify(int[] arr, int i, int n){
        while(true){
            int maxIndex = i;
            if(2*i<=n && arr[maxIndex] < arr[2*i])
                maxIndex = 2*i;
            if(2*i+1<=n && arr[maxIndex] < arr[2*i+1])
                maxIndex = 2*i+1;
            if(maxIndex == i)
                break;
            //交换maxIndex索引处和i索引处的值
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
            i = maxIndex;
        }
    }
    /**
     * 归并排序：分而后和(时间复杂度：任何情况下都是O(nlogn);空间复杂度：非原地排序，O(n)；稳定排序)
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    public static void merge(int[] arr, int start,int mid, int end){
        int[] temp = new int[end - start + 1];
        int t = 0;//临时数列temp的起始
        int s = start, e = mid + 1;//定义左边数列和右边数列的起始
        while(s <= mid && e <= end){
            if(arr[s] <= arr[e]){
                temp[t++] = arr[s++];
            }else{
                temp[t++] = arr[e++];
            }
        }
        while(s <= mid){
            temp[t++] = arr[s++];
        }
        while(e <= end){
            temp[t++] = arr[e++];
        }
        for(int i = 0;i < temp.length; i++){
            arr[start + i] = temp[i];
        }
    }
    /**
     * 计数排序（计数排序是捅排序的一种特殊情况，即所排数据都是数值，且范围不大）
     * 缺点，因为该排序是基于数组可直接根据索引下标获取值的特性，因此需要使用连续的内存空间
     * 桶排序：就是按照数据类别或者范围对数据进行分桶，各个桶之间是确定的顺序，桶内部可使用快排排序；例如有一堆1-1000的数，则可以按照100间隔分桶，1-100在第一个桶
     */
    public static void countSort(){
        //先找出最大值
        int max = arr[0];
        for(int i = 0;i< arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //初始化一个以待排序数列最大值+1为大小的捅
        int[] bucket = new int[max + 1];
        //开始装桶
        for(int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        //输出结果
        for(int i = bucket.length-1;i >= 0;i--){
            while(bucket[i]-- != 0){
                System.out.print(i+",");
            }
        }
        System.out.println();
    }
    //桶排序
    public void bucketSort(){}
    //基数排序：基数排序即是使用按位使用稳定排序的思想；例如对1000万个手机号排序，由于手机号数值太大，不适合普通排序，因此可以先按照末尾对所有手机号进行稳定排序，在按照倒数第二位排序。。。这样只需要进行11次稳定排序即可排出结果
    //注意如果要排序的数或者字符串，长度不一致，可以按照高位补0的方法，因为根据ASCII值，所有字母都大于0；如果有负数可以加上指定大小整数转为正数；如果有小数，可以乘以10的倍数，化小数为整数。
    public void RadixSort(){}
}
