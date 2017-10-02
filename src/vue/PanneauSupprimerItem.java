package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import modele.DeclarationDAO;

import java.sql.*;

public class PanneauSupprimerItem extends Region {

    private int id;

    public PanneauSupprimerItem(int id) {
        super();
        construirePanneau();
        this.id = id;
    }

    private void construirePanneau()
    {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label labelTitreSupprimerItem = new Label("Supprimer la marchandise sélectionnée ?");

        Button btnActionRetourEnArriere = new Button("Annuler");
        btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnActionSupprimer = new Button("Supprimer");
        btnActionSupprimer.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    DeclarationDAO.getInstance().supprimerDeclaration(id);
                    Controleur.getInstance().actionRetourEnArriere();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        grid.add(labelTitreSupprimerItem, 0, 0);
        grid.add(btnActionRetourEnArriere, 0, 1);
        grid.add(btnActionSupprimer, 2, 1);

        this.getChildren().add(grid);
    }
}