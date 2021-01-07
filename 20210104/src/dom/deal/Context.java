package dom.deal;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 10:52
 */
//环境角色
public class Context {

    /**
     * 策略实现角色
     */
    private final Strategy strategy;

    /**
     * 通过构造方法传入一个具体策略
     * @param strategy 策略实现角色
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 获得打折后的价格
     * @param shopPrice 商品原件
     * @return 打折后的价格
     */
    public double getNewPrice(double shopPrice) {
        return this.strategy.strategyInterface(shopPrice);
    }
}
