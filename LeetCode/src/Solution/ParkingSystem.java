package Solution;

public class ParkingSystem {

    private int big = 0;
    private int medium = 0;
    private int small = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 3) {
            if (big > 0) {
                big--;
                return true;
            } else {
                return false;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            } else {
                return false;
            }
        } else if (carType == 1) {
            if (small > 0) {
                small--;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
