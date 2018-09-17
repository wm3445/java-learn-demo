package algorithm;

/**
 * @author wangmeng
 */
public class Sort {


    /**
     * [3,2,7,9,1]
     * 插入排序
     *
     * @param numbers
     */
    void insertSort(int[] numbers) {
        int position;
        for (int i = 1; i < numbers.length; i++) {
            position = i;
            int temp = numbers[i];
            while (position > 0 && numbers[position - 1] > temp) {
                numbers[position] = numbers[position - 1];
                position--;
            }
            numbers[position] = temp;


        }

    }


    void quickSort(int[] numbers, int head, int tail) {

        if (head > tail) {
            return;
        }
        // 已第一个元素为基准点
        int pivot = numbers[head];
        int i = head, j = tail;
        while (i != j) {
            while (numbers[j] >= pivot && i < j) {
                --j;
            }
            while (numbers[i] <= pivot && i < j) {
                ++i;
            }
            if (i < j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }

        }
        numbers[head] = numbers[i];
        numbers[i] = pivot;

        quickSort(numbers, head, i - 1);
        quickSort(numbers, i + 1, tail);

    }


    void quickSort2(int[] numbers, int head, int tail) {
        // 已中间元素为基准点
        int i = head, j = tail, pivot = numbers[(head + tail) / 2];

        while (i <= j) {
            // 找一个大于基准值的下标位置
            while (numbers[i] < pivot) {
                i++;
            }
            // 右侧找第一个小于基准值的下标
            while (numbers[j] > pivot) {
                j--;
            }
            // 找到了就转换位置
            if (i < j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        // 所有转换完成之后就完成了第一次左侧都为小于基准值的，右侧都是大于基准值的。


        quickSort(numbers, head, j);
        quickSort(numbers, i, tail);


    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[]{3, 2, 7, 9, 1};
        //sort.insertSort(arr);

        sort.quickSort2(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

}
