import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {

    private String university;

    public UniversityFootballClub(String clubName, String location, String university) {
        super(clubName, location);
        this.university = university;
    }

    public UniversityFootballClub(String clubName, String location, int wins, int defeats, int draws, int numberOfGoalsReceived, int numberOfGoalsScored, int matchesPlayed, int points, Date1 date1, String university) {
        super(clubName, location, wins, defeats,draws, numberOfGoalsReceived, numberOfGoalsScored, matchesPlayed, points);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "university='" + university + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }
}
