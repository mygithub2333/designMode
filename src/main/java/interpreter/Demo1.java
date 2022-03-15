package interpreter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fwx
 * @date 2022/3/14
 * 解释器（Interpreter）模式
 * 用解释器模式设计一个“韶粵通”公交车卡的读卡器程序。
 * 文法规则
 *   <expression> ::= <city>的<person>
 *   <city> ::= 韶关|广州
 *   <person> ::= 老人|妇女|儿童
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}
//抽象表达式类
interface Expression{
    boolean interpret(String info);
}

//终结符表达式类
class TerminalExpression implements Expression{
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        set.addAll(Arrays.asList(data));
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}

//非终结符表达式类
class AndExpression implements Expression{

    private Expression city = null;
    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}

//环境类
class Context {
    private Expression cityPerson;
    public Context() {
        String[] citys = {"韶关", "广州"};
        Expression city = new TerminalExpression(citys);
        String[] persons = {"老人", "妇女", "儿童"};
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }
    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
    }
    }
}
