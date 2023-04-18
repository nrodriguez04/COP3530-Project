import java.util.LinkedList;
import java.util.Queue;

public class TemperatureGauge {
    
    private int temp =0;
    private int maxTemp = 250;
    private int minTemp = 0;
    private int tempRange = maxTemp - minTemp;

    public  int getTemp(int temp) {
        temp = (int) (Math.random() * tempRange + minTemp);
        return temp;
    }

    public  void displayTemp() {
        currentTemp(getTemp(temp));
    }

    public  boolean isOverheated(int temp) {
        if (temp >= 220) {
            return true;
        } else {
            return false;
        }
    }

    public  void displayOverheated() {
        System.out.println("Vehicle is overheated: " + temp + "°F");
    }
    
    public int currentTemp(int getTemp){
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        int[] tempReadings = new int[10];
        temp = 0;
        for(int i = 0; i < tempReadings.length; i++){
            tempReadings[i] = getTemp;
        }
        for(int temperature: tempReadings){
            tempQueue.add(temperature);
            temp = temperature;
        } 
        if(temp >= 220){
            displayOverheated();
        }
        else if(temp < 220)
         System.out.println("Temperature: " + temp + "°F");
        return temp;
        
    }

}