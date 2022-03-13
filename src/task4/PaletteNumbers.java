package task4;

import java.util.ArrayList;
import java.util.List;

public class PaletteNumbers {

    private static final char S = '*';
    private static final char O = ' ';
    public static final int HEIGHT = 7;

    public final List<MatrixSymbol> matrixSymbols;

    public PaletteNumbers() {
        matrixSymbols = new ArrayList<>();
        fillMatrixSymbols();
    }

    public MatrixSymbol getMatrixBySymbol(int symbol) {
        return matrixSymbols.stream()
                .filter(matrixSymbol -> matrixSymbol.getSymbol() == symbol)
                .findFirst().get();
    }

    public void replaceStarToSymbol(int symbol) {
        MatrixSymbol matrixSymbol = getMatrixBySymbol(symbol);
        matrixSymbol.replaceSymbol(S, Character.forDigit(symbol, 10));
    }

    private void fillMatrixSymbols() {
        MatrixSymbol m0 = new MatrixSymbol(0, HEIGHT, 7);
        m0.addLine(new char[]{O, O, S, S, S, O, O});
        m0.addLine(new char[]{O, S, O, O, O, S, O});
        m0.addLine(new char[]{S, O, O, O, O, O, S});
        m0.addLine(new char[]{S, O, O, O, O, O, S});
        m0.addLine(new char[]{S, O, O, O, O, O, S});
        m0.addLine(new char[]{O, S, O, O, O, S, O});
        m0.addLine(new char[]{O, O, S, S, S, O, O});
        matrixSymbols.add(m0);

        MatrixSymbol m1 = new MatrixSymbol(1, HEIGHT, 3);
        m1.addLine(new char[]{O, S, O});
        m1.addLine(new char[]{S, S, O});
        m1.addLine(new char[]{O, S, O});
        m1.addLine(new char[]{O, S, O});
        m1.addLine(new char[]{O, S, O});
        m1.addLine(new char[]{O, S, O});
        m1.addLine(new char[]{S, S, S});
        matrixSymbols.add(m1);

        MatrixSymbol m2 = new MatrixSymbol(2, HEIGHT, 6);
        m2.addLine(new char[]{O, S, S, S, S, O});
        m2.addLine(new char[]{S, O, O, O, O, S});
        m2.addLine(new char[]{S, O, O, O, S, O});
        m2.addLine(new char[]{O, O, O, S, O, O});
        m2.addLine(new char[]{O, O, S, O, O, O});
        m2.addLine(new char[]{O, S, O, O, O, O});
        m2.addLine(new char[]{S, S, S, S, S, S});
        matrixSymbols.add(m2);

        MatrixSymbol m3 = new MatrixSymbol(3, HEIGHT, 5);
        m3.addLine(new char[]{O, S, S, S, O});
        m3.addLine(new char[]{S, O, O, O, S});
        m3.addLine(new char[]{O, O, O, O, S});
        m3.addLine(new char[]{O, O, S, S, O});
        m3.addLine(new char[]{O, O, O, O, S});
        m3.addLine(new char[]{S, O, O, O, S});
        m3.addLine(new char[]{O, S, S, S, O});
        matrixSymbols.add(m3);

        MatrixSymbol m4 = new MatrixSymbol(4, HEIGHT, 6);
        m4.addLine(new char[]{O, O, O, S, O, O});
        m4.addLine(new char[]{O, O, S, S, O, O});
        m4.addLine(new char[]{O, S, O, S, O, O});
        m4.addLine(new char[]{S, O, O, S, O, O});
        m4.addLine(new char[]{S, S, S, S, S, S});
        m4.addLine(new char[]{O, O, O, S, O, O});
        m4.addLine(new char[]{O, O, O, S, O, O});
        matrixSymbols.add(m4);

        MatrixSymbol m5 = new MatrixSymbol(5, HEIGHT, 5);
        m5.addLine(new char[]{S, S, S, S, O});
        m5.addLine(new char[]{S, O, O, O, O});
        m5.addLine(new char[]{S, O, O, O, O});
        m5.addLine(new char[]{S, S, S, S, O});
        m5.addLine(new char[]{O, O, O, O, S});
        m5.addLine(new char[]{S, O, O, O, S});
        m5.addLine(new char[]{O, S, S, S, O});
        matrixSymbols.add(m5);

        MatrixSymbol m6 = new MatrixSymbol(6, HEIGHT, 5);
        m6.addLine(new char[]{O, S, S, S, S});
        m6.addLine(new char[]{S, O, O, O, O});
        m6.addLine(new char[]{S, O, O, O, O});
        m6.addLine(new char[]{S, S, S, S, O});
        m6.addLine(new char[]{S, O, O, O, S});
        m6.addLine(new char[]{S, O, O, O, S});
        m6.addLine(new char[]{O, S, S, S, O});
        matrixSymbols.add(m6);

        MatrixSymbol m7 = new MatrixSymbol(7, HEIGHT, 5);
        m7.addLine(new char[]{S, S, S, S, S});
        m7.addLine(new char[]{O, O, O, O, S});
        m7.addLine(new char[]{O, O, O, S, O});
        m7.addLine(new char[]{O, O, S, O, O});
        m7.addLine(new char[]{O, S, O, O, O});
        m7.addLine(new char[]{S, O, O, O, O});
        m7.addLine(new char[]{S, O, O, O, O});
        matrixSymbols.add(m7);

        MatrixSymbol m8 = new MatrixSymbol(8, HEIGHT, 5);
        m8.addLine(new char[]{O, S, S, S, O});
        m8.addLine(new char[]{S, O, O, O, S});
        m8.addLine(new char[]{S, O, O, O, S});
        m8.addLine(new char[]{O, S, S, S, O});
        m8.addLine(new char[]{S, O, O, O, S});
        m8.addLine(new char[]{S, O, O, O, S});
        m8.addLine(new char[]{O, S, S, S, O});
        matrixSymbols.add(m8);

        MatrixSymbol m9 = new MatrixSymbol(9, HEIGHT, 5);
        m9.addLine(new char[]{O, S, S, S, O});
        m9.addLine(new char[]{S, O, O, O, S});
        m9.addLine(new char[]{S, O, O, O, S});
        m9.addLine(new char[]{O, S, S, S, S});
        m9.addLine(new char[]{O, O, O, O, S});
        m9.addLine(new char[]{O, O, O, O, S});
        m9.addLine(new char[]{O, S, S, S, O});
        matrixSymbols.add(m9);
    }

}
