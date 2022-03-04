package builder;

/**
 * @author fwx
 * @date 2022/3/2
 * 建造者模式
 */
public class Demo1 {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }

}

class Product{
    String partyA;
    String partyB;
    String partyC;

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public void setPartyC(String partyC) {
        this.partyC = partyC;
    }

    public void show(){
        //显示产品特性
        System.out.println(partyA);
        System.out.println(partyB);
        System.out.println(partyC);

    }
}

abstract class Builder{

    protected Product product = new Product();

    public abstract void buildPartyA();
    public abstract void buildPartyB();
    public abstract void buildPartyC();

    public Product getResult(){
        return product;
    }
}


class ConcreteBuilder extends Builder{
    @Override
    public void buildPartyA() {
        product.setPartyA("建造PartyA");
    }

    @Override
    public void buildPartyB() {
        product.setPartyB("建造PartyB");
    }

    @Override
    public void buildPartyC() {
        product.setPartyC("建造PartyC");
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct(){
        builder.buildPartyA();
        builder.buildPartyB();
        builder.buildPartyC();
        return builder.getResult();
    }
}
