import java.util.*;

public class Building {

    int numberOfFloors;
    protected HashMap<String, Elevator> elevators;



    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new HashMap<>();
        for (String el : elevators) {

            String[] parts = el.split(":");
            String id = parts[0];
            int currentFloor = Integer.valueOf(parts[1]);
            Elevator e = new Elevator(id,currentFloor);
            this.elevators.put(id, e);


        }

    }

    public void move(String idElevator,String direction){

        Elevator elevator = elevators.get(idElevator);
        switch (direction){

            case "up":
                elevator.setState(elevator.changeToUp());

            case "down":
                elevator.setState(elevator.changeToDown());
        }
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public String requestElevator(int w){

        HashMap<Integer,Elevator> distances= new HashMap<>();
        for(Elevator el : elevators.values()){
            if(el.getState()instanceof Up) {
                System.out.println("UP check");
                int x = el.getCurrentFloor();
                if (w < x) {
                    int d = (this.numberOfFloors - x) + (this.numberOfFloors - w);
                    distances.put(d,el);
                } else {
                    int d = (w - x);
                    distances.put(d,el);
                }
            }
            else if(el.getState()instanceof Down){
                System.out.println("DOWN check");
                int x =el.getCurrentFloor();
                if(w<x){
                    int d = x-w;
                    distances.put(d,el);
                }
                else{
                    int d= w+x;
                    distances.put(d,el);
                }
            }
            else{
                System.out.println("REST check");
                int x =el.getCurrentFloor();
                int d= Math.abs(x-w);
                distances.put(d,el);

            }




        }
        String id = distances.get(Collections.min(distances.keySet())).getIdElevator();
        elevators.get(id).getState().Rest();
        return (id);


    }

    public String requestElevator(){
        HashMap<Integer,Elevator> distances1= new HashMap<>();
        for(Elevator el : elevators.values()) {

            if ( el.getState() instanceof Rest) {
                int x = el.getCurrentFloor();
                int d = this.numberOfFloors - x;
                distances1.put(d, el);
            }
            else if (el.getState() instanceof Up ) {
                int x = el.getCurrentFloor();
                int d = this.numberOfFloors - x;
                distances1.put(d, el);
            }
            else if (el.getState() instanceof Down) {
                int x = el.getCurrentFloor();
                int d = x + this.numberOfFloors;
                distances1.put(d, el);
            }
        }
        String id = distances1.get(Collections.min(distances1.keySet())).getIdElevator();
        elevators.get(id).getState().Rest();
        return (id);


    }
    public void stopAt(String idElevator,int floor){
        for(Elevator el : elevators.values()){

            if(el.getIdElevator().equals(idElevator)){
                el.setState(el.changeToStop());
                el.setCurrentFloor(floor);
            }
        }



    }





}
