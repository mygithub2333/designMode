package strategy.comparator;

import strategy.Dog;

/**
 * @author fwx
 * @date 2022/2/10
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getWeight()<o2.getWeight()) {
            return -1;
        }else if (o1.getWeight()>o2.getWeight()){
            return 1;
        }
        return 0;
    }
}
