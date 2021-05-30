package serching_and_sorting;

public class Client extends Cls1 {
    public static void main(String[] args) throws Exception{
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 };
        int target = 4;
        System.out.println(binarySearch(arr, target));
        System.out.println(findClosest(arr, target));
    }
}
