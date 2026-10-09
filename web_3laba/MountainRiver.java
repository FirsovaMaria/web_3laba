/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web_3laba;

/**
 *
 * @author masha
 */
public class MountainRiver extends River{
    private double slope;            /* Уклон русла - на сколько метров река 
                                        опускается на 1 км длины*/
    private int rapidsCount;        /* Количество порогов — участков с бурным  
                                        течением и камнями */
    private double waterfallHeight;  /* Высота водопада, м (если есть на реке)
                                        Если 0 — водопадов нет.*/
    private String rockType;        /*Преобладающая порода в русле: "гранит", 
                                        "базальт", "известняк"*/
    private double temperature;      // Средняя температура, °C

    public MountainRiver(String name, double length, double width,
                         double depth, double velocity,
                         double slope, int rapidsCount,
                         double waterfallHeight, String rockType,
                         double temperature) {
        super(name, length, width, depth, velocity);
        this.slope = slope;
        this.rapidsCount = rapidsCount;
        this.waterfallHeight = waterfallHeight;
        this.rockType = rockType;
        this.temperature = temperature;
    }
    
    //турбулентность
    public double turbulence() {
        return getVelocity() * slope;
    }
    
    //пригодна ли для сплава
    public boolean isRaftable() {
        return turbulence() > 5 && rapidsCount > 0;
    }

    @Override
    public String info() {
        return super.info() + String.format(
                "%nГорная: уклон=%.1f‰, порогов=%d, T=%.1f°C, сплав=%s",
                slope, rapidsCount, temperature, isRaftable() ? "да" : "нет");
    }

    //Геттеры/сеттеры
    public double getSlope() { return slope; }
    public void setSlope(double slope) { this.slope = slope; }

    public int getRapidsCount() { return rapidsCount; }
    public void setRapidsCount(int rapidsCount) { this.rapidsCount = rapidsCount; }

    public double getWaterfallHeight() { return waterfallHeight; }
    public void setWaterfallHeight(double waterfallHeight) { this.waterfallHeight = waterfallHeight; }

    public String getRockType() { return rockType; }
    public void setRockType(String rockType) { this.rockType = rockType; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
}

