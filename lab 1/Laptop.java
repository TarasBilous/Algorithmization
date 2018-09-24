public class Laptop {

    private String producer;
    private int speedCpu;
    private int volumeRam;

    public Laptop(String producer, int speedCpu, int volumeRam) {
        this.producer = producer;
        this.speedCpu = speedCpu;
        this.volumeRam = volumeRam;
    }

    public int getSpeedCpu() {
        return speedCpu;
    }

    public int getVolumeRam() {
        return volumeRam;
    }

    @Override
    public String toString() {
        return "producer = " + producer + '(' +
                "CPU speed = " + speedCpu +
                ", RAM volume = " + volumeRam + ')';
    }
}
