public class Rest implements ElevatorState{
    Elevator elevator;

    public Rest(Elevator newElevator){
        elevator=newElevator;
    }
    @Override
    public void Up() {
        System.out.println("the elevator is up");
        elevator.setState(elevator.isUp);


    }

    @Override
    public void Down() {
        System.out.println("the elevator is down");
        elevator.setState(elevator.isDown);


    }

    @Override
    public void Rest() {
        System.out.println("the elevator is resting");



    }
    @Override
    public void Stop() {
        System.out.println("stopped");
        elevator.setState(elevator.isStop);

    }
}


