

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Card implements Comparable<Card> {
    //定义一个牌的数据结构
    public String rank;
    public String shit;

    public Card(String rank, String shit) {
        this.rank = rank;
        this.shit = shit;
    }

    @Override
    public boolean equals(Object obj) {
        //第一步判断obj是否为空
        if(obj == null) {
            return false;
        }
        //第二步判断obj与this是否引用同一个对象
        if(obj == this) {
            return true;
        }
        //第三步判断obj是否可以强转为this类型
        if(!(obj instanceof Card)) {
            return false;
        }
        //第四步将obj强转为this类型，自定义判断相等
        Card o = (Card) obj;
        //按照数字大小进行比较
        int thisRank = rankToInt(this.rank);
        int oRank = rankToInt(o.rank);
        return thisRank == oRank;
    }

    public int rankToInt(String rank) {
        //将面值转为int型
        if("A".equals(rank)) {
            return 1;
        }
        if("J".equals(rank)) {
            return 11;
        }
        if("Q".equals(rank)) {
            return 12;
        }
        if("K".equals(rank)) {
            return 13;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public int compareTo(Card o) {
        //将this与o的面值进行转换成int型，然后进行比较
        int thisRank = rankToInt(this.rank);
        int oRank = rankToInt(o.rank);
        //如果要升序就是thisRank - oRank,降序就是反之
        return thisRank - oRank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", shit='" + shit + '\'' +
                '}';
    }
}
public class CompareTest {
    public static void main(String[] args) {
        Card card = new Card("10", "♥");
        Card card1 = new Card("A","♠");
        Card card2 = new Card("K", "♣");
        Card card4 = new Card("A", "♣");
        //直接等号比较
        System.out.println(card == card4);
        //
        Card card3 = card;
        System.out.println(card == card3);
        //进行equals比较,
        System.out.println(card.equals(card1));
        System.out.println(card.equals(card3));

        System.out.println(card1.equals(card4));
        List<Card> list = new ArrayList<>();
        list.add(card);
        list.add(card1);
        list.add(card2);
        list.add(card4);
        //集合类的排序方法
        System.out.println(list);
        Collections.sort(list);
        //定义一个匿名内部类就行判断大小
        Collections.sort(list, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                int o1Rank = o1.rankToInt(o1.rank);
                int o2Rank = o2.rankToInt(o2.rank);
                return o1Rank - o2Rank;
            }
        });
        System.out.println(list);
    }
}
