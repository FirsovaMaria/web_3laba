package web_3laba;

public class MountainRiver extends River {
    private double slope;     // уклон
    private int rapidsCount;  // количество порогов

    public MountainRiver(String name, double length, double width,
                         double slope, int rapidsCount) {
        super(name, length, width);
        this.slope = slope;
        this.rapidsCount = rapidsCount;
    }

    @Override
    public String info() {
        return super.info() + String.format(
                "%n  Горная: уклон=%.1f, порогов=%d", slope, rapidsCount);
    }

    public double getSlope() { return slope; }
    public void setSlope(double slope) { this.slope = slope; }

    public int getRapidsCount() { return rapidsCount; }
    public void setRapidsCount(int rapidsCount) { this.rapidsCount = rapidsCount; }
}
