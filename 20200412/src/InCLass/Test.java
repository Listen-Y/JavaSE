/**
 * 扑克牌
 */
package InCLass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Card {
    public String suit;
    public String num;

    public Card(String suit, String num) {
        this.suit = suit;
        this.num = num;
    }

    @Override
    public String toString() {
        //C语言printf格式
        return String.format("[%s%s]", suit, num);
    }
}

public class Test {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        //制作一副扑克牌
        makeCards(cards);
        //展示新扑克
        displayNewCards(cards);
        //洗牌
        rushCards(cards);
        //发牌
        List<List<Card>> playersCards = givePlayerCards(cards);
        //展示玩家手牌
        disPLayPlayersCards(playersCards);
    }


    public static void makeCards(List<Card> cards) {
        String[] suits = {"♠", "♥", "♣", "♦"};
        for (int suitsIndex = 0; suitsIndex < 4; suitsIndex++) {
            cards.add(new Card(suits[suitsIndex], "A"));
            for (int i = 2; i <= 10; i++) {
                cards.add(new Card(suits[suitsIndex], String.valueOf(i)));
            }
            cards.add(new Card(suits[suitsIndex], "J"));
            cards.add(new Card(suits[suitsIndex], "Q"));
            cards.add(new Card(suits[suitsIndex], "K"));
        }
    }

    public static void rushCards(List<Card> cards) {
        Random random = new Random();
        for (int cardsIndex = cards.size() - 1; cardsIndex > 0  ; cardsIndex --) {
            int cardsInedxChange = random.nextInt(cardsIndex);
            Card temp = cards.get(cardsInedxChange);
            cards.set(cardsInedxChange, cards.get(cardsIndex));
            cards.set(cardsIndex, temp);
        }
    }

    public static List<List<Card>> givePlayerCards(List<Card> cards) {
        List<List<Card>> playersCards = new ArrayList<>();
        System.out.print("输入玩家人数: ");
        Scanner scanner = new Scanner(System.in);
        int playersNum = scanner.nextInt();
        while (playersNum > 0) {
            List<Card> player = new ArrayList<>();
            for (int everoneCards = 0; everoneCards < 3; everoneCards++) {
                player.add(cards.get(0));
                cards.remove(0);
            }
            playersCards.add(player);
            playersNum --;
        }
        return playersCards;
    }

    public static void disPLayPlayersCards(List<List<Card>> listList) {
        /*for (int player = 0; player < listList.size(); player++) {
            System.out.println( "玩家 " + (player+1) + " 手牌");
            System.out.println(listList.get(player));
        }*/
        while (true) {
            System.out.print("输入要查看的玩家手牌,输入666显示所有玩家手牌:");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if(input == 666) {
                for (int player = 0; player < listList.size(); player++) {
                    System.out.println( "玩家 " + (player+1) + " 手牌");
                    System.out.println(listList.get(player));
                }
                break;
            }
            if(input < 1 || input > listList.size()) {
                System.out.println("输入错误!");
                continue;
            }
            System.out.println( "玩家 " + (input) + " 手牌");
            System.out.println(listList.get(input - 1));
            System.out.println("====================");
        }
    }

    public static void displayNewCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i));
            if((i + 1) % 13 == 0) {
                System.out.println();
            }
        }
        System.out.println("====================");
    }

}
