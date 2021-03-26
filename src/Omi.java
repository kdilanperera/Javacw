import java.util.ArrayList;
import java.util.Random;

public class Omi{

    Random plswork=new Random();

    private ArrayList<Cards> allCards = new ArrayList<>();
    //the seperated cards for the players to play
    private ArrayList<Cards> caller= new ArrayList<>();
    private ArrayList<Cards> user=new ArrayList<>();
    private ArrayList<Cards> robot1=new ArrayList<>();
    private ArrayList<Cards> robot2=new ArrayList<>();
    private ArrayList<Cards> robot3=new ArrayList<>();


    //Used in tactics for the computer to find trumps
    int all4=0;
    int all3one=0;
    int all3two=0;
    int all3three=0;
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    int e=0;
    int f=0;


    public Omi() {
    }

    public void addCard(Cards... card){
        for(int x=0; x<= card.length-1; x++){
            allCards.add(card[x]);
        }
    }


    public ArrayList<Cards> getAllCards() {

            return allCards;
        }

    public void shuffle(ArrayList<Cards> ar) {
        for (int j = ar.size() - 1; j > 0; j--) {
            int shuff = plswork.nextInt(j + 1);
            int shuff1 = plswork.nextInt(j + 1);
            Cards s = ar.get(shuff);
            Cards e = ar.get(shuff1);
            ar.set(shuff1, s);
            ar.set(shuff, e);
        }
    }
    //For Tactics
    public ArrayList<Cards> getCaller() {

        return caller;
    }
//Distributing 32 cards amoung 4 players
        public void choosing_for_robot(){
    //        System.out.println(getAllCards().size());
            for(int i=0;i<4;i++){
            caller.add(getAllCards().get(i));
            }
            for(int j=16;j<20;j++){
                caller.add(getAllCards().get(j));
            }
//            for(int x=0;x<4;x++){
//            System.out.println(caller.get(x).getSuite()+" "+caller.get(x).getStrength());
//            }

        }

        public void choosing_for_user(){
            for(int i=0;i<4;i++){
                user.add(getAllCards().get(i));
            }
            for(int j=16;j<20;j++){
                user.add(getAllCards().get(j));
            }
//            for(int x=0;x<4;x++){
//                System.out.println(user.get(x).getSuite()+" "+user.get(x).getStrength());
//            }

        }

        public void seperating_for_player_2(ArrayList<Cards> player2){
        for(int i=4;i<8;i++){
            player2.add(getAllCards().get(i));
        }
        for(int j=20;j<24;j++){
            player2.add(getAllCards().get(j));
        }
        }

    public void seperating_for_player_3(ArrayList<Cards> player3){
        for(int i=8;i<12;i++){
            player3.add(getAllCards().get(i));
        }
        for(int j=24;j<28;j++){
            player3.add(getAllCards().get(j));
        }
    }
    public void seperating_for_player_4(ArrayList<Cards> player4){
        for(int i=12;i<16;i++){
            player4.add(getAllCards().get(i));
        }
        for(int j=28;j<32;j++){
            player4.add(getAllCards().get(j));
        }
    }
//Rules for when the computer has to pick the trump
        public String tactics(){
            int toselect=plswork.nextInt(4);
            if (getCaller().get(0).getSuite()==getCaller().get(1).getSuite()){
              all4+=1;
              all3one +=1;
              a+=1;

            }

            if (getCaller().get(0).getSuite()==getCaller().get(2).getSuite()){
                all4+=1;
                all3one +=1;
                all3two +=1;
                b+=1;

            }

            if (getCaller().get(0).getSuite()==getCaller().get(3).getSuite()){
                all4+=1;
                all3two +=1;
                c+=1;

            }

            if (getCaller().get(1).getSuite()==getCaller().get(2).getSuite()){
                all4+=1;
                all3one +=1;
                all3three +=1;
                d+=1;

            }

            if (getCaller().get(1).getSuite()==getCaller().get(3).getSuite()){
                all4+=1;
                all3three +=1;
                e+=1;

            }

            if (getCaller().get(2).getSuite()==getCaller().get(3).getSuite()){
                all4+=1;
                all3two +=1;
                all3three +=1;
                f+=1;

            }
            //if all 4 suits are equal
            if (all4==6){
                return getCaller().get(0).getSuite();
            }
            //if 3 suits are equal
            else if (all3one==3){
                return getCaller().get(0).getSuite();
                }
            else if(all3two==3){
                return getCaller().get(0).getSuite();
            }
            else if(all3three==3){
                return getCaller().get(1).getSuite();
            }
            //if 2 suits are equal with the A thing
            else if(a==1 && f==1){
            if(getCaller().get(0).getStrength()==8 || getCaller().get(1).getStrength()==8){
                return getCaller().get(2).getSuite();
                }else if(getCaller().get(2).getStrength()==8 || getCaller().get(3).getStrength()==8){
                return getCaller().get(0).getSuite();
            }
            else{return getCaller().get(toselect).getSuite();

            }
            }  else if(b==1 && e==1){
                if(getCaller().get(0).getStrength()==8 || getCaller().get(2).getStrength()==8){
                    return getCaller().get(1).getSuite();
                }else if(getCaller().get(1).getStrength()==8 || getCaller().get(3).getStrength()==8){
                    return getCaller().get(0).getSuite();
                }
                else{return getCaller().get(toselect).getSuite();

                }
            }  else if(c==1 && d==1){
                if(getCaller().get(0).getStrength()==8 || getCaller().get(3).getStrength()==8){
                   return getCaller().get(2).getSuite();
                }else if(getCaller().get(1).getStrength()==8 || getCaller().get(2).getStrength()==8){
                    return getCaller().get(0).getSuite();
                }
                else{return getCaller().get(toselect).getSuite();

                }
                //if only 2 suits are equal
            }else if(a==1){
                return getCaller().get(0).getSuite();
            }else if(b==1){
                return getCaller().get(0).getSuite();
            }else if(c==1){
                return getCaller().get(0).getSuite();
            }else if(d==1){
                return getCaller().get(1).getSuite();
            }else if(e==1){
                return getCaller().get(1).getSuite();
            }else if(f==1){
                return getCaller().get(2).getSuite();
            }else{
                return getCaller().get(toselect).getSuite();
            }
            }

            //for robot 1
            public ArrayList<Cards> getrobot1() {

                return robot1;
            }

            //for robot 2
            public ArrayList<Cards> getrobot2() {

                return robot2;
            }

            //for user
            public ArrayList<Cards> getuser() {

                return user;
            }

            //for robot 3
            public ArrayList<Cards> getrobot3(){
                    return robot3;
            }

}