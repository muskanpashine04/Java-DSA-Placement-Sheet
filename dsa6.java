import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UnionIntersection {

    public static void findUnion(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();
        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
        }
        System.out.print("Union: ");
        for (int num : unionSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Size of Union: " + unionSet.size());
    }

    public static void findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }
        List<Integer> intersectionList = new ArrayList<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionList.add(num);
            }
        }
        System.out.print("Intersection: ");
        for (int num : intersectionList) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Size of Intersection: " + intersectionList.size());
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        findUnion(arr1, arr2);
        // Output:
        // Union: 1 2 3 4 5 6 7
        // Size of Union: 7
        findIntersection(arr1, arr2);
        // Output:
        // Intersection: 3 4 5
        // Size of Intersection: 3

        int[] arr3 = {10, 20, 30};
        int[] arr4 = {30, 40, 50};
        findUnion(arr3, arr4);
        // Output:
        // Union: 10 20 30 40 50
        // Size of Union: 5
        findIntersection(arr3, arr4);
        // Output:
        // Intersection: 30
        // Size of Intersection: 1
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionIntersectionEasy {

    public static void findUnion(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();
        // Add all elements from the first array
        for (int num : arr1) {
            unionSet.add(num);
        }
        // Add all elements from the second array (duplicates will be ignored by Set)
        for (int num : arr2) {
            unionSet.add(num);
        }

        System.out.print("Union: ");
        for (int num : unionSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Size of Union: " + unionSet.size());
    }

    public static void findIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersectionList = new ArrayList<>();
        // Iterate through the first array
        for (int num1 : arr1) {
            // For each element in the first array, check if it exists in the second array
            for (int num2 : arr2) {
                if (num1 == num2 && !intersectionList.contains(num1)) {
                    intersectionList.add(num1);
                    break; // To avoid adding duplicates if they exist in arr2
                }
            }
        }

        System.out.print("Intersection: ");
        for (int num : intersectionList) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Size of Intersection: " + intersectionList.size());
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        findUnion(arr1, arr2);
        // Output:
        // Union: 1 2 3 4 5 6 7
        // Size of Union: 7
        findIntersection(arr1, arr2);
        // Output:
        // Intersection: 3 4 5
        // Size of Intersection: 3
    }
}
