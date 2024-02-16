package game;

import java.util.*;

/**
 * 3、新手难度：抽卡卡池
 * 需求:
 * 1. 游戏中有1-5星角色，参考原神。需要提供给我配置抽中不同品质的概率，并且提供一个兜底出哪个品质。抽出品质后，再在这个品质卡池中，进行抽取角色
 * 2. 保底逻辑。每80抽，必出一个五星角色
 * 代码逻辑：
 * 1、初始化角色池
 * 2、初始化计数器
 * 3、抽取角色
 * 4、计算基数逻辑
 *
 */




/**
 * 角色对象
 */
class Role extends DrawThings{
    public Role(String name, Integer tier) {
        super(name, tier);
    }

}

class Prop extends DrawThings{


    public Prop(String name, Integer tier) {
        super(name, tier);
    }

}


/**
 * 抽奖工厂：生产抽奖需要的对象
 */
interface DrawFactory{

    DrawThings create(String name,Integer tier);

}

abstract class DrawThings{
    /**
     * 名称
     */
    private String name;
    /**
     * 等级【1-一星，2-二星，3-三星，4-四星，5-五星】
     */
    private Integer tier;

    public DrawThings(String name, Integer tier) {
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

}

class RoleFactory implements DrawFactory{
    @Override
    public DrawThings create(String name, Integer tier) {
            System.out.println("a role is created,name:"+name);
            return new Role(name,tier);
    }


}

class PropFactory implements DrawFactory{


    @Override
    public DrawThings create(String name, Integer tier) {
        System.out.println("a prop is created,name:"+name);
        return new Prop(name,tier);
    }
}

public class Draw {
    //初始化计数器
    static int accumulateNum1 = 0;
    static int accumulateNum2 = 0;

    public static void main(String[] args) throws Exception {
        //初始化角色池
        List<DrawThings> roles= new ArrayList<>();
        RoleFactory roleFactory = new RoleFactory();
        DrawThings xiaoMing = roleFactory.create("xiaoMing", 1);
        DrawThings xiaoLi = roleFactory.create("xiaoLi", 1);
        DrawThings xiaoHua = roleFactory.create("xiaoHua", 1);
        DrawThings xiaoHong = roleFactory.create("xiaoHong", 1);
        DrawThings laoZhang = roleFactory.create("laoZhang", 2);
        DrawThings laoFu = roleFactory.create("laoFu", 2);
        DrawThings laoLuo = roleFactory.create("laoLuo", 2);
        DrawThings laoChen = roleFactory.create("laoChen", 2);
        DrawThings huaHua = roleFactory.create("huaHua", 3);
        DrawThings binBin = roleFactory.create("binBin", 3);
        DrawThings xinXin = roleFactory.create("xinXin", 3);
        DrawThings banNiTe = roleFactory.create("banNiTe", 4);
        DrawThings xingQiu = roleFactory.create("xingQiu", 4);
        DrawThings ganYu = roleFactory.create("ganYu", 5);
        roles.add(xiaoMing);
        roles.add(xiaoLi);
        roles.add(xiaoHua);
        roles.add(xiaoHong);
        roles.add(laoZhang);
        roles.add(laoFu);
        roles.add(laoLuo);
        roles.add(laoChen);
        roles.add(huaHua);
        roles.add(binBin);
        roles.add(xinXin);
        roles.add(banNiTe);
        roles.add(xingQiu);
        roles.add(ganYu);

        List<DrawThings> drawThingsList = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            DrawThings draw = draw(roles);
            drawThingsList.add(draw);
        }

        long oneCount = drawThingsList.stream().filter(drawThings -> 1 == drawThings.getTier()).count();
        long twoCount = drawThingsList.stream().filter(drawThings -> 2 == drawThings.getTier()).count();
        long threeCount = drawThingsList.stream().filter(drawThings -> 3 == drawThings.getTier()).count();
        long fourCount = drawThingsList.stream().filter(drawThings -> 4 == drawThings.getTier()).count();
        long fiveCount = drawThingsList.stream().filter(drawThings -> 5 == drawThings.getTier()).count();
        System.out.println("获取到1星角色数量："+oneCount);
        System.out.println("获取到2星角色数量："+twoCount);
        System.out.println("获取到3星角色数量："+threeCount);
        System.out.println("获取到4星角色数量："+fourCount);
        System.out.println("获取到5星角色数量："+fiveCount);
    }

    private static DrawThings draw(List<DrawThings> roles) throws Exception {
        LotteryMachine lotteryMachine = new LotteryMachine(roles);
        //抽奖
        DrawThings draw ;
        if (78== accumulateNum2 && 8== accumulateNum1){
            System.out.println("累计Num1为："+accumulateNum1+"Num2为："+accumulateNum2);
            draw = lotteryMachine.draw(3);
        } else if (79== accumulateNum2) {
            System.out.println("累计Num2为："+accumulateNum2);
            draw = lotteryMachine.draw(2);
        } else if (9== accumulateNum1) {
            System.out.println("累计Num1为："+accumulateNum1);
            draw = lotteryMachine.draw(1);
        }else {
            draw = lotteryMachine.draw(0);
        }
        //计数逻辑
        if (4==draw.getTier()){
            accumulateNum1 = 0;
            accumulateNum2 = accumulateNum2+1;
        }else if (5==draw.getTier()){
            accumulateNum2 =0;
            accumulateNum1 = accumulateNum1+1;
        }else {
            accumulateNum1 = accumulateNum1 +1;
            accumulateNum2 = accumulateNum2 +1;
        }
        System.out.println("当前抽奖抽到的角色为："+draw.getName()+";角色星级为："+draw.getTier());
        System.out.println("当前累计Num1："+accumulateNum1+";当前累计Num2："+accumulateNum2);
        return draw;
    }

}
/**
 * 抽奖器类
 */

class LotteryMachine {
    private List<DrawThings> roles;

    private List<Integer> weight;

    public LotteryMachine(List<DrawThings> roles) {
        this.roles = roles;
        initWeight();
    }

    private void initWeight(){
        weight = Arrays.asList(50, 30, 15, 4, 1);
    }


    public DrawThings draw(Integer type) throws Exception {

        //指定抽取角色
        if (1==type){

            return getRole(4);
        } else if (2==type) {
            return getRole(5);
        } else if (3==type) {
            int i = new Random().nextInt(2);
            if (0==i){
                return getRole(5);
            }else {
                return getRole(4);
            }
        }else {
            int totalWeight = 0;
            for (Integer value : weight) {
                totalWeight += value;
            }
            int randomNum = new Random().nextInt(totalWeight);//1-100

            for (int i = 0; i < weight.size(); i++) {
                if (randomNum < weight.get(i)) {
                    DrawThings drawThings;
                    //0-1,1-2,2-3,3-4,4-5
                    switch (i + 1) {
                        case 1:
                            System.out.println("从一星等级池中随机抽取一名角色");
                            drawThings = getRole(1);
                            break;
                        case 2:
                            System.out.println("从二星等级池中随机抽取一名角色");
                            drawThings = getRole(2);
                            break;
                        case 3:
                            System.out.println("从三星等级池中随机抽取一名角色");
                            drawThings = getRole(3);
                            break;
                        case 4:
                            System.out.println("从四星等级池中随机抽取一名角色");
                            drawThings = getRole(4);
                            break;
                        case 5:
                            System.out.println("从五星等级池中随机抽取一名角色");
                            drawThings = getRole(5);
                            break;
                        default:
                            throw new Exception("weight size error");
                    }
                    return drawThings;
                }
                randomNum -= weight.get(i);
            }
            return null;
        }
    }

    private DrawThings getRole(Integer key) {
            return roles.stream().filter(r -> Objects.equals(key, r.getTier())).skip(new Random().nextInt((int) roles.stream().filter(r -> Objects.equals(key, r.getTier())).count())).findFirst().orElse(null);
    }


}

