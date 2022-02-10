package strategy;

import strategy.comparable.Sorter;
import strategy.comparator.CatHeightComparator;
import strategy.comparator.CatWeightComparator;
import strategy.comparator.DogComparator;

import java.util.Arrays;

/**
 * @author fwx
 * @date 2022/2/10
 */
public class Main {
    public static void main(String[] args) {
        comparatorTest();

    }

    private static void comparatorTest() {
        Dog[] d = {new Dog(3), new Dog(5), new Dog(1)};
        strategy.comparator.Sorter<Dog> sorter = new strategy.comparator.Sorter<>();
        sorter.sort(d,new DogComparator());
        System.out.println(Arrays.toString(d));
        Cat[] c = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        strategy.comparator.Sorter<Cat> sorterCat1 = new strategy.comparator.Sorter<>();
        sorterCat1.sort(c,new CatHeightComparator());
        System.out.println(Arrays.toString(c));
        strategy.comparator.Sorter<Cat> sorterCat2 = new strategy.comparator.Sorter<>();
        sorterCat2.sort(c,new CatWeightComparator());
        System.out.println(Arrays.toString(c));
    }

    private static void comparableTest() {
        Dog[] d = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter.sort(d);
        System.out.println(Arrays.toString(d));
        Cat[] c = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        Sorter.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
