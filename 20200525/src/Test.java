import java.util.PriorityQueue;

class Card {
    public int rank;
    public int id;

    public Card(int rank, int id) {
        this.rank = rank;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", id=" + id +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Card card = new Card(1,2);
        Card card1 = new Card(2,1);
        PriorityQueue<Card> queue = new PriorityQueue<>(((o1, o2) -> o2.rank - o1.rank));
        queue.add(card);
        queue.add(card1);
        System.out.println(queue);
    }
}
