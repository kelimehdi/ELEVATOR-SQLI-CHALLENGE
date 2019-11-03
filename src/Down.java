public class Down implements ElevatorState{
    Elevator elevator;
    Building building;

    public Down(Elevator newElevator){

        elevator=newElevator;
    }
    @Override
    public void Up() {
            System.out.println("the elevator can't up");


    }

    @Override
    public void Down() {
        System.out.println("the elevator is down");
        elevator.setState(elevator.isDown);


    }

    @Override
    public void Rest() {
        System.out.println("the elevator is resting");
        elevator.setState(elevator.isRest);

    }

    @Override
    public void Stop() {
        System.out.println("stopped");
        elevator.setState(elevator.isStop);

    }
}


