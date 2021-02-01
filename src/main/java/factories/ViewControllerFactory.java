package factories;

import database.Database;
import viewControllers.addCategory.CategoryViewController;
import viewControllers.addLocation.LocationViewController;
import viewControllers.addObservation.ObservationViewController;
import viewControllers.menu.MenuViewController;
import viewControllers.showObservation.ShowViewController;
import facades.CategoryFacade;
import facades.LocalisationFacade;
import facades.NatureObservationFacade;
import mvc.ViewController;

public class ViewControllerFactory {
    Database database = new Database();

    CategoryFacade categoryFacade;
    LocalisationFacade localisationFacade;
    NatureObservationFacade natureObservationFacade;

    public ViewControllerFactory (){
        categoryFacade = new CategoryFacade(database);
        localisationFacade = new LocalisationFacade(database);
        natureObservationFacade = new NatureObservationFacade(database);
    }

    public ViewController makeCategoryViewController(){
        return new CategoryViewController(categoryFacade);
    }

    public ViewController makeLocationViewController(){
        return new LocationViewController(localisationFacade);
    }

    public ViewController makeObservationViewController(){
        return new ObservationViewController(natureObservationFacade, categoryFacade, localisationFacade);
    }

    public ViewController makeMenuViewController(){
        return new MenuViewController();
    }

    public ViewController makeShowViewController(){
        return new ShowViewController(natureObservationFacade);
    }
}
