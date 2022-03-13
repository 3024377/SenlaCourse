package task5;

public class Vault {

    private final int volume;
    private final int[] bestMatch;

    public Vault(int inputVolume) {
        this.volume = inputVolume;
        this.bestMatch = new int[inputVolume + 1];
    }

    public int getVolume() {
        return volume;
    }

    public int[] getBestMatch() {
        return bestMatch;
    }

    public int getBestPrice() {
       return getBestMatch()[getVolume()];
    }
}
