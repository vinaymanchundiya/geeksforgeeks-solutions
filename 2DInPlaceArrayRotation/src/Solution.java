public class Solution {

    static int[][] array;
    private static final int arraySize= 9;
    static int start = 0;
    static int end = arraySize-1;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        formArray();
        printArray();
        rotateArrayInPlace();
        System.out.println("_________________________");
        printArray();
    }

    public static void formArray(){
        int k = 1;
        array = new int[arraySize][arraySize];
        for(int i=0; i < arraySize; i++){
            for(int j=0; j<arraySize; j++){
                array[i][j] = k;
                k++;
            }
        }
    }

    public static void printArray(){
        for(int i=0; i<arraySize; i++){
            for(int j=0; j<arraySize; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
    }


    public static void rotateArrayInPlace(){
        int k = 0;
        while (k<start){
            k++;
        }
        while ((k >= start) && (k < end)){
            //1st swap
            int startElem = array[start][k];
            int temp = array[k][end];
            array[k][end] = startElem;
            array[start][k] = temp;

            //2nd Swap
            temp = array[end][end - k + start];
            array[end][end - k + start] = array[start][k];
            array[start][k] = temp;

            //3rd Swap
            temp = array[end - k + start][start];
            array[end - k + start][start] = array[start][k];
            array[start][k] = temp;
            k++;
        }

        if ((start + 1) < (end - 1)){
            start++;
            end--;
            rotateArrayInPlace();
        }
    }
}
