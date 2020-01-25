import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Grade class. Will use it to sort elements in a priority queue by name and gpa.
 */
class Grade {

  // **** members ****
  public String name;
  public double gpa;

  // **** constructor ****
  public Grade(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  // **** toString ***
  public String toString() {
    return this.gpa + " " + this.name;
  }
}

/*
 * Experiment with the PriorityQueue class.
 */
public class PriorityQ {

  /*
  *
  */
  static void experiment(int[] arr, Grade[] grades) {

    // **** get the size of the array ****
    int size = arr.length;

    // ???? ????
    System.out.println("experiment <<< size: " + size);

    // **** overwrite the initial size of the priority queue ****
    size = 3;

    // **** create a PriorityQueue without comparator ****
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(size);

    // **** add the array values to the priority queue ****
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }

    // **** display the priority queue (random order) ****
    System.out.println("experiment <<< pq: " + pq.toString());

    // **** remove in order elements from the queue (lower to higher) ***
    System.out.print("experiment <<< pq: ");
    while (pq.size() != 0) {
      System.out.print(pq.remove() + " ");
    }
    System.out.println("\n");

    // **** PriorityQueue with comparator (higher to lower) ****
    pq = new PriorityQueue<Integer>(size, (Integer a, Integer b) -> {
      int result = 0;
      if (a < b) {
        result = 1;
      } else if (a > b) {
        result = -1;
      }
      return result;
    });

    // **** add the array values to the priority queue ****
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }

    // **** display the priority queue (random order) ****
    System.out.println("experiment <<< pq: " + pq.toString());

    // **** remove in order elements from the queue (higher to lower) ***
    System.out.print("experiment <<< pq: ");
    while (pq.size() != 0) {
      System.out.print(pq.remove() + " ");
    }
    System.out.println("\n");

    // **** create a PriorityQueue without comparator or size ****
    pq = new PriorityQueue<Integer>();

    // **** sort the array ****
    Arrays.sort(arr);

    // *** display the array ****
    System.out.println("experiment <<< arr: " + Arrays.toString(arr));

    // **** add the array values to the priority queue ****
    for (int i = 0; i < arr.length; i++) {
      pq.add(arr[i]);
    }

    // **** display the priority queue (random order) ****
    System.out.println("experiment <<< pq: " + pq.toString());

    // **** remove in order elements from the queue (lower to higher) ***
    System.out.print("experiment <<< pq: ");
    while (pq.size() != 0) {
      System.out.print(pq.remove() + " ");
    }
    System.out.println("\n");

    // **** create a PriorityQueue with comparator ****
    PriorityQueue<Grade> studentGrades = new PriorityQueue<Grade>((Grade g1, Grade g2) -> {
      int result = 0;

      if (g1.gpa < g2.gpa) {
        result = -1;
      } else if (g1.gpa == g2.gpa) {
        int comp = g1.name.compareTo(g2.name);
        result = comp;
      } else {
        result = 1;
      }

      return result;
    });

    // **** add the grade values to the priority queue ****
    for (int i = 0; i < grades.length; i++) {
      studentGrades.add(grades[i]);
    }

    // **** display the priority queue (random order) ****
    System.out.println("experiment <<< studentGrades: " + studentGrades.toString());

    // **** remove in order elements from the queue (lower to higher) ***
    System.out.print("experiment <<< studentGrades: ");
    while (studentGrades.size() != 0) {
      System.out.print(studentGrades.remove() + " ");
    }
    System.out.println("\n");

  }

  // **** open scanner ****
  static Scanner sc = new Scanner(System.in);

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) {

    // **** read the number of elements for the queue ****
    int n = sc.nextInt();

    // **** read the line with the integers ****
    sc.nextLine();
    String buffer = sc.nextLine();

    // **** extract the strings holding integers from the buffer ****
    String[] strs = buffer.split(" ");

    // **** create and populate an array of integers ****
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strs[i]);
    }

    // ???? ????
    System.out.println("main <<< arr: " + Arrays.toString(arr));

    // **** read number of students and grades ****
    int m = sc.nextInt();

    // **** read the student grades into an array ****
    Grade[] grades = new Grade[m];
    sc.nextLine();
    for (int i = 0; i < m; i++) {
      String str = sc.nextLine();
      String[] vals = str.split(" ");
      grades[i] = new Grade(vals[0], Double.parseDouble(vals[1]));
    }

    // ???? ????
    System.out.println("main <<< grades: " + Arrays.toString(grades) + "\n");

    // **** experiemnt with a PriorityQueue ****
    experiment(arr, grades);

    // **** close scanner ****
    sc.close();
  }
}