package seedu.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import seedu.address.model.Person;
import seedu.address.view.PersonOverviewController;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage = null;
    private BorderPane rootLayout = null;

    /**
     * An observable list of {@link Person}.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Adds some sample data to {@link #personData}.
     */
    public MainApp() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Keller"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Danna"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        // Shows the general window frame.
        initRootLayout();
        // Shows the person overview panel.
        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    private void initRootLayout() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

        try {
            rootLayout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    /**
     * Shows the person overview inside the root layout.
     */
    private void showPersonOverview() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));

        AnchorPane overview = null;
        try {
            overview = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        rootLayout.setCenter(overview);

        // Give the controller access to the mainApp class.
        PersonOverviewController controller = loader.getController();
        controller.setMainApp(this);
    }

    /**
     * @return the main stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @return an observableList of all person data.
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
}
