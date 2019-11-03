
public class StopState implements ElevatorState{
    Elevator elevator;
    Building building;

    public StopState(Elevator newElevator){

        elevator=newElevator;
    }
    @Override
    public void Up() {
        System.out.println("the elevator can't up, im stopped");


    }

    @Override
    public void Down() {
        System.out.println("the elevator is stopped");



    }

    @Override
    public void Rest() {
        System.out.println("the elevator is resting");
        elevator.setState(elevator.isRest);

    }

    @Override
    public void Stop() {
        System.out.println("stopped");

    }
}


