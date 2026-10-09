/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web_3laba;

/**
 *
 * @author masha
 */
public class River {
    private String name;
    private double length; //длина, км
    private double width; //средняя ширина, м
    private double depth; //средняя глубина, м
    private double velocity; //скорость течения, м/с
    
    public River(String name, double length, double width, double depth, double velocity){
        this.name = name;
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.velocity = velocity;
    };
    
    //объем воды в русле
    public double volume() {
    return length * 1000 * width * depth;  //м?
}
    
    public String getCategory() {
        if (length > 1000) return "крупная";
        if (length > 200)  return "средняя";
        return "малая";
    }
    
    public String info() {
    return String.format("Река %s: L=%.1f км, W=%.1f м, D=%.1f м, V=%.0f кубометров, категория: %s",
            name, length, width, depth,  volume(), getCategory());
}
    
    //Геттеры/сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public double getDepth() { return depth; }
    public void setDepth(double depth) { this.depth = depth; }

    public double getVelocity() { return velocity; }
    public void setVelocity(double velocity) { this.velocity = velocity; }
}
