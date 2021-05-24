import java.io.Serializable;
import java.util.Date;

public class MatchDetails implements Serializable {
    private Date1 kickOffDay;
    private FootballClub club1;
    private int club1Goals;
    private FootballClub club2;
    private int club2Goals;
    private String location;

    public MatchDetails(Date1 kickOffDay, FootballClub club1, int club1Score, FootballClub club2, int club2Goals, String location) {
        this.kickOffDay = kickOffDay;
        this.club1 = club1;
        this.club1Goals = club1Score;
        this.club2 = club2;
        this.club2Goals = club2Goals;
        this.location = location;

    }

    public void setClub1(FootballClub club1) {
        this.club1 = club1;
    }

    public void setClub2(FootballClub club2) {
        this.club2 = club2;
    }

    public Date1 getKickOffDay() {
        return kickOffDay;
    }

    public void setKickOffDay(Date1 kickOffDay) {
        this.kickOffDay = kickOffDay;
    }


    public int getClub1Score() {
        return club1Goals;
    }

    public void setClub1Score(int club1Score) {
        this.club1Goals = club1Score;
    }


    public int getClub2Goals() {
        return club2Goals;
    }

    public void setClub2Goals(int club2Goals) {
        this.club2Goals = club2Goals;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public FootballClub getClub1() {
        return club1;
    }

    public int getClub1Goals() {
        return club1Goals;
    }

    public void setClub1Goals(int club1Goals) {
        this.club1Goals = club1Goals;
    }

    public FootballClub getClub2() {
        return club2;
    }

    public void updateClubs(){
        int club1NewGoalsScored = club1.getNumberOfGoalsScored() + club1Goals;
        club1.setNumberOfGoalsScored(club1NewGoalsScored);
        int club2NewGoalsScored = club2.getNumberOfGoalsScored() + club2Goals;
        club2.setNumberOfGoalsScored(club2NewGoalsScored);

        int club1NewGoalsReceived = club1.getNumberOfGoalsReceived() + club2Goals;
        club1.setNumberOfGoalsReceived(club1NewGoalsReceived);
        int club2NewGoalsReceived = club2.getNumberOfGoalsReceived() + club1Goals;
        club2.setNumberOfGoalsReceived(club2NewGoalsReceived);

        if (club1Goals > club2Goals){
            int club1NewWins = club1.getWins() + 1;
            int club2Defeats = club2.getDefeats() + 1;
            club1.setWins(club1NewWins);
            club2.setDefeats(club2Defeats);
        }
        else if(club1Goals == club2Goals){
            int club1NewDraws = club1.getDraws() + 1;
            int club2NewDraws = club2.getDraws() + 1;
            club1.setDraws(club1NewDraws);
            club2.setDraws(club2NewDraws);
        }
        else {
            int club2NewWins = club2.getWins() + 1;
            int club1Defeats = club1.getDefeats() + 1;
            club2.setWins(club2NewWins);
            club1.setDefeats(club1Defeats);
        }

    }

    @Override
    public String toString() {
        return "MatchDetails{" +
                "kickOffDay=" + kickOffDay +
                '}';
    }


}

