package web_3laba;

public class River {
    private String name;
    private double length; // длина, км
    private double width;  // ширина, м

    public River(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public String info() {
        return String.format("Река %s: длина=%.1f км, ширина=%.1f м",
                name, length, width);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
}
