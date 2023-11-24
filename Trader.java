public class Trader {
    private static int maxProfit;

    public static int Profit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; 
        }

        int n = prices.length;
        int[] FirstBuy = new int[n];
        int[] FirstSell = new int[n];
        int[] SecondBuy = new int[n];
        int[] SecondSell = new int[n];

        FirstBuy[0] = -prices[0];
        FirstSell[0] = 0;
        SecondBuy[0] = Integer.MIN_VALUE;
        SecondSell[0] = 0;

        for (int i = 1; i < n; i++) {
            FirstBuy[i] = Math.max(FirstBuy[i - 1], -prices[i]);
            FirstSell[i] = Math.max(FirstSell[i - 1], FirstBuy[i - 1] + prices[i]);
            SecondBuy[i] = Math.max(SecondBuy[i - 1], FirstSell[i - 1] - prices[i]);
            SecondSell[i] = Math.max(SecondSell[i - 1], SecondBuy[i - 1] + prices[i]);
        }
        maxProfit = SecondSell[n - 1];

        return maxProfit;
    }

    public static void main(String[] args) {
        
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        int result1 = Profit(prices1);
        System.out.println("Output for prices1: " + result1);

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        int result2 = Profit(prices2);
        System.out.println("Output for prices2: " + result2);
    }
}
