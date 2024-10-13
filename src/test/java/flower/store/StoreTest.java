package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class StoreTest {
    private static final int FLOWER_SIZE_TEN = 10;
    private static final int FLOWER_SIZE_FIVE = 5;
    private static final int FLOWER_SIZE_EIGHT = 8;
    private static final int QUANTITY_FIVE = 5;
    private static final int QUANTITY_TEN = 10;

    @Test
    public void testSearchFlowerMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(
            FlowerColor.RED, FLOWER_SIZE_TEN, FlowerType.ROSE);

        Flower rose = new Flower(
            FlowerColor.RED, FLOWER_SIZE_TEN, 2, FlowerType.ROSE);
        Flower tulip = new Flower(
            FlowerColor.BLUE, FLOWER_SIZE_FIVE, QUANTITY_FIVE, FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, QUANTITY_FIVE);
        FlowerPack tulipPack = new FlowerPack(tulip, QUANTITY_TEN);

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        Assertions.assertEquals(
            1, result.size(), "Should find one matching flower pack");
        Assertions.assertEquals(
            rosePack, result.get(0), "Should match the rose pack");
    }

    @Test
    public void testSearchNoMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(
            FlowerColor.BLUE, FLOWER_SIZE_EIGHT, FlowerType.CHAMOMILE);

        Flower rose = new Flower(
            FlowerColor.RED, FLOWER_SIZE_TEN, 2, FlowerType.ROSE);
        Flower tulip = new Flower(
            FlowerColor.BLUE, FLOWER_SIZE_FIVE, QUANTITY_TEN, FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, QUANTITY_FIVE); 
        FlowerPack tulipPack = new FlowerPack(tulip, QUANTITY_TEN); 

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        Assertions.assertTrue(
            result.isEmpty(), "No matching flower pack should be found");
    }

    @Test
    public void testSearchEmptyStore() {
        FlowerSpec wantedSpec = new FlowerSpec(
            FlowerColor.RED, FLOWER_SIZE_TEN, FlowerType.ROSE);

        Store store = new Store();

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        Assertions.assertTrue(
            result.isEmpty(),
             "No matching flower pack should be found in an empty store");
    }
}
