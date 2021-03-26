import java.util.ArrayList;
import java.util.Random;

public class SittingOrder {

    public ArrayList<String> putting_in_order() {
        Random arrangement = new Random();
        ArrayList<String> sitting_order = new ArrayList<String>();
        sitting_order.add("u");
        sitting_order.add("r1");
        sitting_order.add("r2");
        sitting_order.add("r3");
        sitting_order.add("call");

        for (int x = sitting_order.size() - 1; x > 0; x--) {
            int playing_order = arrangement.nextInt(5);
            int playing_order2 = arrangement.nextInt(5);
            String a = sitting_order.get(playing_order);
            String b = sitting_order.get(playing_order2);
            sitting_order.set(playing_order, b);
            sitting_order.set(playing_order2, a);
        }
        if (sitting_order.get(4) == "u") {
            sitting_order.remove(0);
            //to check whether the caller is in the list and if it is to put it at the start of the list
            if (sitting_order.contains("call")) {
                for (int i = 0; i < sitting_order.size(); i++) {
                    if (sitting_order.get(i) == "call") {
                        String t = sitting_order.get(0);
                        String z = sitting_order.get(i);
                        sitting_order.set(0, z);
                        sitting_order.set(i, t);
                    }
                }

                //to put the user at the start if the caller is not in the list
            } else {
                for (int i = 0; i < sitting_order.size(); i++) {
                    if (sitting_order.get(i) == "u") {
                        String t = sitting_order.get(0);
                        String z = sitting_order.get(i);
                        sitting_order.set(0, z);
                        sitting_order.set(i, t);
                    }
                }

            }
        } else {
            sitting_order.remove(4);
            //to check whether the caller is in the list and if it is to put it at the start of the list
            if (sitting_order.contains("call")) {
                for (int i = 0; i < sitting_order.size(); i++) {
                    if (sitting_order.get(i) == "call") {
                        String t = sitting_order.get(0);
                        String z = sitting_order.get(i);
                        sitting_order.set(0, z);
                        sitting_order.set(i, t);
                    }

                }
                //to put the user at the start if the caller is not in the list
            } else {
                for (int i = 0; i < sitting_order.size(); i++) {
                    if (sitting_order.get(i) == "u") {
                        String t = sitting_order.get(0);
                        String z = sitting_order.get(i);
                        sitting_order.set(0, z);
                        sitting_order.set(i, t);
                    }
                }

            }
        }
        return sitting_order;
    }

}
