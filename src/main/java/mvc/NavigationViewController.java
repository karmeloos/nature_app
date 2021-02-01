package mvc;

import factories.ViewControllerFactory;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;

public class NavigationViewController {
    public ViewControllerFactory viewControllerFactory;

    private ArrayList<Scene> sceneArrayList = new ArrayList<Scene>();

    private Stage stage;

    public NavigationViewController(ViewController rootViewController, Stage stage, ViewControllerFactory vcfactory) {
        this.stage = stage;
        pushViewController(rootViewController);
        viewControllerFactory = vcfactory;
    }

    public void presentImageChooser(Consumer<File> callback){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Filters", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null){
            callback.accept(selectedFile);
        }
    }

    public void pushViewController(ViewController viewController) {
        viewController.navigationViewController = this;
        viewController.loadView();
        Scene scene = createSceneFromViewController(viewController);
        sceneArrayList.add(scene);

        setSceneInStage(scene, stage);
    }

    public void popViewController(){
        sceneArrayList.remove(sceneArrayList.size() - 1);
        Scene scene = sceneArrayList.get(sceneArrayList.size() - 1);
        setSceneInStage(scene, stage);
    }

    private Scene createSceneFromViewController(ViewController viewController) {
        return new Scene(viewController.view.layout,1024, 768);
    }

    private void setSceneInStage(Scene scene, Stage stage) { //ustawienie sceny do okna widoku dla uzytkownika
        stage.setScene(scene);
    }
}