

public class GlassBall {
    /**
     * Returns the minimum floor that causes breaking ball - using 2 balls and dividing the building into equal parts
     * Complexity: O(sqrt(n)) - 2*sqrt(n)
     */
    public static int glassBall1(int[] floors, int ball) {
        int n = floors.length;
        int step = (int) Math.sqrt(n);
        int currentFloor = step;
        boolean isBreak = false;
        while(!isBreak) {
            if(floors[currentFloor] > ball) {
                currentFloor = currentFloor - step + 1;
                while(!isBreak) {
                    if(floors[currentFloor] > ball) {
                        return currentFloor;
                    }
                    currentFloor++;
                }
            }
            if(currentFloor == n-1) break;
            currentFloor += step;
            if(currentFloor > n-1) currentFloor = n-1;
        }
        return n;
    }

    /**
     * Returns the minimum floor that causes breaking ball - using 2 balls and dividing the building into different parts
     * Complexity: O(sqrt(n)) - sqrt(2*n)
     */
    public static int glassBall2(int[] floors, int ball) {
        int n = floors.length;
        int step = 1;
        while((step*(step+1))/2 < n) {
            step++;
        }
        int currentFloor = step;
        boolean isBreak = false;
        while(!isBreak) {
            if(floors[currentFloor] > ball) {
                currentFloor = currentFloor - step + 1;
                while(!isBreak) {
                    if(floors[currentFloor] > ball) {
                        return currentFloor;
                    }
                    currentFloor++;
                }
            }
            if(currentFloor == n-1) break;
            step--;
            currentFloor += step;
            if(currentFloor > n-1) currentFloor = n-1;
        }
        return n;
    }
    public static int numberOfCheckingK(int n,int k) {
        int Cheacks = 0;
        int min = 0;
        int[][] check = new int[k+1][n+1];
        for (int j = 0; j <= n; j++) {
            check[0][j] = 0;
            check[1][j] = j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <=n; j++) {
                min = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    min = Math.min(Math.max(check[i][j-p], (check[i-1][p-1]))+1, min);
                }
                check[i][j] = min;
            }
        }
        Cheacks =	check[k][n];
        return Cheacks;
    }
    public static int numberOfCheckingL(int n,int k) {
        int checks = 0;
        int min = 0;
        int[][] check = new int[k+1][n+1];
        int minimal_floor_number=Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            check[0][j] = 0;
            check[1][j] = j;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <=n; j++) {
                min = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    if((Math.max(check[i][j-p], (check[i-1][p-1]))+1)<min) {
                        min = Math.max(check[i][j - p], (check[i - 1][p - 1])) + 1;
                        System.out.println("Math.max(cheack["+ i + "]["+ (j-p) + "]="+check[i][j - p]+", (check["+ (i-1)+ "][" + (p-1)+ "])=" + (check[i - 1][p - 1]) + ") + 1");
                    }

                }
                check[i][j] = min;

            }
        }
        for(int i=2;i<=k;i++){
            for(int j=0;j<=n;j++){
                if(check[i][j]==check[k][n]){
                    minimal_floor_number=Math.min(j,minimal_floor_number);
                }
            }
        }
        System.out.println("The minimal floor : " + minimal_floor_number);
        checks =	check[k][n];
        return checks;
    }
    static int compares = 0;
    /**
     * complexity: O(sqrt (2) * sqrt (n))
     */
    public static int break_ball2(int[] floor, int ball) {
        if (ball >= floor[floor.length - 1]) return -1;  // doesn't break
        compares = 0;
        int index = 1;
        int d = 0;

        while (floor.length > d * (d + 1) / 2) {
            d++;
        }
        int i = d;

        while (i <= floor.length) {
            compares++;
            if (ball < floor[i - 1]) {
                index = i - d + 1;
                while (ball >= floor[index - 1]) {
                    compares++;
                    index++;
                }
                break;
            }
            d--;
            i += d;
            if (i > floor.length) i = floor.length;
        }
        return index;
    }





public static void main(String[]args){


        System.out.println(numberOfCheckingK(100,10));
        //System.out.println(numberOfCheckingL(100,2));

        System.out.println(glassBall2(new int[] {10,20,30,40,50,60,70},55));
    }
}