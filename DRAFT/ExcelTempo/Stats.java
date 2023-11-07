import java.util.LinkedList;
import java.util.Queue;

public class Stats {
    LinkedList <String> roundStats;
    ExcelHandler excel = new ExcelHandler();

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
    
    public LinkedList <String> getRoundStats() {
        return roundStats;
    }

    public void addToRoundStats(LinkedList <String> stats, String data) {
        stats.add(data);
    }

    public String gameWinner(int t1, int t2, String winner, String team1, String team2) {
        if (t1 > t2) {
            winner = team1;
        } else { winner = team2; }
        return winner;
    }

    public String gameLoser(String gameW, String team1, String team2, String loser) {
        if (gameW.equals(team1)) {
            loser = team2;
        } else { loser = team1; }
        return loser;
    }
}
