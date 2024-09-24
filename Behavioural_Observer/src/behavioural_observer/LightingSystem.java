
package behavioural_observer;

public class LightingSystem implements Observer {

    @Override
    public void update(String event) {
        if (event.equals("Employee Arrived")) {
            System.out.println("Lighting System: Turning lights ON.");
        } else if (event.equals("Employee Left")) {
            System.out.println("Lighting System: Turning lights OFF.");
        }
    }
}
