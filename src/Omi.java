import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Omi {

    Random plswork = new Random();
    private List<Card> unassignedCards = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    
    public static void main(String[] args) {
        Omi game = new Omi();
//        SittingOrder sit = new SittingOrder();
//        Tactics trump=new Tactics();

        Card h7 = new Card(Suite.HEARTS, Value.SEVEN);
        Card h8 = new Card(Suite.HEARTS, Value.EIGHT);
        Card h9 = new Card(Suite.HEARTS, Value.NINE);
        Card h10 = new Card(Suite.HEARTS, Value.TEN);
        Card hj = new Card(Suite.HEARTS, Value.J);
        Card hq = new Card(Suite.HEARTS,Value.Q);
        Card hk = new Card(Suite.HEARTS,Value.K);
        Card ha = new Card(Suite.HEARTS,Value.A);

        Card s7 = new Card(Suite.SPADES, Value.SEVEN);
        Card s8 = new Card(Suite.SPADES, Value.EIGHT);
        Card s9 = new Card(Suite.SPADES, Value.NINE);
        Card s10 = new Card(Suite.SPADES, Value.TEN);
        Card sj = new Card(Suite.SPADES, Value.J);
        Card sq = new Card(Suite.SPADES,Value.Q);
        Card sk = new Card(Suite.SPADES,Value.K);
        Card sa = new Card(Suite.SPADES,Value.A);

        Card d7 = new Card(Suite.DIAMOND, Value.SEVEN);
        Card d8 = new Card(Suite.DIAMOND, Value.EIGHT);
        Card d9 = new Card(Suite.DIAMOND, Value.NINE);
        Card d10 = new Card(Suite.DIAMOND, Value.TEN);
        Card dj = new Card(Suite.DIAMOND, Value.J);
        Card dq = new Card(Suite.DIAMOND,Value.Q);
        Card dk = new Card(Suite.DIAMOND,Value.K);
        Card da = new Card(Suite.DIAMOND,Value.A);

        Card c7 = new Card(Suite.CLUBS, Value.SEVEN);
        Card c8 = new Card(Suite.CLUBS, Value.EIGHT);
        Card c9 = new Card(Suite.CLUBS, Value.NINE);
        Card c10 = new Card(Suite.CLUBS, Value.TEN);
        Card cj = new Card(Suite.CLUBS, Value.J);
        Card cq = new Card(Suite.CLUBS,Value.Q);
        Card ck = new Card(Suite.CLUBS,Value.K);
        Card ca = new Card(Suite.CLUBS,Value.A);
        game.addCard(h7, h8, h9, h10, hj, hq, hk, ha, s7, s8, s9, s10, sj, sq, sk, sa, d7, d8, d9, d10, dj, dq, dk, da,c7, c8, c9, c10, cj, cq, ck, ca);
        
        // At this point all the cards are unassigned.
        game.shuffleCards(game.getUnassignedCards());
        // At this point cards are unassigned but shuffled.
        System.out.println(game.unassignedCards);
        
        game.players.add(new Player("Me", Type.PLAYER));
        game.players.add(new Player("Robot1", Type.COMPUTER));
        game.players.add(new Player("Robot2", Type.COMPUTER));
        game.players.add(new Player("Robot3", Type.COMPUTER));

        game.shufflePlayers(game.getPlayers());
        System.out.println(game.players);

        Suite trump = game.separateCards();
        System.out.println(game.players);
        
//        for(int x=0; x<=game.getAllCards().size()-1; x++){
//            System.out.println("Card Suit : "+game.getAllCards().get(x).getSuite()+". Card Val: "+game.getAllCards().get(x).getValue()+" The strength is: "+game.getAllCards().get(x).getStrength());
//        }
//        for(int x=0; x<=game.getAllCards().size()-1; x++){
//            System.out.println();
//        }
//        game.choosing_for_robot();
        
//        System.out.println(sit.putting_in_order());

    }
    
    public Suite separateCards() {
        int cardSet = 4;
        
        Player firstPlayer = players.get(0);
        for (int k = 0; k < cardSet; k++) {
            Card card = popFirstCardFromUnassignedList();
            firstPlayer.addCard(card);
        }
        
        Suite trump;
        if (firstPlayer.getType() == Type.COMPUTER) {
           trump = tactics(firstPlayer);
        } else {
            //write ur picking code here.
            trump = Suite.HEARTS;
        }
        
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            for (int k = 0; k < cardSet; k++) {
                Card card = popFirstCardFromUnassignedList();
                player.addCard(card);
            }
        }
        return trump;
    }
    
    public Card popFirstCardFromUnassignedList() {
        return unassignedCards.remove(0);
    }

    
    //the seperated cards for the players to play
    private ArrayList<Card> caller = new ArrayList<>();
    private ArrayList<Card> user = new ArrayList<>();
    private ArrayList<Card> robot1 = new ArrayList<>();
    private ArrayList<Card> robot2 = new ArrayList<>();
    private ArrayList<Card> robot3 = new ArrayList<>();

    //Used in tactics for the computer to find trumps
    int all4 = 0;
    int all3one = 0;
    int all3two = 0;
    int all3three = 0;
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    int f = 0;

    public Omi() {
    }

    public void addCard(Card... card) {
        Collections.addAll(unassignedCards, card);
    }

    public List<Card> getUnassignedCards() {
        return unassignedCards;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void assignCardsToPlayers() {
        int size = players.size(); // 0-3
        for (Player player:players) {
            
        }

    }

    public void shuffleCards(List<Card> ar) {
        for (int j = ar.size() - 1; j > 0; j--) {
            int shuff = plswork.nextInt(j + 1);
            int shuff1 = plswork.nextInt(j + 1);
            Card s = ar.get(shuff);
            Card e = ar.get(shuff1);
            ar.set(shuff1, s);
            ar.set(shuff, e);
        }
    }

    public void shufflePlayers(List<Player> ar) {
        for (int j = ar.size() - 1; j > 0; j--) {
            int shuff = plswork.nextInt(j + 1);
            int shuff1 = plswork.nextInt(j + 1);
            Player s = ar.get(shuff);
            Player e = ar.get(shuff1);
            ar.set(shuff1, s);
            ar.set(shuff, e);
        }
    }

    //For Tactics
//    public ArrayList<Card> getCaller() {
//
//        return caller;
//    }

    //Distributing 32 cards amoung 4 players
//    public void choosing_for_robot() {
//        //        System.out.println(getAllCards().size());
//        for (int i = 0; i < 4; i++) {
//            caller.add(getUnassignedCards().get(i));
//        }
//        for (int j = 16; j < 20; j++) {
//            caller.add(getUnassignedCards().get(j));
//        }
//            for(int x=0;x<4;x++){
//            System.out.println(caller.get(x).getSuite()+" "+caller.get(x).getStrength());
//            }

    }

//    public void choosing_for_user() {
//        for (int i = 0; i < 4; i++) {
//            user.add(getUnassignedCards().get(i));
//        }
//        for (int j = 16; j < 20; j++) {
//            user.add(getUnassignedCards().get(j));
//        }
////            for(int x=0;x<4;x++){
////                System.out.println(user.get(x).getSuite()+" "+user.get(x).getStrength());
////            }
//
//    }

//    public void seperating_for_player_2(ArrayList<Card> player2) {
//        for (int i = 4; i < 8; i++) {
//            player2.add(getUnassignedCards().get(i));
//        }
//        for (int j = 20; j < 24; j++) {
//            player2.add(getUnassignedCards().get(j));
//        }
//    }
//
//    public void seperating_for_player_3(ArrayList<Card> player3) {
//        for (int i = 8; i < 12; i++) {
//            player3.add(getUnassignedCards().get(i));
//        }
//        for (int j = 24; j < 28; j++) {
//            player3.add(getUnassignedCards().get(j));
//        }
//    }
//
//    public void seperating_for_player_4(ArrayList<Card> player4) {
//        for (int i = 12; i < 16; i++) {
//            player4.add(getUnassignedCards().get(i));
//        }
//        for (int j = 28; j < 32; j++) {
//            player4.add(getUnassignedCards().get(j));
//        }
//    }
    

    //Rules for when the computer has to pick the trump
    public Suite tactics(Player player) {
        if (player.getType() == Type.PLAYER) {
            return null;
        }
        //Find the thing has most suite
        List<Card> cards = player.getCards();
        
        
        Map<Suite, Integer> count = new HashMap<>();
        count.put(Suite.DIAMOND,0);
        count.put(Suite.CLUBS,0);
        count.put(Suite.HEARTS,0);
        count.put(Suite.SPADES,0);
        
        for (Card card : cards) {
            Suite suite = card.getSuite();
            Integer integer = count.get(suite);
            integer = integer +1;
            count.put(suite,integer);
        }
        
        //Now we have to figure out the suite with most cards
        for (Suite suite : count.keySet()) {
            Integer integer = count.get(suite);
        }
        //If one sutie has 4 || 3 return it,
        
        // if 
        return Suite.DIAMOND;
    }
}
    

    //for robot 1
//    public ArrayList<Card> getrobot1() {
//
//        return robot1;
//    }
//
//    //for robot 2
//    public ArrayList<Card> getrobot2() {
//
//        return robot2;
//    }
//
//    //for user
//    public ArrayList<Card> getuser() {
//
//        return user;
//    }
//
//    //for robot 3
//    public ArrayList<Card> getrobot3() {
//        return robot3;
//    }



