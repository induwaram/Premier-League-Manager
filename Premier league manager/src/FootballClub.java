import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {

    private int wins;
    private int defeats;
    private int numberOfGoalsReceived;
    private int numberOfGoalsScored;
    private int draws;
    private int matchesPlayed;
    private int points;


    public FootballClub(String clubName, String location) {
        super(clubName, location);
    }


    public FootballClub(String clubName, String location, int wins, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int draws, int matchesPlayed, int points) {
        super(clubName, location);
        this.wins = wins;
        this.defeats = defeats;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.draws = draws;
        this.matchesPlayed = matchesPlayed;
        this.points = points;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                defeats == that.defeats &&
                numberOfGoalsReceived == that.numberOfGoalsReceived &&
                numberOfGoalsScored == that.numberOfGoalsScored &&
                draws == that.draws &&
                matchesPlayed == that.matchesPlayed &&
                points == that.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, defeats, numberOfGoalsReceived, numberOfGoalsScored, draws, matchesPlayed, points);
    }


    @Override
    public String toString(){
        return this.getClubName();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getMatchesPlayed() {
        int matchesPlayed = wins + defeats + draws;
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPoints() {
        int points = (wins * 2) + (draws * 1);
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

//    @Override
//    public int compareTo(FootballClub o) {
//        return points - o.getPoints();
//    }


//    @Override
//    public int compareTo(FootballClub club) {
//        return points - club.getPoints();
//    }
}
