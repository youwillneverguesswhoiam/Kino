package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class TabelaFilmowa implements HierarchicalController<MainController> {

    public TextField nazwa;
    public TextField opis;
    public TextField czas;
    public TextField limit;
    public TableView<Film> tabelka;
    private MainController parentController;

    public void dodaj(ActionEvent actionEvent) {
        Film film = new Film();
        film.setNazwa(nazwa.getText());
        film.setOpis(opis.getText());
        film.setCzas(czas.getText());
        film.setLimit(limit.getText());
        tabelka.getItems().add(film);

    }

    public void setParentController(MainController parentController) {
        this.parentController = parentController;
        //tabelka.getItems().addAll(parentController.getDataContainer().getStudents());
        tabelka.setItems(parentController.getDataContainer().getFilmy());
    }

    public void usunZmiany() {
        tabelka.getItems().clear();
        tabelka.getItems().addAll(parentController.getDataContainer().getFilmy());
    }

    public MainController getParentController() {
        return parentController;
    }

    public void initialize() {
        for (TableColumn<Film, ?> studentTableColumn : tabelka.getColumns()) {
            if ("nnazwa".equals(studentTableColumn.getId())) {

                studentTableColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            } else if ("opis".equals(studentTableColumn.getId())) {
                studentTableColumn.setCellValueFactory(new PropertyValueFactory<>("opis"));
            } else if ("czas".equals(studentTableColumn.getId())) {
                studentTableColumn.setCellValueFactory(new PropertyValueFactory<>("czas"));
            } else if ("limit".equals(studentTableColumn.getId())) {
                studentTableColumn.setCellValueFactory(new PropertyValueFactory<>("limit"));
            }
        }

    }

    public void zapisz(ActionEvent actionEvent) {
        ArrayList<Film> listaFilmowa = new ArrayList<>(tabelka.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            oos.writeObject(listaFilmowa);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Uwaga na serializację: https://sekurak.pl/java-vs-deserializacja-niezaufanych-danych-i-zdalne-wykonanie-kodu-czesc-i/ */
    public void wczytaj(ActionEvent actionEvent) {
        ArrayList<Film> listaFilmowa;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.obj"))) {
            listaFilmowa = (ArrayList<Film>) ois.readObject();
            tabelka.getItems().clear();
            tabelka.getItems().addAll(listaFilmowa);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
