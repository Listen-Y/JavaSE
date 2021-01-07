package dom.deal;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 10:50
 */

//抽象策略角色
public interface Strategy {

    /**
     * 策略方法
     * @param shopPrice 商品原价
     * @return 打折后的价格
     */
    double strategyInterface(double shopPrice);
}
