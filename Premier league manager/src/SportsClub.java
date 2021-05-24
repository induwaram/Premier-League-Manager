import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private String clubName;
    private String location;

    public SportsClub(String clubName, String location) {
        this.clubName = clubName;
        this.location = location;
    }




    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(clubName, that.clubName) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location);
    }
}
