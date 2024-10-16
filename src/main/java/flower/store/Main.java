package flower.store;

public class Main {
    private static final int TEN = 10;
    private static final int EIGHTY = 80;  // Fixed typo from EIGHTTY to EIGHTY
    private static final int HUNDRED = 100;
    private static final int EIGHT = 8;

    public static void main(String[] args) {
        Flower rose = new Flower(FlowerColor.RED, EIGHTY, HUNDRED, 
        FlowerType.ROSE);
        FlowerPack flowerPackone = new FlowerPack(rose, TEN);
        FlowerPack flowerPacktwo = new FlowerPack(rose, EIGHT);
        
        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPackone);
        flowerBucket.add(flowerPacktwo);

        System.out.println(flowerBucket.getPrice());
        
        rose.setPrice(TEN);  // This line is fine if `setPrice` accepts an int.
        System.out.println(flowerBucket.getPrice());
    }
}
