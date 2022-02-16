package facadeandmediate.mediate;

/**
 * @author fwx
 * @date 2022/2/16
 */
public class SomeHouseMediator implements HouseMediator {
    @Override
    public void deal(HousePeople p1, HousePeople p2) {
        if(p1.getPeopleType()==p2.getPeopleType()){
            System.out.println("买家和卖家类型不匹配");
            return;
        }
        if(!p1.getHouseName().equals(p2.getHouseName())){
            System.out.println("房子不匹配");
            return;
        }
        if(p1.getOfferPrice()<p2.getOfferPrice()){
            System.out.println("买家出价小于卖家出价");
            return;
        }
        System.out.println(p1.getName()+"和"+p2.getName()+"对"+p1.getHouseName()+"在"+p2.getOfferPrice()+"价格成交");
    }
}
