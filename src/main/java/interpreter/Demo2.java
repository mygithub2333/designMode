package interpreter;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

/**
 * @author fwx
 * @date 2022/3/14
 *
 */
public class Demo2 {
    public static void main(String[] args) throws JepException {
        Jep jep = new Jep();
        //定义要计算的数据表达式
        String depositInterest = "principal*interestRate*time";
        //给相关变量赋值
        jep.addVariable("principal",100000);
        jep.addVariable("interestRate",0.038);
        jep.addVariable("time",2);
        jep.parse(depositInterest);
        Object evaluate = jep.evaluate();
        System.out.println("存款利息："+evaluate);
    }
}
