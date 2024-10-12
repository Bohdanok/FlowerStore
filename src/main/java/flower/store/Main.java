package flower.store;

public class Main {
    public static void main(String[] args) {
        Flower rose = new Flower(FlowerColor.RED, 80, 100, FlowerType.ROSE);
        FlowerPack flowerPack1 = new FlowerPack(rose, 10);
        FlowerPack flowerPack2 = new FlowerPack(rose, 8);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack1);
        flowerBucket.add(flowerPack2);
        System.out.println(flowerBucket.getPrice());
        rose.setPrice(10);
        System.out.println(flowerBucket.getPrice());
    }
}