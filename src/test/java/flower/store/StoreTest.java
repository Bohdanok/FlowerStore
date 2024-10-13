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

    private Store setupStore(Flower flower1, int quantity1, Flower flower2, int quantity2) {
        FlowerPack pack1 = new FlowerPack(flower1, quantity1);
        FlowerPack pack2 = new FlowerPack(flower2, quantity2);

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(pack1);
        flowerBucket.add(pack2);

        Store store = new Store();
        store.add(flowerBucket);

        return store;
    }

    @Test
    public void testSearchFlowerMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(
            FlowerColor.RED, FLOWER_SIZE_TEN, FlowerType.ROSE);

        Flower rose = new Flower(
            FlowerColor.RED, FLOWER_SIZE_TEN, 2, FlowerType.ROSE);
        Flower tulip = new Flower(
            FlowerColor.BLUE, FLOWER_SIZE_FIVE, QUANTITY_FIVE, FlowerType.TULIP);

        Store store = setupStore(rose, QUANTITY_FIVE, tulip, QUANTITY_TEN);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        Assertions.assertEquals(
            1, result.size(), "Should find one matching flower pack");
        Assertions.assertTrue(
            new FlowerPack(rose, QUANTITY_FIVE).match(result.get(0)), "Should match the rose pack");
    }

    @Test
    public void testSearchNoMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(
            FlowerColor.BLUE, FLOWER_SIZE_EIGHT, FlowerType.CHAMOMILE);

        Flower rose = new Flower(
            FlowerColor.RED, FLOWER_SIZE_TEN, 2, FlowerType.ROSE);
        Flower tulip = new Flower(
            FlowerColor.BLUE, FLOWER_SIZE_FIVE, QUANTITY_TEN, FlowerType.TULIP);

        Store store = setupStore(rose, QUANTITY_FIVE, tulip, QUANTITY_TEN);

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
