import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {


        //creating the scanner
        Scanner sc = new Scanner(System.in);
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();

        //creating a while loop for the main menu

        try {
            while (true) {
                System.out.println("\n----------------------------------------------------------------");
                System.out.println("-----------------------Premiere League Manager------------------");
                System.out.println("----------------------------------------------------------------");
                System.out.println(
                        "Press 1 : to Add a new club\n" +
                                "press 2 : To Delete a Club\n" +
                                "press 3 : To Display Statistic\n" +
                                "press 4 : To Display Premier League Manager Table\n" +
                                "press 5 : To Add a new Match\n" +
                                "press 6 : To Write/Save in a file\n" +
                                "press 7 : To Open a Graphical User Interface\n" +
                                "press 8 : To Exit the Programme\n"

                );

                System.out.print("Enter your Choice : ");
                int choice = sc.nextInt();


                switch (choice) {
                    case 1:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("-----------------------Add a new Club-------------------------");
                        System.out.println("--------------------------------------------------------------");
                        try {
                            //Getting the inputs from the user for add a new club
                            System.out.print("Enter the Club Name :");
                            Scanner sc11 = new Scanner(System.in);
                            String name = sc11.nextLine();

                            System.out.print("Enter the club Location :");
                            Scanner sc1 = new Scanner(System.in);
                            String location = sc1.nextLine();

                            System.out.print("Enter the Number of wins:");
                            Scanner sc2 = new Scanner(System.in);
                            int wins = sc2.nextInt();

                            System.out.print("Enter the Number of Defeats:");
                            Scanner sc3 = new Scanner(System.in);
                            int defeats = sc3.nextInt();

                            System.out.print("Enter the Number of Draws:");
                            Scanner sc8 = new Scanner(System.in);
                            int draws = sc8.nextInt();

                            System.out.print("Enter the Number of Goals Received:");
                            Scanner sc4 = new Scanner(System.in);
                            int goalsReceived = sc4.nextInt();

                            System.out.print("Enter the Number of Goals Scored:");
                            Scanner sc5 = new Scanner(System.in);
                            int goalsScored = sc5.nextInt();

                            System.out.print("Enter the Number of Matches Played:");
                            Scanner sc6 = new Scanner(System.in);
                            int matchesPlayed = sc6.nextInt();
                            //Passing the values to the PML
                            premierLeagueManager.addclub(name, location, wins, defeats, draws, goalsReceived, goalsScored, matchesPlayed);
                            premierLeagueManager.save();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Please Enter Valid Input!\n");
                            break;
                        }


                    case 2:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("--------------------Delete an Existing Club-------------------");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Select the Club You want to Delete");
                        System.out.println("---------------------------------------------");
                        premierLeagueManager.getNameList();

                        //Getting the values from the user
                        System.out.print("Enter the Club Name that you want to delete :");

                        Scanner sc7 = new Scanner(System.in);
                        String toDelete = sc7.nextLine();
                        premierLeagueManager.deleteclub(toDelete);
                        premierLeagueManager.save();
                        break;
                    case 3:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("--------------------Display Club Stats------------------------");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Select the Club You want to Display Statistics");

                        premierLeagueManager.getNameList();

                        //Getting the values from the user
                        System.out.print("Enter the Club Name :");
                        Scanner scanner = new Scanner(System.in);
                        String clubName = scanner.nextLine();
                        premierLeagueManager.stats(clubName);
                        break;
                    case 4:
                        premierLeagueManager.printTable();
                        break;
                    case 5:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("-----------------------Add a new match-----------------------");
                        System.out.println("--------------------------------------------------------------");
                        try {
                            System.out.print("Enter day : ");
                            Scanner sc10 = new Scanner(System.in);
                            int day = sc10.nextInt();
                            System.out.print("Enter month : ");
                            int month = sc10.nextInt();
                            System.out.print("Enter year : ");
                            int year = sc10.nextInt();
                            Date1 datetemp =new Date1(day,month,year);
                            System.out.println("Enter First Team : ");
                            Scanner sc11 = new Scanner(System.in);
                            String input = sc11.nextLine();
                            FootballClub club1 = null;
                            for(FootballClub club : premierLeagueManager.getMainClub()){
                                if(club.getClubName().equals(input))
                                    club1 = club;
                            }
                            if (club1 == null) {
                                System.out.println("The club you entered does not Exsist!");
                                return;
                            }
                            System.out.print("Enter Second Team : ");
                            Scanner sc12 = new Scanner(System.in);
                            input = sc12.nextLine();
                            FootballClub club2 = null;
                            for(FootballClub club : premierLeagueManager.getMainClub()){
                                if(club.getClubName().equals(input))
                                    club2= club;
                            }
                            if (club2 == null) {
                                System.out.print("The club you entered does not Exist!");
                                return;
                            }

                            System.out.print("Enter First team Number of goals Scored: ");
                            Scanner sc13 = new Scanner(System.in);
                            input = sc13.nextLine();
                            int club1Goals = -1;
                            try {
                                club1Goals = Integer.parseInt(input);
                            } catch (Exception e) {
                            }
                            if (club1Goals == -1) {
                                System.out.print("You have to enter number of goals");
                                return;
                            }

                            System.out.print("Enter Second team Number of goals Scored: ");
                            Scanner sc14 = new Scanner(System.in);
                            input = sc14.nextLine();
                            int club2Goals = -1;
                            try {
                                club2Goals = Integer.parseInt(input);
                            } catch (Exception e) {
                            }
                            if (club2Goals == -1) {
                                System.out.println("You have to enter number of goals");
                                return;
                            }

                            System.out.print("Enter the Match Played Location :");
                            Scanner sc15 = new Scanner(System.in);
                            String location = sc15.nextLine();

                            premierLeagueManager.addMatch(datetemp,club1,club1Goals,club2,club2Goals,location);
                        }catch (InputMismatchException e){
                            System.out.println("wrong input");
                        }
                        System.out.println("\nMatch Added Successfully!");
                        premierLeagueManager.save();
                        break;
                    case 6:
                        premierLeagueManager.save();
                        System.out.println("File write Successful!");
                        break;
                    case 7:
                        Application.launch();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            }
        } catch (InputMismatchException | FileNotFoundException e) {
            System.out.println("Please enter a Valid Input");
        }


    }

    //launching th GUI
    @Override
    public void start(Stage primaryStage) throws Exception {
        Gui.display();

    }



}