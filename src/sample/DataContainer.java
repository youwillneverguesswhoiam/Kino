package sample;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by pwilkin on 30-Nov-17.
 */
public class DataContainer {

    protected ObservableList<Film> filmy;

    public ObservableList<Film> getFilmy() {
        return filmy;
    }

    public void setFilmy(List<Film> filmy) {
        this.filmy = FXCollections.observableArrayList(filmy);
    }

    public DataContainer() {
        filmy = FXCollections.observableArrayList();
    }
}
