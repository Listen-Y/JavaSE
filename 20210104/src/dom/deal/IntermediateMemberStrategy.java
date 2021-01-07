package dom.deal;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 10:57
 */
//中级会员策略
public class IntermediateMemberStrategy implements Strategy {

    /**
     * 中级会员打九折
     * @param shopPrice 商品原价
     * @return
     */
    @Override
    public double strategyInterface(double shopPrice) {
        return shopPrice * 0.9;
    }
}
