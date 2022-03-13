package task4;

import java.util.ArrayList;
import java.util.List;

public class MatrixSymbol {

    private final char[][] matrix;
    private final int symbol;
    private final int height;
    private final int width;

    private int currentLine = 0;

    public MatrixSymbol(int symbol, int height, int width) {
        this.matrix = new char[height][width];
        this.symbol = symbol;
        this.height = height;
        this.width = width;
    }

    public int getSymbol() {
        return symbol;
    }

    public void addLine(char[] points) {

        if (currentLine < height) {
            matrix[currentLine] = points;
            currentLine++;
        }

    }

    public List<String> toStringLine() {
        List<String> result = new ArrayList<>();

        for (char[] chars : matrix) {
            result.add(new String(chars));
        }

        return result;
    }

    public void replaceSymbol(char oldCh, char newCh) {

        for (int line = 0; line < height; line++) {

            for (int column = 0; column < width; column++) {

                if (matrix[line][column] == oldCh) {
                    matrix[line][column] = newCh;
                }

            }

        }

    }

}
