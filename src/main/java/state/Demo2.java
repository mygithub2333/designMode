package state;

/**
 * @author fwx
 * @date 2022/3/10
 * 用“状态模式”设计一个学生成绩的状态转换程序。
 * 分析：本实例包含了“不及格”“中等”和“优秀” 3 种状态，
 * 当学生的分数小于 60 分时为“不及格”状态，
 * 当分数大于等于 60 分且小于 90 分时为“中等”状态，
 * 当分数大于等于 90 分时为“优秀”状态，我们用状态模式来实现这个程序。
 */
public class Demo2 {
    public static void main(String[] args) {
        ScoreContext context = new ScoreContext();
        context.add(30);
        context.add(30);
        context.add(40);
        context.add(-20);
    }



}

//环境类
class ScoreContext{
    private AbstractState state;

    public ScoreContext() {
        state = new LowState(this);
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public void add(int score){
        state.addScore(score);
    }
}
//抽象状态类
abstract class AbstractState{
    protected ScoreContext hj;//环境
    protected String stateName;//状态名
    protected int score;//分数

    abstract void checkState();//检查当前状态

    public void addScore(int x){
        score +=x;
        System.out.println("加上："+x+"分，\t当前分数："+score);
        checkState();
        System.out.println("分，\t当前状态："+hj.getState().stateName);
    }
}
//具体状态类：不及格
class LowState extends AbstractState{

    public LowState(ScoreContext h) {
        hj = h;
        stateName = "不及格";
        score = 0;
    }

    public LowState(AbstractState state) {
        hj = state.hj;
        stateName = "不及格";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score >= 90) {
            hj.setState(new HighState(this));
        } else if (score >= 60) {
            hj.setState(new MiddleState(this));
        }
    }
}

class MiddleState extends AbstractState{

    public MiddleState(AbstractState state) {
        hj=state.hj;
        stateName = "中等";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score>=90){
            hj.setState(new HighState(this));
        }else if (score<60){
            hj.setState(new LowState(this));
        }
    }
}
class HighState extends AbstractState{

    public HighState(AbstractState state) {
        hj = state.hj;
        stateName = "优秀";
        score = state.score;
    }

    @Override
    void checkState() {
        if (score<60){
            hj.setState(new LowState(this));
        }else if (score<90){
            hj.setState(new MiddleState(this));
        }
    }
}