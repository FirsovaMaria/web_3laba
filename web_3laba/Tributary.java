package web_3laba;

public class Tributary extends River {
    private String mainRiverName; // река, в которую впадает приток
    private boolean seasonal;     // сезонный ли приток

    public Tributary(String name, double length, double width,
                     String mainRiverName, boolean seasonal) {
        super(name, length, width);
        this.mainRiverName = mainRiverName;
        this.seasonal = seasonal;
    }

    @Override
    public String info() {
        return super.info() + String.format(
                "%n  Приток реки %s, сезонный=%s",
                mainRiverName, seasonal ? "да" : "нет");
    }

    public String getMainRiverName() { return mainRiverName; }
    public void setMainRiverName(String mainRiverName) { this.mainRiverName = mainRiverName; }

    public boolean isSeasonal() { return seasonal; }
    public void setSeasonal(boolean seasonal) { this.seasonal = seasonal; }
}
