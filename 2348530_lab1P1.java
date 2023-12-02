import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Performance {
    private int[] marks;

    public Performance() {
        marks = new int[10];
    }

    
    public void readMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the marks of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    
    public int highestMark() {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    
    public int leastMark() {
        int least = marks[0];
        for (int mark : marks) {
            if (mark < least) {
                least = mark;
            }
        }
        return least;
    }

    
    public int getMode() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int mark : marks) {
            frequencyMap.put(mark, frequencyMap.getOrDefault(mark, 0) + 1);
        }

        int mode = marks[0];
        int maxFrequency = 1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && entry.getKey() > mode)) {
                mode = entry.getKey();
                maxFrequency = frequency;
            }
        }

        return mode;
    }

    
    public int getFreqAtMode() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int mark : marks) {
            frequencyMap.put(mark, frequencyMap.getOrDefault(mark, 0) + 1);
        }

        int mode = marks[0];
        int maxFrequency = 1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && entry.getKey() > mode)) {
                mode = entry.getKey();
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }

    
    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.readMarks();
        performance.display();
    }
}
