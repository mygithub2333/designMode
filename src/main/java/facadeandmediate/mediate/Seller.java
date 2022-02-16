package facadeandmediate.mediate;

/**
 * @author fwx
 * @date 2022/2/16
 */
public class Seller extends HousePeople {

    public Seller(String name, int offerPrice, String houseName, HouseMediator mediator) {
        this.name = name;
        this.offerPrice = offerPrice;
        this.houseName = houseName;
        this.peopleType = 2;
        this.mediator = mediator;
    }

    @Override
    public void deal(HousePeople p) {
        mediator.deal(this, p);
    }
}
