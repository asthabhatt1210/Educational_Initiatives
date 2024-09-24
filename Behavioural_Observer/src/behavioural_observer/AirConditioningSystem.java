package behavioural_observer;

public class AirConditioningSystem implements Observer{

    @Override
    public void update(String event) {
        if (event.equals("Employee Arrived")) {
            System.out.println("Air Conditioning System: Cooling started.");
        } else if (event.equals("Employee Left")) {
            System.out.println("Air Conditioning System: Cooling stopped.");
        }
    }
    
}
