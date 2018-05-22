import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {

        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Test Cases");
        int testCases = sc.nextInt();
        ArrayList<Integer> elementsCount = new ArrayList<>();
        ArrayList<ArrayList> elements = new ArrayList<>();
        int index = 0;

        while(testCases != index){
            System.out.println("Enter the number of elements in a test case number:" + (index+1));
            int number =  sc.nextInt();
            elementsCount.add(index, number);
            int innerIndex = 0;
            System.out.println("Enter the elements in array numbered:" + (index+1));
            ArrayList<Integer> eachArray = new ArrayList<>();
            while (number != innerIndex){
                eachArray.add(sc.nextInt());
                innerIndex++;
            }
            elements.add(index, (ArrayList) eachArray.clone());
            index++;
        }
        for (int i=0; i<testCases; i++){
            //This will be done for each test case
            int iteration = 1;
            ArrayList<Integer> testCaseArray = (ArrayList<Integer>) elements.get(i);
            while (testCaseArray.size() != 1){
                int[] rotated = sol.rotate(sol.convertIntegers(testCaseArray), 1, 1);
                testCaseArray =  sol.convertArrayList(rotated);
                if ((testCaseArray.size() - iteration) < 0){
                    testCaseArray.remove(0);
                }else {
                    testCaseArray.remove((testCaseArray.size() - iteration));
                }
                iteration++;

            }
            System.out.println("Answer for a testcase is: "+testCaseArray.get(0));
        }


    }

    int[] rotate(int[] array, int numberofElementsToBeRotated, int orientation){
        int sizeofArray = array.length;
        if (numberofElementsToBeRotated == sizeofArray){return array;}
        int[] answer = new int[sizeofArray];
        int iteration = 0;
        while(iteration != numberofElementsToBeRotated){
            int elementInRotation = array[sizeofArray-1-iteration];
            int positionInAnswer = numberofElementsToBeRotated - 1 - iteration;
            answer[positionInAnswer] = elementInRotation;
            iteration++;
        }
        for(int i=0; i<(sizeofArray-numberofElementsToBeRotated); i++){
            answer[i+numberofElementsToBeRotated] = array[i];
        }
        for (int i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }

    public int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    public ArrayList<Integer> convertArrayList(int[] integers){
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i=0; i < integers.length; i++)
        {
            ret.add(i, integers[i]);
        }
        return ret;
    }
}
