package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class FlowerSpec {
    private FlowerColor color;
    private double sepalLength;
    private FlowerType flowerType;

    public boolean match(FlowerSpec other){
        return (this.color.equals(other.color) && 
        (this.sepalLength == other.sepalLength) &&
        (this.flowerType == other.flowerType));
    }

    public boolean match(Flower flower){
        return this.match(flower.getSpec());
    }

    public FlowerSpec(){
        this.color = null;
        this.sepalLength = 0;
        this.flowerType = null;        
    }

}
