/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web_3laba;

/**
 *
 * @author masha
 */

// Класс приток 
public class Tributary extends River{
private River mainRiver;         /* Главная река, в которую впадает приток */
    private double confluencePoint;  /* Точка впадения — км от устья главной реки */
    private int order;               /* Порядок притока: 1-й, 2-й и т.д. */
    private double basinArea;        /* Площадь водосбора, км? */
    private boolean seasonal;        /* Сезонный ли приток (пересыхает зимой) */

    public Tributary(String name, double length, double width,
                     double depth, double velocity,
                     River mainRiver, double confluencePoint,
                     int order, double basinArea, boolean seasonal) {
        super(name, length, width, depth, velocity);
        this.mainRiver = mainRiver;
        this.confluencePoint = confluencePoint;
        this.order = order;
        this.basinArea = basinArea;
        this.seasonal = seasonal;
    }

    // Влияние притока на главную реку (доля объёма главной реки)
    public double impactOnMain() {
        return volume() / mainRiver.volume();
    }

    // Временный ли приток (сезонный)
    public boolean isTemporary() {
        return seasonal;
    }

    @Override
    public String info() {
        return super.info() + String.format(
                "%nПриток %d-го порядка ? %s (%.0f км от устья), " +
                "бассейн=%.0f квадратных км, сезонный=%s",
                order, mainRiver.getName(), confluencePoint,
                basinArea, seasonal ? "да" : "нет");
    }

    // Геттеры/сеттеры
    public River getMainRiver() { return mainRiver; }
    public void setMainRiver(River mainRiver) { this.mainRiver = mainRiver; }

    public double getConfluencePoint() { return confluencePoint; }
    public void setConfluencePoint(double confluencePoint) { this.confluencePoint = confluencePoint; }

    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }

    public double getBasinArea() { return basinArea; }
    public void setBasinArea(double basinArea) { this.basinArea = basinArea; }

    public boolean isSeasonal() { return seasonal; }
    public void setSeasonal(boolean seasonal) { this.seasonal = seasonal; }
}
