public class AliceAndBob {
//Please fill in the main class as needed

//solution
    private static int getMaxCountOfApple(int[] A, int K, int L) {
        int l = A.length;
        if (l < (K+L)) {
            return -1;
        } else if (l == (K+L)) {
            int sum = 0;
            for (int i = 0; i<l; i++) {
                sum = sum+A[i];
            }
            return sum;
        } else {
            if (K > L) {
                int aliceCount[] = getSumOfAppleForMost(A, K);
                int bobCount = getSumOfAppleForLeast(A, L, aliceCount[1], K);
                return aliceCount[0] + bobCount;
            } else {
                int bobCount[] = getSumOfAppleForMost(A, L);
                int aliceCount = getSumOfAppleForLeast(A, K, bobCount[1], L);
                return bobCount[0] + aliceCount;
            }
        }
    }

    private static int[] getSumOfAppleForMost(int tree[], int count) {
        int sum = 0;
        int maxCount = 0;
        int index = -1;
        //int[] appleSumAndIndex = new int[2];
        for (int i = 0; i<=tree.length-count; i++) {
            sum = 0;
            for (int j = i; j<(i+count); j++) {
                sum = sum + tree[j];
            }
            if (maxCount < sum) {
                maxCount = sum;
                index = i;
            }
        }
        int appleSumAndIndex[] = {maxCount, index};
        return appleSumAndIndex;
    }

    private static int getSumOfAppleForLeast(int [] tree, int count, int index, int initialCount) {
        int sum = 0;
        int maxSum = 0;
        for (int i =0; i<=(tree.length-count); i++) {
            sum = 0;
            for (int j=i; j<i+count; j++) {
                if (j < index || j>= (index+initialCount)) {
                    sum = sum+tree[j];
                } else {
                    sum = 0;
                    break;
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
