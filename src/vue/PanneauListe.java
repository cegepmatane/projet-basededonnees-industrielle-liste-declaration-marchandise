package vue;


import java.sql.SQLException;
import java.util.List;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import modele.Declaration;

public class PanneauListe extends Region
{
	private ListView<PanneauItemListe> panneauListeItem;
	private List<Declaration> list;
	
	public PanneauListe(List<Declaration> list)
	{
		super();
		this.list = list;
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setPrefSize(400, (600-30));
		
		Button btnActionAjouterItem = new Button("Ajouter");
		btnActionAjouterItem.setPrefSize(200, 15);
		btnActionAjouterItem.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				try {
					Controleur.getInstance().actionAjouterItem();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		vBox.getChildren().add(btnActionAjouterItem);
		
		panneauListeItem = new ListView<PanneauItemListe>();
		panneauListeItem.setPrefSize(400, 600 - 30);
		construireVueListeItem(list);
		
		
		vBox.getChildren().add(panneauListeItem);
		this.getChildren().add(vBox);
	}
	
	private void construireVueListeItem(List<Declaration> list)
	{
		
		for(Declaration declaration : list)
		{
			panneauListeItem.getItems().add(new PanneauItemListe(declaration));
		}

	}
	
	
}
