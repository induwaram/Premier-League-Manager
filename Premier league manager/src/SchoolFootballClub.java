import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {

    private String school;

    public SchoolFootballClub(String clubName, String location, String school) {
        super(clubName, location);
        this.school = school;
    }

    public SchoolFootballClub(String clubName, String location, int wins, int defeats,int draws, int numberOfGoalsReceived, int numberOfGoalsScored, int matchesPlayed, int points, String school) {
        super(clubName, location, wins, defeats,draws, numberOfGoalsReceived, numberOfGoalsScored, matchesPlayed, points);
        this.school = school;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "school='" + school + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(school, that.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), school);
    }
}
