public class Elevator {


    ElevatorState isUp;
    ElevatorState isDown;
    ElevatorState isRest;
    ElevatorState isStop;



    protected String idElevator;
    int currentFloor;
    ElevatorState state ;

    public String getIdElevator() {

        return idElevator;
    }

    public void setIdElevator(String idElevator) {
        this.idElevator = idElevator;
    }

    public ElevatorState   getState() {

        return state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {

        this.currentFloor = currentFloor;
    }

    public Elevator() {

        isUp= new Up(this);
        isDown = new Down(this);
        isRest = new Rest(this);
        isStop = new StopState(this);

        this.idElevator = idElevator;
        this.currentFloor = currentFloor;
    }
    public Elevator(String idElevator, int currentFloor) {

        isUp= new Up(this);
        isDown = new Down(this);
        isRest = new Rest(this);
        isStop = new StopState(this);
        state=isRest;
        this.idElevator = idElevator;
        this.currentFloor = currentFloor;
    }

    void setState(ElevatorState newState){
        state = newState;

    }
    public void Up(){
        state.Up();
    }
    public void Down(){
        state.Down();

    }
    public void Rest(){
        state.Rest();
    }
    public void Stop(){
        state.Stop();
    }

    public ElevatorState changeToUp(){
        return isUp;

    }
    public ElevatorState changeToDown(){
        return isDown;

    }
    public ElevatorState changeToRest(){
        return isRest;

    }
    public ElevatorState changeToStop(){
        return isStop;

    }







}
