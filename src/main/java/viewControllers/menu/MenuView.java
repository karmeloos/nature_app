package viewControllers.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import mvc.View;

public class MenuView extends View {
    Label name_app_label = new Label("Nature app");
    Button view_button = new Button("Wyświetl obserwacje");
    Button add_observation_button = new Button("Dodaj obserwację");
    Button add_category_button = new Button("Dodaj kategorię");
    Button add_localization_button = new Button("Dodaj lokalizację");

    public MenuView() {
        name_app_label.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.EXTRA_BOLD, 25));

        VBox center = new VBox(
                name_app_label,
                view_button,
                add_observation_button,
                add_category_button,
                add_localization_button);
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        layout = center;
    }
}
