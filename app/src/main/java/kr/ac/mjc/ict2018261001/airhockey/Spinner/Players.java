package kr.ac.mjc.ict2018261001.airhockey.Spinner;
import java.io.Serializable;

public class Players implements Serializable{

    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
