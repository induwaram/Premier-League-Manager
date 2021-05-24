import java.io.FileNotFoundException;
import java.util.Date;

public interface LeagueManager {
    void addclub(String name,String location,int wins,int defeats,int draws,int goalsReceived,int goalsScored,int matchesPlayed);
    void deleteclub(String name);
//    void addMatch(String input,Date1 date,FootballClub club1,int club1Goals,FootballClub club2,int club2Goals,String location);
    void addMatch(Date1 date,FootballClub club1,int club1Goals,FootballClub club2,int club2Goals,String location);
    void printTable();
    void stats(String name);
    void save() throws FileNotFoundException;
    void loadData();
    void getNameList();

}
