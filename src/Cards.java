import java.util.ArrayList;
public class Cards {
    private String suite;
    private String value;
    private int strength;


    public Cards(String suite, String value, int strength) {
        this.suite = suite;
        this.value = value;
        this.strength=strength;
    }

    public String getSuite(){
        return this.suite;
    }

    public String getValue(){
        return this.value;
    }

    public int getStrength(){
        return this.strength;
    }

}
