package dom.deal;

import dom.solution.Solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 10:58
 */
public class Client {

    public static void main(String[] args) {
        //创建需要的策略实现角色
        AdvancedMemberStrategy advancedMemberStrategy = new AdvancedMemberStrategy();
        //创建打折环境角色
        Context context = new Context(advancedMemberStrategy);
        //获得打折后的价格
        System.out.println(context.getNewPrice(99.99));
    }
}
