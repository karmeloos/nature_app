package cells;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.NatureObservation;

public class NatureObservationListCell extends ListCell<NatureObservation> {
    private HBox content;
    private Label name_label;
    private Label description_label;
    private Label category_name;
    private Label localisation_name;
    private ImageView photo_view;

    public NatureObservationListCell(){
        super();
        name_label = new Label();
        description_label = new Label();
        category_name = new Label();
        localisation_name = new Label();
        photo_view = new ImageView();

        photo_view.setFitWidth(100);
        photo_view.setFitHeight(100);
        photo_view.setPreserveRatio(true);

        content = new HBox(
                photo_view,
                name_label,
                category_name,
                localisation_name,
                description_label);
        content.setSpacing(20);
    }

    @Override
    protected void updateItem(NatureObservation item, boolean empty) {
        super.updateItem(item, empty);
        if(item != null && !empty){
            if (item.getName() != null) {
                name_label.setText(item.getName());
            }
            if (item.getDescription() != null) {
                description_label.setText(item.getDescription());
            }

            if (item.getCategory() != null) {
                category_name.setText(item.getCategory().getName());
            }

            if (item.getLocalisation() != null) {
                localisation_name.setText(item.getLocalisation().getName());
            }

            if (item.getPhoto() != null) {
                photo_view.setImage(item.getPhoto().getImage());
            }

            setGraphic(content);
        } else {
            setGraphic(null);
        }
    }
}
