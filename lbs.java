import java.util.Arrays;

public class lbs {
    public static int lbs1(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int[] increasing = new int[n];
        int[] tail1 = new int[n];
        int[] decreasing = new int[n];
        int[] tail2 = new int[n];
        int lis = 1;

        increasing[0] = arr[0];
        tail1[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < increasing[0]) {
                increasing[0] = arr[i];
                tail1[i] = 0;
            } else {
                if (arr[i] > increasing[lis - 1]) {
                    increasing[lis++] = arr[i];
                    tail1[i] = lis - 1;
                } else {
                    increasing[Arrays.binarySearch(increasing, 0, lis - 1, arr[i])] = arr[i];
                    tail1[i] = Arrays.binarySearch(increasing, 0, lis - 1, arr[i]);
                }
            }
        }
        lis = 1;

        int[] arrRev = reverse(arr);
        decreasing[0] = arrRev[0];
        tail2[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arrRev[i] < decreasing[0]) {
                decreasing[0] = arrRev[i];
                tail2[i] = 0;
            } else {
                if (arrRev[i] > decreasing[lis - 1]) {
                    decreasing[lis++] = arrRev[i];
                    tail2[i] = lis - 1;
                } else {
                    decreasing[Arrays.binarySearch(decreasing, 0, lis - 1, arrRev[i])] = arrRev[i];
                    tail2[i] = Arrays.binarySearch(decreasing, 0, lis - 1, arrRev[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int sum = tail1[i] + tail2[i] + 1;
            if (ans < sum)
                ans = sum;
        }
        return ans;
    }


    public static int[] reverse(int a[]) {
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }
}