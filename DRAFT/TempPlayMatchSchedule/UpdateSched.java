import java.util.LinkedList;
import java.util.Queue;

public class UpdateSched {
	public Queue<String> Schedule = new LinkedList<>(); 
	
	public Queue<String> getSched() {
		return Schedule;
	}
	
	public void setSched(String game) {
		Schedule.add(game);
	}
	
	public void removeFirst() {
		Schedule.remove();
	}
}
