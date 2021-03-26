import java.util.Random;
import java.util.ArrayList;
public class Initial {
    public static void main(String[] args) {


        Omi game = new Omi();
        sitting_order sit=new sitting_order();
//        Tactics trump=new Tactics();


        Cards h7 = new Cards("h", "7",1);
        Cards h8 = new Cards("h", "8",2);
        Cards h9 = new Cards("h", "9",3);
        Cards h10 = new Cards("h", "10",4);
        Cards hj = new Cards("h", "j",5);
        Cards hq = new Cards("h", "q",6);
        Cards hk = new Cards("h", "k",7);
        Cards ha = new Cards("h", "a",8);

        Cards s7 = new Cards("s", "7",1);
        Cards s8 = new Cards("s", "8",2);
        Cards s9 = new Cards("s", "9",3);
        Cards s10 = new Cards("s", "10",4);
        Cards sj = new Cards("s", "j",5);
        Cards sq = new Cards("s", "q",6);
        Cards sk = new Cards("s", "k",7);
        Cards sa = new Cards("s", "a",8);

        Cards d7 = new Cards("d", "7",1);
        Cards d8 = new Cards("d", "8",2);
        Cards d9 = new Cards("d", "9",3);
        Cards d10 = new Cards("d", "10",4);
        Cards dj = new Cards("d", "j",5);
        Cards dq = new Cards("d", "q",6);
        Cards dk = new Cards("d", "k",7);
        Cards da = new Cards("d", "a",8);

        Cards c7 = new Cards("c", "7",1);
        Cards c8 = new Cards("c", "8",2);
        Cards c9 = new Cards("c", "9",3);
        Cards c10 = new Cards("c", "10",4);
        Cards cj = new Cards("c", "j",5);
        Cards cq = new Cards("c", "q",6);
        Cards ck = new Cards("c", "k",7);
        Cards ca = new Cards("c", "a",8);

        game.addCard(h7,h8,h9,h10,hj,hq,hk,ha,s7,s8,s9,s10,sj,sq,sk,sa,d7,d8,d9,d10,dj,dq,dk,da,c7,c8,c9,c10,cj,cq,ck,ca);
        System.out.println(game.getAllCards().size());
//        for(int x=0; x<=game.getAllCards().size()-1; x++){
//            System.out.println("Card Suit : "+game.getAllCards().get(x).getSuite()+". Card Val: "+game.getAllCards().get(x).getValue()+" The strength is: "+game.getAllCards().get(x).getStrength());
//        }
//
//        for (int j=game.getAllCards().size()-1;j<0;j--){
//            int shuff=plswork.nextInt(j+1);
//           int s=game.getAllCards().indexOf(shuff);
//           int d=game.getAllCards().indexOf(j);
//
//        }
        game.shuffle(game.getAllCards());
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
}
