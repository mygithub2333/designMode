package strategy.comparator;

import strategy.Cat;
import strategy.Dog;

/**
 * @author fwx
 * @date 2022/2/10
 */
public class CatHeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight()>o2.getHeight()) {
            return -1;
        }else if (o1.getWeight()<o2.getWeight()){
            return 1;
        }
        return 0;
    }
}
