import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //untuk membaca input
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 30, 20, 50, 40}; //deklarasi array
        long startTimeArray;
        long endTimeArray;
        long startTimeArrayList;
        long endTimeArrayList;

        ArrayList<Integer> list = new ArrayList<>(); //deklarasi arraylist
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(50);
        list.add(40);

        int[] sortedArray = traversalArray(arr);
        ArrayList<Integer> sortedArrayList = traversalArrayList(list);

        System.out.println("Array Traversal " + Arrays.toString(sortedArray));//show and sort array
        System.out.println("ArrayList Traversal " + traversalArrayList(sortedArrayList));//show and sort arraylist
        System.out.println("-----------------------------------------");

        System.out.print("Masukkan input angka yang dicari ");
        int input = sc.nextInt();// membaca input
        startTimeArray = System.nanoTime();
        searchArray(input, sortedArray);// memulai pencarian pada array
        endTimeArray = System.nanoTime();
        startTimeArrayList = System.nanoTime();
        searchArrayList(input, sortedArrayList);// memulai pencarian pada array list
        endTimeArrayList = System.nanoTime();
        System.out.println("------------------------------------------");

        System.out.print("Masukkan input angka yang ingin di insert ");
        input = sc.nextInt();
        insertArray(input, sortedArray);// memulai penyisipan pada array
        insertArrayList(input, sortedArrayList);// memulai penyisipan pada arraylist
        System.out.println("------------------------------------------");

        System.out.println("Masukkan input angka yang ingin di hapus ");
        input = sc.nextInt();
        deleteArray(input, sortedArray);
        deleteArrayList(input, sortedArrayList); // memulai delete pada arraylist
        System.out.println("-------------------------------------------");

        System.out.println("Waktu eksekusi pencarian pada Array: " + ((endTimeArray - startTimeArray) / 1_000_000) + " ms");
        System.out.println("Waktu eksekusi pencarian pada ArrayList: " + ((endTimeArrayList - startTimeArrayList) / 1_000_000) + " ms");
    }

    //display and sort array
    public static int[] traversalArray(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        return arr;
    }

    //display and sort arraylist
    public static ArrayList<Integer> traversalArrayList(ArrayList<Integer> list) {
        list.sort(Integer::compareTo);
        return list;
    }

    // pencarian array
    public static void searchArray(int input, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == input) {
                System.out.println("Pencarian " + input + " dalam Array: Ditemukan di indeks " + i);
                break;
            }
        }
    }

    //pencarian arraylist
    public static void searchArrayList(int input, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == input) {
                System.out.println("Pencarian " + input + " dalam ArrayList: Ditemukan di indeks " + i);
            }
        }
    }

    //insert pada array
    public static void insertArray(int input, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > input) {
                System.arraycopy(arr, i, arr, i + 1, arr.length - i - 1);
                arr[i] = input;
                System.out.println("Array setelah penyisipan elemen " + input + ": " + Arrays.toString(arr));
                break;
            }
        }

    }

    //insert pada arraylist
    public static void insertArrayList(int input, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > input) {
                list.add(i, input);
                System.out.println("ArrayList setelah penyisipan elemen " + input + ": " + list);
                break;
            }
        }
    }

    // delete pada array
    public static void deleteArray(int input, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == input) {
                System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);
                System.out.println("Hasil Array setelah penghapusan " + input + ": " + Arrays.toString(arr));
                return;
            }
        }
    }

    //delete pada arraylist
    public static void deleteArrayList(int input, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == input) {
                list.remove(i);
                System.out.println("Hasil ArrayList setelah penghapusan " + input + ": " + list);
                return;
            }
        }
    }
}