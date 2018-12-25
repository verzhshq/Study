package ThreadDemo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ThreadDemoCar {

    /**
     * @author zhang
     * //TODO 卖车的当做生产线程
     */

    public static class CarSeller implements Runnable {

        private CarHouse carHouse;

        public CarSeller(CarHouse carHouse) {
            this.carHouse = carHouse;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                carHouse.put(i);
            }

        }
    }

    /**
     * 购买者当做消费者线程
     */
    public static class Consumer implements Runnable {

        private CarHouse carHouse;

        public Consumer(CarHouse carHouse) {
            this.carHouse = carHouse;
        }

        @Override
        public void run() {
            for (int i =0; i < 10; i++) {
                carHouse.get(i);
            }
        }
    }

    public static class Car {
        public String carName;
        public double carPrice;

        public Car(){}

        public Car(String carName, Double carPrice) {
            this.carName = carName;
            this.carPrice = carPrice;
        }

        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        public double getCarPrice() {
            return carPrice;
        }

        public void setCarPrice(double carPrice) {
            this.carPrice = carPrice;
        }
    }



    public static class CarHouse {
        /**
         * 车库中汽车数量
         */
        public Integer carNums = 0;

        public Integer getCarNums() {
            return carNums;
        }

        public void setCarNums(Integer carNums) {
            this.carNums = carNums;
        }

        public List<Car> getCarList(){
            return carList;
        }


        /**
         * 存放汽车的集合
         */
        public List<Car> carList = new ArrayList<>();

        public int put(int i) {
            Car car = CarFactory.makeNewCar();
            carList.add(car);
            carNums++;
            System.out.println("生产汽车——" + i + "->车库汽车数量---count = " + carList.size());
            return carList.size();
        }

        public int get(int i) {
            Car car;
            if(carList.size() > 0) {
                car = carList.get(carList.size() - 1);
                carList.remove(car);
                carNums--;
            }
            System.out.println("消费汽车——" + i + "->车库汽车数量---count = " + carList.size());
            return carList.size();
        }
    }

    /**
     * 采用静态工厂方式创建car对象，这个只是简单摸你，不做设计模式上的过多考究
     */
    public static class CarFactory {

        private CarFactory() {}

        public static Car makeNewCar(String carName, Double carPrice) {
            return new Car(carName, carPrice);
        }

        public static Car makeNewCar() {
            return new Car();
        }
    }

    /**
     * 无同步机制
     */
    public static void main(String[] args) {
        CarHouse ch = new CarHouse();
        new Thread(new CarSeller(ch)).start();
        new Thread(new Consumer(ch)).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(ch.getCarNums());
        System.out.println(ch.getCarList().size());
    }
}
