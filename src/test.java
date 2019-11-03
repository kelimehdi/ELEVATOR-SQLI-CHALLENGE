import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void the_closest_elevator_to_top_floor_should_arrive_first() {
        int numberOfFloors = 10;
        Building building = new Building(numberOfFloors, "id1:1", "id2:6");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id2", idOfFirstAvailableElevator);
    }

        @Test
    public void elevators_going_down_arrive_last_to_top_floor() {
        Building building = new Building(10, "id1:1", "id2:6");
        building.move("id2", "down");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_up_should_arrive_to_top_floor_before_those_going_down() {
        Building building = new Building(10, "id1:1", "id2:6");
        building.move("id1", "up");
        building.move("id2", "down");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void elevators_going_up_should_be_compared_to_those_resting() {
        Building building = new Building(10, "id1:1", "id2:6", "id3:5");
        building.move("id1", "up");
        building.move("id2", "down");
        building.move("id3", "rest");

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id3", idOfFirstAvailableElevator);
    }

   @Test
   public void elevators_going_up_and_not_stopping_should_arrive_first_to_top_floor() {
       Building building = new Building(10, "id1:1", "id2:6", "id3:5");
        building.move("id1", "up");
        building.move("id2", "down");
        building.move("id3", "up");
        building.stopAt("id3", 7);

        String idOfFirstAvailableElevator = building.requestElevator();

        assertEquals("id1", idOfFirstAvailableElevator);
    }

    @Test
    public void can_request_elevator_in_middle_of_building() {
        Building building = new Building(10, "id1:1", "id2:6");

        String idOfFirstAvailableElevator = building.requestElevator(5);

        assertEquals("id2", idOfFirstAvailableElevator);
    }

}