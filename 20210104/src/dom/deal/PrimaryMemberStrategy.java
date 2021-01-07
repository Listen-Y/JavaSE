package dom.deal;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 10:56
 */
//初级会员策略
public class PrimaryMemberStrategy implements Strategy {

    /**
     * 初级会员返回原件
     * @param shopPrice 商品原价
     * @return
     */
    @Override
    public double strategyInterface(double shopPrice) {
        return shopPrice;
    }
}
