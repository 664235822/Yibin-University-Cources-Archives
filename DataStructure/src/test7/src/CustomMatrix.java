import java.util.Scanner;

public class CustomMatrix {

    int[][] a = null;

    int[][] b = null;

    public CustomMatrix() {
        a = new int[3][3];
        b = new int[3][3];
    }

    public void setA() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = input.nextInt();
            }
        }
    }

    public void setB() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = input.nextInt();
            }
        }
    }

    public void changePositionA() {
        int[][] result = a;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (j < i) {
                    continue;
                }
                int temp = result[i][j];
                result[i][j] = result[j][i];
                result[j][i] = temp;
            }
        }

        show(result);
    }

    public void add() {
        int[][] result = new int[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        show(result);
    }

    public void multiple() {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }

        show(result);
    }

    void show(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
