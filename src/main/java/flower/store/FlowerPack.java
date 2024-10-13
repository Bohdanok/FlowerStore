package flower.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int quantity;


    public FlowerPack(Flower flower, int count) {
        this.flower = new Flower(flower);
        this.quantity = count;
    }

    public FlowerPack(FlowerPack flowerPack) {
        this.flower = flowerPack.getFlower();
        this.quantity = flowerPack.getQuantity();
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }

    public boolean match(FlowerPack other) {
        return flower.match(other.flower);
    }

}
