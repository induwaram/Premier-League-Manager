
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Gui {
    public static void display() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
        Stage stage = new Stage();
        Scene scene;
        stage.setTitle("Club Members");

        //creating the Pane for the GUI
        AnchorPane grid = new AnchorPane();
        //Creating Tables
        TableView<FootballClub> mainTable = new TableView<>();
        mainTable.setLayoutX(20);
        mainTable.setLayoutY(60);
        mainTable.setPrefSize(710, 400);

        TableView<MatchDetails> matchTable = new TableView<>();
        matchTable.setLayoutX(750);
        matchTable.setLayoutY(60);
        matchTable.setPrefSize(480, 400);



        int count = premierLeagueManager.getMainClub().size();

        //Creating A labels

        Label lblmainTable = new Label("Club Detail table");
        lblmainTable.getStyleClass().add("label-bold");
        lblmainTable.setLayoutX(280);
        lblmainTable.setLayoutY(30);

        Label lblMatchTable = new Label("Match Detail table");
        lblMatchTable.getStyleClass().add("label-bold");
        lblMatchTable.setLayoutX(940);
        lblMatchTable.setLayoutY(30);

        Label slots = new Label("Total Number of Clubs Registered : " + count);
        slots.setLayoutX(0);
        slots.setLayoutY(0);
        slots.setStyle("-fx-font-weight: 200; -fx-font-size: 20;-fx-text-fill: white");

        //creating the buttons
        Button showall = new Button("Show All");
        showall.setLayoutX(580);
        showall.setLayoutY(520);
        Button search = new Button("Search");
        search.setLayoutX(430);
        search.setLayoutY(520);
        Button search2 = new Button("Search");
        search2.setLayoutX(1080);
        search2.setLayoutY(520);
        Button goalsScored = new Button("Sort :Goals Scored");
        goalsScored.setLayoutX(270);
        goalsScored.setLayoutY(520);
        goalsScored.setStyle("-fx-font-size: 15; -fx-max-width: 160px;-fx-min-width: 160px");
        Button pointSort = new Button("Sort :Points");
        pointSort.setLayoutX(120);
        pointSort.setLayoutY(520);
        Button generate = new Button("Generate A Match");
        generate.setLayoutX(920);
        generate.setLayoutY(520);

//        Button delete = new Button("delete");
//        search.setLayoutX(200);
//        search.setLayoutY(20);

        //creating the text Fields
        TextField txtsearch = new TextField();
        txtsearch.setLayoutX(130);
        txtsearch.setLayoutY(480);
        txtsearch.setPromptText("Enter your Club Name");

        TextField txtday = new TextField();
        txtday.setLayoutX(930);
        txtday.setLayoutY(480);
        txtday.getStyleClass().addAll("daytxt");
        txtday.setPromptText("Day");


        TextField txtmonth = new TextField();
        txtmonth.setLayoutX(1030);
        txtmonth.setLayoutY(480);
        txtmonth.getStyleClass().addAll("daytxt");
        txtmonth.setPromptText("Month");


        TextField txtyear = new TextField();
        txtyear.setLayoutX(1130);
        txtyear.setLayoutY(480);
        txtyear.getStyleClass().addAll("daytxt");
        txtyear.setPromptText("Year");


        grid.getChildren().addAll(txtsearch, showall, generate,search,txtday,goalsScored,pointSort,txtmonth,txtyear, mainTable,search2,slots,matchTable,lblmainTable,lblMatchTable);

        //columns for Main table
        TableColumn<FootballClub, String> colName = new TableColumn<>("Club Name");
        colName.setMinWidth(100);
        colName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        TableColumn<FootballClub, String> colLocation = new TableColumn<>("Location");
        colLocation.setMinWidth(100);
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));


        TableColumn<FootballClub, String> colPlayed = new TableColumn<>("Matches Played");
        colPlayed.setMinWidth(40);
        colPlayed.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));

        TableColumn<FootballClub, String> colWins = new TableColumn<>("Wins");
        colWins.setMinWidth(40);
        colWins.setCellValueFactory(new PropertyValueFactory<>("wins"));


        TableColumn<FootballClub, String> colDefeats = new TableColumn<>("Defeats");
        colDefeats.setMinWidth(40);
        colDefeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));


        TableColumn<FootballClub, String> colDraws = new TableColumn<>("Draws");
        colDraws.setMinWidth(40);
        colDraws.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<FootballClub, String> colReceived = new TableColumn<>("Goals Received");
        colReceived.setMinWidth(40);
        colReceived.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        TableColumn<FootballClub, String> colScored = new TableColumn<>("Goals Scored");
        colScored.setMinWidth(40);
        colScored.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        TableColumn<FootballClub, String> colPoints = new TableColumn<>("Points");
        colPoints.setMinWidth(60);
        colPoints.setCellValueFactory(new PropertyValueFactory<>("points"));

        mainTable.setItems(mainTableDisplay());
        mainTable.getColumns().addAll(colName, colLocation, colPlayed, colWins, colDefeats, colDraws, colReceived, colScored, colPoints);


        //coloumns for the second table
        TableColumn<MatchDetails, String> coldate = new TableColumn<>("Date");
        coldate.setMaxWidth(130);
        coldate.setCellValueFactory(new PropertyValueFactory<>("kickOffDay"));

        TableColumn<MatchDetails, String> colclub1 = new TableColumn<>("Club 1");
        colclub1.setMinWidth(105);
        colclub1.setCellValueFactory(new PropertyValueFactory<>("club1"));

        TableColumn<MatchDetails, String> colClub2 = new TableColumn<>("Club 2 ");
        colClub2.setMinWidth(105);
        colClub2.setCellValueFactory(new PropertyValueFactory<>("club2"));

        TableColumn<MatchDetails, String> colClub1Goals = new TableColumn<>("Club 1 Goals");
        colClub1Goals.setMinWidth(20);
        colClub1Goals.setCellValueFactory(new PropertyValueFactory<>("club1Goals"));

        TableColumn<MatchDetails, String> colClub2Goals = new TableColumn<>("Club 2 Goals");
        colClub2Goals.setMinWidth(20);
        colClub2Goals.setCellValueFactory(new PropertyValueFactory<>("club2Goals"));

        TableColumn<MatchDetails, String> colPlayLocation = new TableColumn<>("Location");
        colPlayLocation.setMinWidth(30);
        colPlayLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        matchTable.setItems(matchTableDisplay());
        matchTableDisplay();
        matchTable.getColumns().addAll(coldate,colclub1,colClub2,colClub1Goals,colClub2Goals);

        //calling the button
        showall.setOnAction(e -> {
            mainTable.setItems(mainTableDisplay());
            txtsearch.setText("");
            matchTable.setItems(matchTableDisplay());
            matchTableDisplay();
        });
        search.setOnAction(e -> {
            mainTable.setItems(clubNameSearch(txtsearch));
            txtsearch.setText("");
        });
        search2.setOnAction(e->{
            matchTable.getItems().clear();
            matchTable.setItems(dateSearch(txtday,txtmonth,txtyear));
            txtday.setText("");
            txtmonth.setText("");
            txtyear.setText("");
        });
        pointSort.setOnAction(e->{
            mainTable.getItems().sort(new SortingPoints());
            mainTable.refresh();
        });
        goalsScored.setOnAction(e->{
            mainTable.getItems().sort(new SortingGoals());
            mainTable.refresh();
        });

        generate.setOnAction(e->{
            try {
                randomGenerate();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            matchTable.setItems(matchTableDisplay());
            matchTableDisplay();

            mainTable.setItems(mainTableDisplay());

        });
//        delete.setOnAction(e->{
//            clubNameDelete(txtsearch);
//            mainTable.setItems(tabledisplay());
//        });

        scene = new Scene(grid, 1250, 600);
        scene.getStylesheets().add(Gui.class.getResource("gui.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();


    }

    //
    public static ObservableList<MatchDetails> matchTableDisplay() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
//        Path filePath = Paths.get("./plm.ser");
//        if(Files.exists(filePath)){
//            plm = plm.getInstance();
//        }else {
//            plm = new PremierLeagueManager();
//        }
//        plm = plm.getInstance();
        ObservableList<MatchDetails> oblist = FXCollections.observableArrayList();
//        premierLeagueManager.sortTable();

        for (MatchDetails match : premierLeagueManager.getMatchesData()) {

            oblist.addAll(match);

        }

        return oblist;
    }

    public static ObservableList<FootballClub> mainTableDisplay() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
//        Path filePath = Paths.get("./plm.ser");
//        if(Files.exists(filePath)){
//            plm = plm.getInstance();
//        }else {
//            plm = new PremierLeagueManager();
//        }
//        plm = plm.getInstance();
        ObservableList<FootballClub> clubs = FXCollections.observableArrayList();
//        premierLeagueManager.sortTable();
        for (FootballClub club : premierLeagueManager.getMainClub()) {
            clubs.add(club);
        }

        return clubs;
    }

    public static ObservableList<FootballClub> clubNameSearch(TextField field) {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
        ObservableList<FootballClub> oblist = FXCollections.observableArrayList();


        String input = field.getText();

        for (FootballClub club : premierLeagueManager.getMainClub()) {
            if (club.getClubName().equals(input)) {
                oblist.add(club);
            }
        }
        if (oblist.isEmpty()){

            popUpBox("Club does not Exist!","Error!");


        }
        return oblist;
    }

    public static ObservableList<MatchDetails> dateSearch(TextField dayField,TextField monthField,TextField yearField) {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
        ObservableList<MatchDetails> oblist = FXCollections.observableArrayList();

        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        Date1 date = new Date1(day,month,year);
        String temp = date.toString();
        for (MatchDetails match : premierLeagueManager.getMatchesData()) {
            if (match.getKickOffDay().toString().equals(temp)){

                oblist.add(match);
            }
        }

        if (oblist.isEmpty()){
            popUpBox("Match does not Exist!","Error!");
        }
        return oblist;
    }
//    public static ObservableList<FootballClub> clubNameDelete(TextField field) {
//        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
//        premierLeagueManager.loadData();
//        ObservableList<FootballClub> oblist = FXCollections.observableArrayList();
//
//        String input = field.getText();
//
//        for (FootballClub footballClub : premierLeagueManager.getMainClub()) {
//            if (footballClub.getClubName().equals(input)) {
//                premierLeagueManager.getMainClub().remove(footballClub);
//                popUpBox("The club "+input+" Removed Successfully!","Successful!");
//
//            }
//        }
//        return oblist;
//    }

    public static void popUpBox(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public  static void randomGenerate() throws FileNotFoundException {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.loadData();
        Random random = new Random();

        int club1random = random.nextInt(premierLeagueManager.getMainClub().size());

        int club2random ;
        do {
            club2random = random.nextInt(4);
        }while (club2random == club1random);

        int randomNumber1Goals = random.nextInt(8);
        int randomNumber2Goals = random.nextInt(8);


//        while (true){
//            if (club1random != club2random){
//                break;
//            }
//        }


        FootballClub club1=premierLeagueManager.getMainClub().get(club1random);
        FootballClub club2=premierLeagueManager.getMainClub().get(club2random);


        int day = random.nextInt(30)+1;
        int month = random.nextInt(11)+1;
        int low = 2000;
        int high = 2025;
        int year = random.nextInt(high-low) + low;

        Date1 date = new Date1(day,month,year);



        premierLeagueManager.addMatch(date,club1,randomNumber1Goals,club2,randomNumber2Goals,null);
        premierLeagueManager.save();




    }
}
