public class Up implements ElevatorState {
    Elevator elevator;
    Building building;

    public Up(Elevator newElevator) {
        elevator = newElevator;
    }

    @Override
    public void Up() {
        System.out.println("the elevator is up");




    }

    @Override
    public void Down() {
        System.out.println("the elevator can't down");
    }

    @Override
    public void Rest() {
        System.out.println("the elevator is resting");
        elevator.setState(elevator.isUp);




    }
    @Override
    public void Stop() {
        System.out.println("stopped");
        elevator.setState(elevator.isStop);

    }

}
