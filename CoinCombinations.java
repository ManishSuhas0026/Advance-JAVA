import java.util.Scanner;

public class CoinCombinations {

    // Variable to store total combinations

    // Shared variable for communication between the two threads
    private static int totalCombinations;

    // Setter method to set the total combinations
    // Only one thread can execute this method at a time because of synchronized

    public static synchronized void setTotalCombinations(int combinations){

        totalCombinations = combinations;
    }

    // Getter method to retrieve the total combinations
    // Only one thread can execute this method at a time because of synchronized

    public static synchronized int getTotalCombinations(){
        return totalCombinations;
    }

    // Dynamic programming Approach
    // This function is to calculate the number of combinations to achieve the target sum

    public static int countCoinCombinations(int[] coins, int targetSum){
        int[] dp = new int[targetSum+1];

        // Considering there is only one way to reach a sum of 0 (using a empty set of coins)

        dp[0] = 1; 

        for(int coin:coins){
            for(int i=coin; i<=targetSum;i++){
                dp[i] += dp[i-coin];
        }
    }
    return dp[targetSum]; // Return the total combinations for the target sum

}

   public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    // Obtaining user input for the number of coins,values and target sum

    System.out.println(" ");
    System.out.println("Coin Combinations");
    System.out.println("-----------------");
    System.out.print("Enter the number of coins: ");
    int numCoins = input.nextInt();

    int[] coinValues = new int[numCoins];
    for(int i=0;i<numCoins;i++){
        System.out.print("Enter the value of coin " + (i+1)+": ");
        coinValues[i] = input.nextInt();
    }

    System.out.print("Enter the target sum: ");
    int sumValue = input.nextInt();

    input.close();

    // Thread for handling user input and calculating combinations

    Thread inpThread = new Thread(()->{

    int combinations = countCoinCombinations(coinValues, sumValue); // Calculating Combinations
    setTotalCombinations(combinations);

   });

   // Thread for displaying the computed total combinations

   Thread compThread = new Thread(()->{
    try{
        inpThread.join(); // Waits for the input thread to complete it's task
        int combinations = getTotalCombinations();
        System.out.println(" ");
        System.out.println("Total Possible Ways or Combinations: " + combinations);
        System.out.println(" ");
    }catch(InterruptedException e){
        System.out.println(e);
    }

   });

   // Starting both the thread
   inpThread.start();
   compThread.start();

  }
}