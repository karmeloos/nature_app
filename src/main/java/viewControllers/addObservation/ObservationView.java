package viewControllers.addObservation;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import mvc.View;

public class ObservationView extends View {
    Label name_app_label = new Label("Dodaj nową obserwację");
    Label name_label = new Label("Wpisz nazwę obserwacji:");
    TextField name_observation = new TextField();
    Label category_label = new Label("Wybierz kategorię");
    ComboBox combobox_category = new ComboBox();
    Label localisation_label = new Label("Wybierz lokalizację");
    ComboBox combobox_localisation = new ComboBox();
    Label description_label = new Label("Wpisz opis obserwacji:");
    TextArea description_textArea = new TextArea();
    Button photo_button = new Button("Wybierz zdjęcie");
    Button save_button = new Button("Zapisz");
    Button back_button = new Button("Wstecz");

    ImageView imageView = new ImageView();

    public ObservationView() {
        name_app_label.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.EXTRA_BOLD, 25));
        name_observation.setMaxWidth(200);
        description_textArea.setMaxWidth(200);
        description_textArea.setMaxHeight(50);

        VBox center = new VBox(
                name_app_label,
                name_label,
                name_observation,
                description_label,
                description_textArea,
                category_label,
                combobox_category,
                localisation_label,
                combobox_localisation,
                photo_button,
                imageView,
                save_button,
                back_button);

        imageView.setFitHeight(200);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        layout = center;
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
    }
}
