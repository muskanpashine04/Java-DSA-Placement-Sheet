public class ArrayIntersection {

    public static void findIntersection(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;

        System.out.println("Intersection of the two arrays is:");

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 7, 8, 10};
        int[] arr2 = {3, 6, 7, 9, 10, 11};

        findIntersection(arr1, arr2); // Output: 3 7 10
    }
}
