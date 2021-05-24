import java.util.Comparator;

public class SortingGoals implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getNumberOfGoalsScored()<club2.getNumberOfGoalsScored()){
            return 1;
        }else if (club1.getNumberOfGoalsScored()>club2.getNumberOfGoalsScored()){
            return -1;
        }else{
            return 0;

        }
    }
}
