class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] mincoins = new int[amount+1];
        for(int i=1; i<= amount; i++){
            mincoins[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin <= i && mincoins[i-coin] != Integer.MAX_VALUE){
                    mincoins[i] = Math.min(mincoins[i], 1+mincoins[i-coin]);
                }

            }

        }

        if(mincoins[amount] == Integer.MAX_VALUE) return -1;
        return mincoins[amount];
    }
}