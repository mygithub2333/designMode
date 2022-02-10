package strategy;

import strategy.comparable.Comparable;

/**
 * @author fwx
 * @date 2022/2/10
 */
public class Dog implements Comparable<Dog> {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Dog(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog d) {
        if (this.weight < d.weight) {
            return -1;
        } else if (this.weight > d.weight) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }
}
