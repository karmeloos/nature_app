package viewControllers.addCategory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import mvc.View;

public class CategoryView extends View {
    Label name_app_label = new Label("Dodaj nową kategorie");
    Label name_label = new Label("Wpisz nazwę kategorii:");
    TextField name_category = new TextField();
    Button save_button = new Button("Zapisz");
    Button back_button = new Button("Wstecz");

    public CategoryView() {
        name_app_label.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.EXTRA_BOLD, 25));
        name_category.setMaxWidth(200);

        VBox center = new VBox(
                name_app_label,
                name_label,
                name_category,
                save_button,
                back_button);
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        layout = center;
    }
}
