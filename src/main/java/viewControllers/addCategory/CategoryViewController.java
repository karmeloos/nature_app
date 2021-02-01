package viewControllers.addCategory;

import facades.CategoryFacade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Category;
import mvc.ViewController;

public class CategoryViewController extends ViewController {

    private CategoryFacade categoryFacade;

    public CategoryViewController(CategoryFacade catFacade){
        categoryFacade = catFacade;
    }

    @Override
    public void loadView() {
        CategoryView categoryView = new CategoryView();
        categoryView.back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                navigationViewController.popViewController(); //
            }
        });

        categoryView.save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = categoryView.name_category.getText();

                if(name == null || name.isEmpty()){
                    showAlert("Nazwa kategorii nie może być pusta");
                    return;
                }
                categoryFacade.add(new Category(name));
            }
        });
        view = categoryView;
    }

}

