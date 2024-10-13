package flower.store;

public class Main {
    public static void main(String[] args) {
        int TEN = 10;
        int EIGHTTY = 80;
        int HUNDRED = 100;
        int EIGHT = 8;
        Flower rose = new Flower(FlowerColor.RED, EIGHTTY, HUNDRED, FlowerType.ROSE);
        FlowerPack flowerPack1 = new FlowerPack(rose, TEN);
        FlowerPack flowerPack2 = new FlowerPack(rose, EIGHT);
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack1);
        flowerBucket.add(flowerPack2);
        System.out.println(flowerBucket.getPrice());
        rose.setPrice(TEN);
        System.out.println(flowerBucket.getPrice());
    }
}