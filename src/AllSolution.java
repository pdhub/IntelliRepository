import java.util.Arrays;

/**
 * Created by PDeb on 11/14/2016.
 */
public class AllSolution {
    public static void main(String[] args) {
        longestBitonicSequence();
        knapsack0_1();
        numberOfWaysinfiniteCoinsParticularSum();
    }

    private static void numberOfWaysinfiniteCoinsParticularSum() {
        int[] coins = {1,2,3};
        int sum = 4;
        int table[] = new int[sum+1];

        Arrays.fill(table, 0);
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i< coins.length; i++)
            for(int j=coins[i]; j<= sum; j++)
                table[j] += table[j-coins[i]];

        System.out.println("numberOfWaysinfiniteCoinsParticularSum : "+ table[sum]);
    }

    private static void knapsack0_1() {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  totalWt = 50;

        int knapsack[][] = new int[val.length+1][totalWt+1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= totalWt; j++) {
                if (i == 0 || j == 0) {
                    knapsack[i][j] = 0;
                    continue;
                }
                if (wt[i - 1] <= j) {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j],knapsack[i - 1][j - wt[i - 1]] + val[i - 1]);
                }else {
                    knapsack[i][j] = knapsack[i-1][j];
                }
            }
        }
        System.out.println("knapsack : " + knapsack[val.length][totalWt]);
    }

    private static void longestBitonicSequence() {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j])
                    lis[i] = Math.max(lis[i],lis[j]+1);
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }

        int max = 0;
        for (int i=0; i < arr.length; i++)
        {
            int temp = lis[i]+lds[i]-1;
            if(max < temp)
                max = temp;
        }
        System.out.println("max bitonic seq : "+ max);
    }
}
