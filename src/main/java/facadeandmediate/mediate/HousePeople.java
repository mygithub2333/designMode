package facadeandmediate.mediate;

/**
 * @author fwx
 * @date 2022/2/16
 */
public abstract class HousePeople {

    protected String name;
    protected int offerPrice;
    protected String houseName;
    protected int peopleType;
    protected HouseMediator mediator;

    public String getName() {
        return name;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public String getHouseName() {
        return houseName;
    }

    public int getPeopleType() {
        return peopleType;
    }

    public abstract void deal(HousePeople p);
}
