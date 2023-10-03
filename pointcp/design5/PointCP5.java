

public abstract class PointCP5 {
    public abstract double getX();
    public abstract double getY();
    public abstract double getRho();
    public abstract double getTheta();
    public abstract PointCP3 convertStorageToCartesian();
    public abstract PointCP2 convertStorageToPolar();
}
