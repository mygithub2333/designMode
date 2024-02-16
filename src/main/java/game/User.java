package game;

import java.util.Random;

/**
 * 2、初级难度：属性计算
 * 需求：
 *
 * 1. 玩家会拥有多个属性。你只需要编写5个属性即可：hp, atk 攻击力，def 防御力，atkR 攻击力万分比加成，criti 暴击率，暴击伤害。
 * 2. 计算最终应用到战斗的属性。例如：atkR 攻击力万分比加成，最终是对基础攻击力进行计算后，换算成【额外加成的基础攻击力】。例如 100 攻击力，万分比 3000 = 30% 加成。那么会转换为 30点基础攻击力。
 * 3. 展示属性用。展示属性是给玩家看【原始属性】，也就是上述中100攻击力，30%攻击力加成
 * 4. 战斗属性用。使用【最终属性】，也就是 130点攻击力
 *	5.计算实际伤害
 */
public class User {

    private String name;

    private Double hp;

    private Long atk;

    /**
     * 设定每10点防御力可以减少1%的伤害，防御力最高为1000点，超过1000点制造的伤害为0
     */
    private Long def;

    private double atkR;

    private double criti;

    private double critiDamage;

    public User(String name, Double hp, Long atk, Long def, double atkR, double criti,double critiDamage) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.atkR = atkR;
        this.criti = criti;
        this.critiDamage = critiDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Long getAtk() {
        return atk;
    }

    public void setAtk(Long atk) {
        this.atk = atk;
    }

    public Long getDef() {
        return def;
    }

    public void setDef(Long def) {
        this.def = def;
    }

    public double getAtkR() {
        return atkR;
    }

    public void setAtkR(double atkR) {
        this.atkR = atkR;
    }

    public double getCriti() {
        return criti;
    }

    public void setCriti(double criti) {
        this.criti = criti;
    }

    public double getCritiDamage() {
        return critiDamage;
    }

    public void setCritiDamage(double critiDamage) {
        this.critiDamage = critiDamage;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", def=" + def +
                ", atkR=" + atkR +
                ", criti=" + criti +
                ", critiDamage=" + critiDamage +
                '}';
    }

    /**
     * 计算实际攻击力
     * @return
     */
    public Double computeAtk(){
        return getAtk()+getAtk()*getAtkR();
    }


    /**
     * 计算暴击增伤
     * @return
     */
    public Double computeCritiDamage(){
        return computeAtk()*getCritiDamage();
    }


    /**
     * 计算实际伤害
     * @param def      防御力
     * @return
     */
    public Double computeDamage(Long def){

        //1.计算防御力减少多少百分比伤害
        double defDamage = ((double) def /10)*0.01;
        System.out.println("防御力减少多少百分比伤害:"+defDamage);
        //2.当前攻击是否暴击
        double randomDouble = new Random().nextDouble();
        double damage;
        if (randomDouble<=getCriti()){
            //暴击，计算实际伤害
            damage = computeCritiDamage() + computeAtk() - (computeCritiDamage() + computeAtk()) * defDamage;
            System.out.println("产生暴击，伤害为:"+damage);
        }else {
            //没暴击返回攻击
            //3.计算暴击伤害
            damage = computeAtk() - computeAtk() * defDamage;
            System.out.println("未产生暴击，伤害为:"+damage);
        }
        if (damage<0){
            return 0.0;
        }
        return damage;
    }
}



class MutualAttack{

    public static void attack(User attacker,User defender){
        //计算造成的伤害
        Double damage = attacker.computeDamage(defender.getDef());
        //减去防御者相应的血量
        defender.setHp(defender.getHp()-damage<0?0:defender.getHp()-damage);
    }

}

class Test{
    public static void main(String[] args) {
        User xiaoZhang = new User("xiaoZhang", 1000.0, 309L, 200L, 0.3, 0.5, 1.5);
        User xiaoHong = new User("xiaoHong", 1000.0, 309L, 200L, 0.3, 0.5, 1.5);
        MutualAttack.attack(xiaoZhang,xiaoHong);
        System.out.println(xiaoHong.toString());
    }
}




