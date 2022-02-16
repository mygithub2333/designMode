package facadeandmediate.mediate;

/**
 * @author fwx
 * @date 2022/2/16
 * 调停者模式（中介者）
 */
public class Main {
    public static void main(String[] args) {
        HouseMediator mediator=new SomeHouseMediator();
        HousePeople buyerMark=new Buyer("Mark",10000,"世纪东方",mediator);
        HousePeople sellerSunny=new Seller("Sunny",20000,"世纪东方",mediator);
        HousePeople sellerOke=new Seller("Oke",9000,"世纪东方",mediator);
        buyerMark.deal(sellerSunny);
        buyerMark.deal(sellerOke);
        sellerSunny.deal(sellerOke);
    }
}
