package seminar_java.seminar_dz_3;
import java.util.*;

public class task1 {
    public static void main(String[] args) {
        //        1. Реализовать алгоритм сортировки слиянием
                System.out.println("1.");
                ArrayList<Integer> list1 = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list1.add(new Random().nextInt(5));
                }
                System.out.println(list1);
                list1 = new ArrayList<>(mergeSortList(list1));
                System.out.println(list1);
        
        //        2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
                System.out.println("2.");
                ArrayList<Integer> list2 = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list2.add(new Random().nextInt(5));
                }
                System.out.println(list2);
                deleteEvenNumbers(list2);
                System.out.println(list2);
        
        //        3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
                System.out.println("3.");
                ArrayList<Integer> list3 = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list3.add(new Random().nextInt(5));
                }
                System.out.println(list3);
                int min = Collections.min(list3);
                int max = Collections.max(list3);
                double mean = sumElements(list3) / list3.size();
                System.out.println("min = " + min + " max = " + max + " mean = " + mean);
               
            }
        
            public static ArrayList<Integer> mergeSortList(ArrayList<Integer> src) {
                if (src.size() <= 1) return src;
                ArrayList<Integer> left = new ArrayList<>(src.subList(0, src.size() / 2));
                ArrayList<Integer> right = new ArrayList<>(src.subList(left.size(), src.size()));
                return mergeList(mergeSortList(left), mergeSortList(right));
            }
        
            private static ArrayList<Integer> mergeList(ArrayList<Integer> left, ArrayList<Integer> right) {
                ArrayList<Integer> result = new ArrayList<>(Arrays.asList(new Integer[left.size() + right.size()]));
                for (int k = 0, i = 0, j = 0; k < result.size(); k++)
                    result.set(k, i < left.size() && (j == right.size()
                            || left.get(i) < right.get(j)) ? left.get(i++) : right.get(j++));
                return result;
            }
        
            public static void deleteEvenNumbers(ArrayList<Integer> list) {
                int i = 0;
                while (i < list.size()) {
                    if (list.get(i) % 2 == 0) {
                        list.remove(i--);
                    }
                    i++;
                }
            }
        
            public static double sumElements(ArrayList<Integer> list) {
                double sum = 0;
                for (Integer integer : list) {
                    sum += integer;
                }
                return sum;
            }
        
}