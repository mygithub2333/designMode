package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fwx
 * @date 2022/3/10
 * 利用观察者模式设计一个程序，分析“人民币汇率”的升值或贬值对进口公司进口产品成本或出口公司的出口产品收入以及公司利润率的影响。
 * 分析：当“人民币汇率”升值时，进口公司的进口产品成本降低且利润率提升，出口公司的出口产品收入降低且利润率降低；
 * 当“人民币汇率”贬值时，进口公司的进口产品成本提升且利润率降低，出口公司的出口产品收入提升且利润率提升。
 */
public class Demo2 {

    public static void main(String[] args) {
        Rate r = new RMBRate();
        ImportCompany ic= new ImportCompany();
        r.add(ic);
        ExportCompany ec = new ExportCompany();
        r.add(ec);
        r.change(1);
    }

}
//抽象目标：汇率
abstract class Rate{
    protected List<Company> companies = new ArrayList<>();

    public void add(Company company){
        companies.add(company);
    }
    public void remove(Company company){
        companies.remove(company);
    }

    abstract void change(int number);
}
//具体目标：人民币汇率
class RMBRate extends Rate{
    @Override
    void change(int number) {
        for (Company company : companies) {
            company.response(number);
        }
    }
}
//抽象观察者：公司
interface Company{
    void response(int number);
}
//具体观察者1：进口公司
class ImportCompany implements Company{
    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了进口产品成本，提升了进口公司利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}
//具体观察者2：出口公司
class ExportCompany implements Company{
    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}