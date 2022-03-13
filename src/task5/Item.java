package task5;

public class Item {

    private final int volume;
    private final int price;

    public Item(int volume, int price) {
        this.volume = volume;
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }
}
