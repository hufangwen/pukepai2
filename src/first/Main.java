package first;

import java.util.*;

public class Main {
    enum CardType {
        heart("红桃"),
        spade("黑桃"),
        clubs("梅花"),
        diamond("方块");

        String typeName;

        CardType(String typeName) {
            this.typeName = typeName;
        }
    }

    static class Card {
        CardType type;
        String value;
        int order;

        public Card(CardType type, String value, int order) {
            this.type = type;
            this.value = value;
            this.order = order;
        }

        @Override
        public String toString() {
            return type.typeName+value;
        }
    }

    static class Player {
        List<Card> cardList = new ArrayList<>();
    }

    public static void main(String[] args) {

        String[] values = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "P", "Q"};

        List<Card> cardList = new ArrayList<>();

        Random random=new Random();
        for (CardType type : CardType.values())
            for (String value : values)
                cardList.add(new Card(type, value,random.nextInt()));

        cardList.sort(Comparator.comparingInt(o -> o.order));

        List<Player> playerList=new ArrayList<>();
        for (int i = 0; i < 4; i++)
            playerList.add(new Player());


        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).cardList.addAll(cardList.subList(i*(52/4),(i+1)*(52/4)));
        }


        for (int i = 0; i < playerList.size(); i++) {
            System.out.print("玩家"+(i+1)+":  ");

            for (Card card : playerList.get(i).cardList) {
                System.out.print(card+" ");
            }

            System.out.println();
        }


    }
}
