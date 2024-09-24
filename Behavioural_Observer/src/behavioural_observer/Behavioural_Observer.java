
package behavioural_observer;

public class Behavioural_Observer {
public static void main(String args[]){
    Office office = new Office();

        // Register systems
        office.registerObserver(new LightingSystem());
        office.registerObserver(new AirConditioningSystem());
        office.registerObserver(new EmployeeLogService());

        // Simulate employee arriving and leaving
        office.employeeArrives();
        office.employeeLeaves();
}
}
