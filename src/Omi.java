import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
//        Cards hj = new Cards("h", "j", 5);
//        Cards hq = new Cards("h", "q", 6);
//        Cards hk = new Cards("h", "k", 7);
//        Cards ha = new Cards("h", "a", 8);
//
//        Cards s7 = new Cards("s", "7", 1);
//        Cards s8 = new Cards("s", "8", 2);
//        Cards s9 = new Cards("s", "9", 3);
//        Cards s10 = new Cards("s", "10", 4);
//        Cards sj = new Cards("s", "j", 5);
//        Cards sq = new Cards("s", "q", 6);
//        Cards sk = new Cards("s", "k", 7);
//        Cards sa = new Cards("s", "a", 8);
//
//        Cards d7 = new Cards("d", "7", 1);
//        Cards d8 = new Cards("d", "8", 2);
//        Cards d9 = new Cards("d", "9", 3);
//        Cards d10 = new Cards("d", "10", 4);
//        Cards dj = new Cards("d", "j", 5);
//        Cards dq = new Cards("d", "q", 6);
//        Cards dk = new Cards("d", "k", 7);
//        Cards da = new Cards("d", "a", 8);
//
//        Cards c7 = new Cards("c", "7", 1);
//        Cards c8 = new Cards("c", "8", 2);
//        Cards c9 = new Cards("c", "9", 3);
//        Cards c10 = new Cards("c", "10", 4);
//        Cards cj = new Cards("c", "j", 5);
//        Cards cq = new Cards("c", "q", 6);
//        Cards ck = new Cards("c", "k", 7);
//        Cards ca = new Cards("c", "a", 8);

        game.addCard(h7, h8, h9, h10
//                , hj, hq, hk, ha, s7, s8, s9, s10, sj, sq, sk, sa, d7, d8, d9, d10, dj, dq, dk, da,c7, c8, c9, c10, cj, cq, ck, ca
                    );
        
        // At this point all the cards are unassigned.
        game.shuffle(game.getUnassignedCards());
        // At this point cards are unassigned but shuffled.
        
        game.players.add(new Player("Me", Type.PLAYER));
        game.players.add(new Player("Robot1", Type.COMPUTER));
        game.players.add(new Player("Robot2", Type.COMPUTER));
        game.players.add(new Player("Robot3", Type.COMPUTER));
        
        shufflePlayers();
        
        assignCardsToPlayers();
        
//        for(int x=0; x<=game.getAllCards().size()-1; x++){
//            System.out.println("Card Suit : "+game.getAllCards().get(x).getSuite()+". Card Val: "+game.getAllCards().get(x).getValue()+" The strength is: "+game.getAllCards().get(x).getStrength());
//        }
//        for(int x=0; x<=game.getAllCards().size()-1; x++){
//            System.out.println();
//        }
        game.choosing_for_robot();
        game.tactics();
        System.out.println(sit.putting_in_order());

    }
    
    public void seperateCards() {
        int cardSet = 4;
        int i = 0 ;
        for (Card card : unassignedCards) {
            for (Player player: players) {
                if (i!=4) {
                    player.addCard(card);
                    i++;
                }else {
                    break;
                }
            }
        }
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
    
    public void assignCardsToPlayers() {
        int size = players.size(); // 0-3
        for (Player player:players) {
            
        }

    }

    public void shuffle(List<Card> ar) {
        for (int j = ar.size() - 1; j > 0; j--) {
            int shuff = plswork.nextInt(j + 1);
            int shuff1 = plswork.nextInt(j + 1);
            Card s = ar.get(shuff);
            Card e = ar.get(shuff1);
            ar.set(shuff1, s);
            ar.set(shuff, e);
        }
    }

    //For Tactics
    public ArrayList<Card> getCaller() {

        return caller;
    }

    //Distributing 32 cards amoung 4 players
    public void choosing_for_robot() {
        //        System.out.println(getAllCards().size());
        for (int i = 0; i < 4; i++) {
            caller.add(getUnassignedCards().get(i));
        }
        for (int j = 16; j < 20; j++) {
            caller.add(getUnassignedCards().get(j));
        }
//            for(int x=0;x<4;x++){
//            System.out.println(caller.get(x).getSuite()+" "+caller.get(x).getStrength());
//            }

    }

    public void choosing_for_user() {
        for (int i = 0; i < 4; i++) {
            user.add(getUnassignedCards().get(i));
        }
        for (int j = 16; j < 20; j++) {
            user.add(getUnassignedCards().get(j));
        }
//            for(int x=0;x<4;x++){
//                System.out.println(user.get(x).getSuite()+" "+user.get(x).getStrength());
//            }

    }

    public void seperating_for_player_2(ArrayList<Card> player2) {
        for (int i = 4; i < 8; i++) {
            player2.add(getUnassignedCards().get(i));
        }
        for (int j = 20; j < 24; j++) {
            player2.add(getUnassignedCards().get(j));
        }
    }

    public void seperating_for_player_3(ArrayList<Card> player3) {
        for (int i = 8; i < 12; i++) {
            player3.add(getUnassignedCards().get(i));
        }
        for (int j = 24; j < 28; j++) {
            player3.add(getUnassignedCards().get(j));
        }
    }

    public void seperating_for_player_4(ArrayList<Card> player4) {
        for (int i = 12; i < 16; i++) {
            player4.add(getUnassignedCards().get(i));
        }
        for (int j = 28; j < 32; j++) {
            player4.add(getUnassignedCards().get(j));
        }
    }

    //Rules for when the computer has to pick the trump
    public String tactics() {
        int toselect = plswork.nextInt(4);
        if (getCaller().get(0).getSuite() == getCaller().get(1).getSuite()) {
            all4 += 1;
            all3one += 1;
            a += 1;

        }

        if (getCaller().get(0).getSuite() == getCaller().get(2).getSuite()) {
            all4 += 1;
            all3one += 1;
            all3two += 1;
            b += 1;

        }

        if (getCaller().get(0).getSuite() == getCaller().get(3).getSuite()) {
            all4 += 1;
            all3two += 1;
            c += 1;

        }

        if (getCaller().get(1).getSuite() == getCaller().get(2).getSuite()) {
            all4 += 1;
            all3one += 1;
            all3three += 1;
            d += 1;

        }

        if (getCaller().get(1).getSuite() == getCaller().get(3).getSuite()) {
            all4 += 1;
            all3three += 1;
            e += 1;

        }

        if (getCaller().get(2).getSuite() == getCaller().get(3).getSuite()) {
            all4 += 1;
            all3two += 1;
            all3three += 1;
            f += 1;

        }
        //if all 4 suits are equal
        if (all4 == 6) {
            return getCaller().get(0).getSuite();
        }
        //if 3 suits are equal
        else if (all3one == 3) {
            return getCaller().get(0).getSuite();
        } else if (all3two == 3) {
            return getCaller().get(0).getSuite();
        } else if (all3three == 3) {
            return getCaller().get(1).getSuite();
        }
        //if 2 suits are equal with the A thing
        else if (a == 1 && f == 1) {
            if (getCaller().get(0).getStrength() == 8 || getCaller().get(1).getStrength() == 8) {
                return getCaller().get(2).getSuite();
            } else if (getCaller().get(2).getStrength() == 8 || getCaller().get(3).getStrength() == 8) {
                return getCaller().get(0).getSuite();
            } else {
                return getCaller().get(toselect).getSuite();

            }
        } else if (b == 1 && e == 1) {
            if (getCaller().get(0).getStrength() == 8 || getCaller().get(2).getStrength() == 8) {
                return getCaller().get(1).getSuite();
            } else if (getCaller().get(1).getStrength() == 8 || getCaller().get(3).getStrength() == 8) {
                return getCaller().get(0).getSuite();
            } else {
                return getCaller().get(toselect).getSuite();

            }
        } else if (c == 1 && d == 1) {
            if (getCaller().get(0).getStrength() == 8 || getCaller().get(3).getStrength() == 8) {
                return getCaller().get(2).getSuite();
            } else if (getCaller().get(1).getStrength() == 8 || getCaller().get(2).getStrength() == 8) {
                return getCaller().get(0).getSuite();
            } else {
                return getCaller().get(toselect).getSuite();

            }
            //if only 2 suits are equal
        } else if (a == 1) {
            return getCaller().get(0).getSuite();
        } else if (b == 1) {
            return getCaller().get(0).getSuite();
        } else if (c == 1) {
            return getCaller().get(0).getSuite();
        } else if (d == 1) {
            return getCaller().get(1).getSuite();
        } else if (e == 1) {
            return getCaller().get(1).getSuite();
        } else if (f == 1) {
            return getCaller().get(2).getSuite();
        } else {
            return getCaller().get(toselect).getSuite();
        }
    }

    //for robot 1
    public ArrayList<Card> getrobot1() {

        return robot1;
    }

    //for robot 2
    public ArrayList<Card> getrobot2() {

        return robot2;
    }

    //for user
    public ArrayList<Card> getuser() {

        return user;
    }

    //for robot 3
    public ArrayList<Card> getrobot3() {
        return robot3;
    }

}
