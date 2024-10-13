package flower.store;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class FlowerBucket {
    private List<FlowerPack> flowerPacks;

    // Default constructor
    public FlowerBucket() {
        flowerPacks = new ArrayList<>();
    }

    // Copy constructor
    public FlowerBucket(FlowerBucket other) {
        this.flowerPacks = new ArrayList<>();
        for (FlowerPack flowerPack : other.flowerPacks) {
            // Assuming FlowerPack has a copy constructor or clone method
            this.flowerPacks.add(new FlowerPack(flowerPack));
        }
    }

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    // Factory method for copying
    public static FlowerBucket copy(FlowerBucket other) {
        return new FlowerBucket(other);
    }
}
