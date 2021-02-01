package viewControllers.showObservation;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.NatureObservation;
import mvc.View;

public class ShowView extends View {
    Label name_app_label = new Label("Lista obserwacji");
    Button back_button = new Button("Wstecz");
    ListView<NatureObservation> list = new ListView<NatureObservation>();

    public ShowView() {
        name_app_label.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.EXTRA_BOLD, 25));

        VBox center = new VBox(name_app_label, back_button, list);
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        layout = center;
    }
}
