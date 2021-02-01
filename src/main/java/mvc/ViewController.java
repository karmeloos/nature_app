package mvc;

import javafx.scene.control.Alert;

public class ViewController {
    public View view;

    public NavigationViewController navigationViewController;

    public ViewController() {
    }

    public final void showAlert(String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(message);
        a.show();
    }

    public void loadView() { //funkcja jest odpowiedzialna na wczytywanie widoku
        view = new View();
    }
}