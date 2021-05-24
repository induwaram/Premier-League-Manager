import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class PremierLeagueManager implements LeagueManager {
    private ArrayList<FootballClub> mainClub = new ArrayList<>() ;
    private ArrayList<MatchDetails> matchesData = new ArrayList<>();




    //adding clubs
    @Override
    public void addclub(String name,String location,int wins,int defeats,int draws,int goalsReceived,int goalsScored,int matchesPlayed) {
           //Calculating the points
            int points = (wins * 2) + (draws * 1);

            FootballClub footballClub = new FootballClub(name, location, wins, defeats,draws, goalsReceived, goalsScored, matchesPlayed, points);

            //checking whether there's no iteration of the same club
            boolean search = false;
            for (FootballClub club : mainClub) {
                if (club.getClubName().equals(name)) {
                    search = true;
                    System.out.println("That club is already Registered\n");
                    break;
                }
            }
            //Confirmation Message
            if (!search) {
                mainClub.add(footballClub);
                System.out.println("\n"+name + " Club has been registered successfully!\n");
                System.out.println("Total Clubs Registered So far :" + mainClub.size());
            }

    }


    //deleting the clubs
    @Override
    public void deleteclub(String name) {
        //creating the for loop to check whether the array is empty
        if (mainClub.isEmpty()) {
            System.out.println("There Are no Clubs Added ,Add Clubs!");
        } else {
            //Comfirmation Message
            for (FootballClub footballClub : mainClub) {
                if (footballClub.getClubName().equals(name)) {
                    mainClub.remove(footballClub);
                    System.out.println("The club "+name+" Removed Successfully!");
                    System.out.println("Remaining Clubs Registered So far :" + mainClub.size());
                    return;

                }
            }
            System.out.println("The Club Doesn't Exist");
        }


    }

    //adding match statics
    @Override
    public void addMatch(Date1 date,FootballClub club1,int club1Goals,FootballClub club2,int club2Goals,String location) {
        //Adding the inputs from the user to the Array lists

        MatchDetails match = new MatchDetails(date,club1,club1Goals,club2,club2Goals,location);
        match.setKickOffDay(date);
        match.setClub1(club1);
        match.setClub2(club2);
        match.setClub1Score(club1Goals);
        match.setClub2Goals(club2Goals);
        matchesData.add(match);
        club1.setNumberOfGoalsScored(club1.getNumberOfGoalsScored()+ club1Goals);
        club2.setNumberOfGoalsScored(club2.getNumberOfGoalsScored()+club2Goals);
        club1.setNumberOfGoalsReceived(club1.getNumberOfGoalsReceived()+club2Goals);
        club2.setNumberOfGoalsReceived(club2.getNumberOfGoalsReceived()+ club1Goals);
        club1.setMatchesPlayed(club1.getMatchesPlayed()+1);
        club2.setMatchesPlayed(club2.getMatchesPlayed()+1);
        //calculations for the points
        if (club1Goals > club2Goals) {
            club1.setPoints(club1.getPoints()+3);
            club2.setPoints(club1.getPoints()+1);
            club1.setWins(club1.getWins()+1);
            club2.setDefeats(club2.getDefeats()+1);
        }


        else if (club1Goals < club2Goals) {
            club2.setPoints(club2.getPoints()+3);
            club1.setPoints(club1.getPoints()+1);
            club2.setWins(club2.getWins()+1);
            club1.setDefeats(club1.getDefeats()+1);
        }
        else {
            club1.setPoints(club1.getPoints()+1);
            club2.setPoints(club2.getPoints()+1);
            club1.setDraws(club1.getDraws()+1);
            club2.setDraws(club2.getDraws()+1);

        }

    }


    //printing the tables
    @Override
    public void printTable() {
        //Sorting the array

        mainClub.sort(new SortingPoints());

        //printing the table
        System.out.println("                                                     Statistics");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n","CLub Name","Location","Matches Played","Wins","Defeats","Draws","Goals Received","Goals Scored","Points");
        for (FootballClub club : mainClub){
            System.out.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n",club.getClubName(),club.getLocation(),club.getMatchesPlayed(),club.getWins(),club.getDefeats(),club.getDraws(),club.getNumberOfGoalsReceived(),club.getNumberOfGoalsScored(),club.getPoints());
        }

    }

    //printing the stats of a single clubs
    @Override
    public void stats(String name) {
        //Sorting the array
        mainClub.sort(new SortingPoints());
        //creating the for loop to check whether the array is empty
        if (mainClub.isEmpty()) {
            System.out.println("There Are no Clubs Added ,Add Clubs!");
        } else {
            for (FootballClub club : mainClub) {
                if (club.getClubName().equals(name)) {
                    System.out.println("                                                     Statistics");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n","CLub Name","Location","Matches Played","Wins","Defeats","Draws","Goals Received","Goals Scored","Points");
                    System.out.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n",club.getClubName(),club.getLocation(),club.getMatchesPlayed(),club.getWins(),club.getDefeats(),club.getDraws(),club.getNumberOfGoalsReceived(),club.getNumberOfGoalsScored(),club.getPoints());
                    return;
                }

            }
            System.out.println("The Club Doesn't Exist");
        }



    }


    @Override
    public void save() throws FileNotFoundException {

        File file = new File("datafile.txt");
        PrintWriter writer = new PrintWriter("datafile.txt");

        writer.write("                                                     Statistics\n");
        writer.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n","CLub Name","Location","Matches Played","Wins","Defeats","Draws","Goals Received","Goals Scored","Points");

        for (FootballClub club : mainClub) {
            writer.format("%-15s %-15s %-20s %-10s %-10s %-10s  %-20s %-20s %-10s %n",club.getClubName(),club.getLocation(),club.getMatchesPlayed(),club.getWins(),club.getDefeats(),club.getDraws(),club.getNumberOfGoalsReceived(),club.getNumberOfGoalsScored(),club.getPoints());
        }
        writer.close();

        File file2 = new File("matchFile.txt");
        PrintWriter writer2 = new PrintWriter("matchFile.txt");

        writer2.write("                                                     Statistics\n");
        writer2.format("%-15s %-15s %-20s %-10s %-10s %-10s %n","Date1","Club 1","Club 2","Club 1 Goals","Club 2 Goals","location");

        for (MatchDetails match : matchesData) {
            writer2.format("%-15s %-15s %-20s %-10s %-10s %-10s %n",match.getKickOffDay(),match.getClub1(),match.getClub2(),match.getClub1Goals(),match.getClub2Goals(),match.getLocation());
        }
        writer2.close();


        try {
            ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("PremierLeagueData.bin"));
            for (FootballClub footballClub : mainClub) {
                saveFile.writeObject(footballClub);
            }
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("matchData.bin"));
            for (MatchDetails match : matchesData) {
                saveFile.writeObject(match);
            }
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void loadData() {
        File data = new File("PremierLeagueData.bin");
        if (data.exists()) {
            try {
                ObjectInputStream readData = new ObjectInputStream(new FileInputStream("PremierLeagueData.bin"));
                while (true) {
                    Object temp;

                    try {
                        temp = readData.readObject();
                        if (temp != null) {
                            mainClub.add((FootballClub) temp);
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        File matchData = new File("matchData.bin");
        if (matchData.exists()) {
            try {
                ObjectInputStream readData2 = new ObjectInputStream(new FileInputStream("matchData.bin"));
                while (true) {
                    Object temp2;

                    try {
                        temp2 = readData2.readObject();
                        if (temp2 != null) {
                            matchesData.add((MatchDetails) temp2);
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getNameList() {
        for( FootballClub club: mainClub){
            System.out.println(club.getClubName());
        }
    }

    public ArrayList<FootballClub> getMainClub() {
        return mainClub;
    }

    public void setMainClub(ArrayList<FootballClub> mainClub) {
        this.mainClub = mainClub;
    }

    public ArrayList<MatchDetails> getMatchesData() {
        return matchesData;
    }

    public void setMatchesData(ArrayList<MatchDetails> matchesData) {
        this.matchesData = matchesData;
    }
}



