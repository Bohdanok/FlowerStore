package flower.store;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
public class StoreTest {

    private int TEN = 10;
    private int FIVE = 5;
    private int TWO = 2;
    private int EIGHT = 8;
    @Test
    public void testSearchFlowerMatchFound() {
        
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.RED, TEN,
        FlowerType.ROSE);

        Flower rose = new Flower(FlowerColor.RED, TEN, TWO, 
        FlowerType.ROSE);
        Flower tulip = new Flower(FlowerColor.BLUE, FIVE, FIVE, 
        FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, FIVE);   // FIVE roses
        FlowerPack tulipPack = new FlowerPack(tulip, TEN); // TEN tulips

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        assertEquals(1, result.size(),
         "Should find one matching flower pack");
        assertEquals(rosePack, result.get(0),
         "Should match the rose pack");
    }

    @Test
    public void testSearchNoMatchFound() {
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.BLUE, EIGHT,
         FlowerType.CHAMOMILE);

        Flower rose = new Flower(FlowerColor.RED, TEN, TWO, FlowerType.ROSE);
        Flower tulip = new Flower(FlowerColor.BLUE, FIVE, TEN, FlowerType.TULIP);

        FlowerPack rosePack = new FlowerPack(rose, FIVE); 
        FlowerPack tulipPack = new FlowerPack(tulip, TEN); 

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.add(rosePack);
        flowerBucket.add(tulipPack);

        Store store = new Store();
        store.add(flowerBucket);

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        assertTrue(result.isEmpty(),
         "No matching flower pack should be found");
    }

    @Test
    public void testSearchEmptyStore() {
        FlowerSpec wantedSpec = new FlowerSpec(FlowerColor.RED,
         TEN, FlowerType.ROSE);

        Store store = new Store();

        ArrayList<FlowerPack> result = store.search(wantedSpec);

        assertTrue(result.isEmpty(), 
        "No matching flower pack should be found in an empty store");
    }
}
