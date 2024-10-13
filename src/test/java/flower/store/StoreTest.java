package flower.store;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    @Test
    public void testSearchFlowerMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.RED, 10, FlowerType.ROSE);

        Flower rose = new Flower(FlowerColor.RED, 10, 2, FlowerType.ROSE);
        Flower tulip = new Flower(FlowerColor.BLUE, 5, 5, FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, 5);   // 5 roses
        FlowerPack tulipPack = new FlowerPack(tulip, 10); // 10 tulips

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

\        assertEquals(1, result.size(), "Should find one matching flower pack");
        assertEquals(rosePack, result.get(0), "Should match the rose pack");
    }

    @Test
    public void testSearchNoMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.BLUE, 8, FlowerType.CHAMOMILE);

        Flower rose = new Flower(FlowerColor.RED, 10, 2, FlowerType.ROSE);
        Flower tulip = new Flower(FlowerColor.BLUE, 5, 10, FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, 5); 
        FlowerPack tulipPack = new FlowerPack(tulip, 10); 

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        assertTrue(result.isEmpty(), "No matching flower pack should be found");
    }

    @Test
    public void testSearchEmptyStore() {
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.RED, 10, FlowerType.ROSE);

        Store store = new Store();

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        assertTrue(result.isEmpty(), "No matching flower pack should be found in an empty store");
    }
}
