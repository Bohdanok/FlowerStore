package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Setter @Getter @AllArgsConstructor
public class Flower {
    private double price;
    private FlowerSpec spec;

    public Flower(FlowerColor color, int sepalLength, int price,
    FlowerType type){
        this.price = price;
        this.spec = new FlowerSpec(color, sepalLength, type);
    }

    public Flower(){
        this.spec = new FlowerSpec();
        this.price = 0;
    }

    public Flower(Flower flower) {
        this.price = flower.price;
        this.spec = flower.spec;
    }

    public String getColor() {
        return spec.getColor().toString();
    }
    public void setColor(FlowerColor color){
        this.spec.setColor(color);
    }

    public boolean match(Flower other){
        return spec.match(other.spec);
    }

}
