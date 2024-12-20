package live.cloverescape;

/**
 * @author weibb
 * @date 2023-11-27
 */
class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public boolean isRobotBounded(String instructions) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dirIdx = 0;
        int n = instructions.length();
        for (int i = 0; i < n; i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                x += dir[0][0];
                y += dir[1][0];
            } else if (c == 'L') {
                dirIdx += 3;
                dirIdx %= 4;
            } else {
                dirIdx++;
                dirIdx %= 4;
            }
        }
        return dirIdx != 0 || (x == 0 && y == 0);
    }
}