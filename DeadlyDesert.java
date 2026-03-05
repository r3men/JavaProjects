import java.util.*;

public class Desert {
    public static void main(String[] args) {
        int[][] desert = {{5, 1, 3, 1, 2, 4, 2, 1}, {2, 4, 0, 3, 1, 4, 3, 2}, {6, 1, 5, 2, 1, 5, 4, 1}, {2, 3, 4, 1, 2, 2, 1, 0}, {4, 1, 4, 2, 6, 4, 2, 3}, {1, 3, 3, 3, 4, 1, 5, 2}};
        char[][] desertCopy = new char[6][8];
        for (int i = 1; i < desert.length - 1; i++) {
            for (int j = 1; j < desert[i].length - 1; j++) {
                if (desert[i][j] + desert[i - 1][j] + desert[i + 1][j] + desert[i][j - 1] + desert[i][j + 1] > 15) {
                    desertCopy[i][j] = 'D';
                }
            }
        }
        for (int i = 0; i < desertCopy.length; i++) {
            for (int j = 0; j < desertCopy[i].length; j++) {
                if (desertCopy[i][j] != 'D') {
                    desertCopy[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < desert.length; i++) {
            for (int j = 0; j < desert[i].length; j++) {
                System.out.print(desert[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < desertCopy.length; i++) {
            for (int j = 0; j < desertCopy[i].length; j++) {
                System.out.print(desertCopy[i][j] + " ");
            }
            System.out.println();
        }
    }
}
