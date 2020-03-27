package comps;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Arrays;

@JsonAutoDetect
@JsonRootName("mood")
public enum Mood {
    SADNESS("sadness", 1),
    SORROW("sorrow", 2),
    RAGE("rage", 3);

    private String mood;
    private final int num;

    Mood(String mood, int num){
        this.mood = mood;
        this.num = num;
    }

    public static String[] getNames(){
        Mood moods[] = values();
        String[] names = new String[moods.length];
        for(int i = 0; i < names.length; i++){
            names[i] = moods[i].name();
        }
        return names;
    }

    public static boolean has(String name){
        String[] names = getNames();
        return Arrays.asList(names).contains(name);
    }

    public String getValue(){
        return mood;
    }

    public int getNum(){
        return num;
    }
}