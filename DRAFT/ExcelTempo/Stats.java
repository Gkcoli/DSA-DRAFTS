import java.util.LinkedList;
import java.util.Queue;

public class Stats {
    LinkedList <String> roundStats;
    public Queue<String> Schedule = new LinkedList<>(); 
    
	
	public Queue<String> getSched() {
		return Schedule;
	}
	
	public void setSched() {
		Schedule.add("GAME 1");
		Schedule.add("GAME 2");
		Schedule.add("GAME 3");
		Schedule.add("GAME 4");
	}

    public void updateSched(String gameNum, LinkedList<String> sched, String t1, String t2, String status, String winner, String loser) {
        if (Schedule.isEmpty()) {
            status = "FINISHED";  }
        else if(!((Schedule.peek()).equals(gameNum))) {
            status = "FINISHED";
        } else {
            status = "WAITING FOR TEAMS";  }
       
        sched.add(t1);
		sched.add(t2);
		sched.add(status);
		sched.add(winner);
		sched.add(loser);
    }

	
	public void removeFirst() {
		Schedule.remove();
	}

    public String getFirst() {
        String first = Schedule.peek();
        return first;
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
        }
        else { winner = team2; }
        return winner;
    }

    public String gameLoser(String gameW, String team1, String team2, String loser) {
        if (gameW.equals(team1)) {
            loser = team2;
        } else {
            loser = team1; }
        return loser;
    }
}
class LeaderEntry {
    private String playerName;
    private int kills;
    private int defuses;
    private int plants;
    private int support;
    private int deaths;

    public LeaderEntry(String playerName, int kills, int defuses, int plants, int support, int deaths) {
        this.playerName = playerName;
        this.kills = kills;
        this.defuses = defuses;
        this.plants = plants;
        this.support = support;
        this.deaths = deaths;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getKills() {
        return kills;
    }

    public int getDefuses() {
        return defuses;
    }

    public int getPlants() {
        return plants;
    }

    public int getSupport() {
        return support;
    }

    public int getDeaths() {
        return deaths;
    }
}
