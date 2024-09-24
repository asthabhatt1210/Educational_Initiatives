
package behavioural_observer;
import java.util.ArrayList;
import java.util.List;
public class Office {
    private List<Observer> observers = new ArrayList<>();

    // Register system observers 
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all registered systems of an event
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void employeeArrives() {
        System.out.println("Employee has arrived at the office.");
        notifyObservers("Employee Arrived");
    }

    public void employeeLeaves() {
        System.out.println("Employee has left the office.");
        notifyObservers("Employee Left");
    }
}
