import java.util.*;

public class FrequentNumbers {
    private static int[] numbers;
    
    public static List<Integer> FrequentNumbers(int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt((Integer num) -> frequencyMap.get(num))
                        .thenComparingInt(num -> -num) 
        );

        for (int num : frequencyMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll()); 
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample test cases
        numbers = new int[]{3, 1, 4, 4, 5, 2, 6, 1};
        int k1 = 3;
        List<Integer> result1 = FrequentNumbers(k1);
        System.out.println("Output for K=" + k1 + ": " + result1);

        numbers = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k2 = 6;
        List<Integer> result2 = FrequentNumbers(k2);
        System.out.println("Output for K=" + k2 + ": " + result2);
    }
}
