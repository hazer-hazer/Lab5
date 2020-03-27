package comps;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonAutoDetect
public class HumanBeing {

    private static int lastId = 0;

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private float minutesOfWaiting;
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing(String name,
                      Coordinates coordinates,
                      boolean realHero,
                      boolean hasToothpick,
                      float impactSpeed,
                      String soundtrackName,
                      float minutesOfWaiting,
                      Mood mood,
                      Car car){
        id = ++lastId;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }

    @JsonCreator
    public HumanBeing(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("coordinates") Coordinates coordinates,
            @JsonProperty("creationDate") LocalDateTime creationDate,
            @JsonProperty("realHero") boolean realHero,
            @JsonProperty("hasToothpick") boolean hasToothpick,
            @JsonProperty("impactSpeed") float impactSpeed,
            @JsonProperty("soundtrackName") String soundtrackName,
            @JsonProperty("minutesOfWaiting") float minutesOfWaiting,
            @JsonProperty("mood") Mood mood,
            @JsonProperty("car") Car car
    ){
        if(HumanBeing.lastId < id){
            HumanBeing.lastId = id;
        }
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        if (creationDate != null) {
            this.creationDate = LocalDateTime.parse(creationDate);
        } else {
            this.creationDate = LocalDateTime.now();
        }
    }

    public boolean getRealHero(){
        return realHero;
    }
    public void setRealHero(boolean realHero){
        this.realHero = realHero;
    }

    public boolean getHasToothpick(){
        return hasToothpick;
    }
    public void setHasToothpick(boolean hasToothpick){
        this.hasToothpick = hasToothpick;
    }

    public float getImpactSpeed(){
        return impactSpeed;
    }
    public void setImpactSpeed(float impactSpeed){
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName(){
        return soundtrackName;
    }
    public void setSoundtrackName(String soundtrackName){
        this.soundtrackName = soundtrackName;
    }

    public float getMinutesOfWaiting(){
        return minutesOfWaiting;
    }
    public void setMinutesOfWaiting(float minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Mood getMood(){
        return mood;
    }
    public void setMood(Mood mood){
        this.mood = mood;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car = car;
    }

    public boolean greaterThan(HumanBeing humanBeing){
        return humanBeing.getCoordinates().greaterThan(coordinates);
    }

    @Override
    public String toString(){
        String coordsString = coordinates != null ? coordinates.toString() : "null";
        String creationDateString = creationDate != null ? creationDate.toString() : "null";
        String moodString = mood != null ? mood.toString() : "null";
        String carString = car != null ? car.toString() : "null";
        return "HumanBeing id " + id
                + "\n\tName: " + name
                + "\n\tCoordinates: " + coordsString
                + "\n\tCreation Date: " + creationDateString
                + "\n\tReal hero: " + realHero
                + "\n\tHas toothpick: " + hasToothpick
                + "\n\tImpact speed: " + impactSpeed
                + "\n\tSoundtrack name: " + soundtrackName
                + "\n\tMinutes of waiting: " + minutesOfWaiting
                + "\n\tMood: " + moodString
                + "\n\tCar: " + carString;
    }
}