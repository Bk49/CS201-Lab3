import java.util.*;
import java.util.stream.Collectors;

public class Q1Test {
    public static void main(String[] args) {

        String result, traversal1, traversal2, traversal3;

        traversal1 = "1-2";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Invalid traversals");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "1-2-3";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "1-2-3";
        traversal2 = "3-2-1";
        traversal3 = "2-3-1";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Invalid traversals");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "3-1-2-5-4";
        traversal2 = "2-1-4-5-3";
        traversal3 = "1-2-3-4-5";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Traversal 1 - Preorder, Traversal 2 - Postorder, Traversal 3 - Inorder");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "10-20-30-40-50";
        traversal2 = "20-10-30-40-50";
        traversal3 = "10-50-40-30-20";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");
        System.out.println("  Actual Result : " + result);
        System.out.println();
    }


    // write your codes here
    public static String verify(String traversal1, String traversal2, String traversal3) {
        List<Integer[]> traversals = checkSameElementsAndReturnAry(new String[]{traversal1, traversal2, traversal3});
        if (traversals == null) {
            return "Invalid traversals";
        }

        Integer[] sortedTrav = Arrays.stream(traversals.get(0)).sorted().toArray(Integer[]::new);


        return "Invalid traversals";
    }

    public static List<Integer[]> checkSameElementsAndReturnAry(String[] traversalStrs) {
        List<Integer[]> traversals = Arrays.stream(traversalStrs).map(traversalStr ->
                Arrays.stream(traversalStr.split("-"))
                        .map(Integer::parseInt).toArray(Integer[]::new)
        ).toList();

        List<Integer[]> sortedTraversals = traversals.stream().map(traversal ->
                Arrays.stream(traversal).sorted().toArray(Integer[]::new)
        ).toList();

        return Arrays.equals(sortedTraversals.get(0), sortedTraversals.get(1)) &&
                Arrays.equals(sortedTraversals.get(1), sortedTraversals.get(2)) ? traversals : null;
    }


}