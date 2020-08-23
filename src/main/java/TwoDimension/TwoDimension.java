package TwoDimension;

public class TwoDimension {

    public static void main(String[] args) {
        char[][] shit = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        shit[2][2] = '6';
        for (int r = 0; r < shit.length; r++) {
            for (int c = 0; c < shit[r].length; c++) {
                System.out.print(shit[r][c] + " ");
            }
            System.out.println();
        }
    }
}
