package member.main;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.url.URLService;
import member.controller.MemberController;

public class MemberMain {
	public void viewFx() {
		Stage memberStage = new Stage();
		Parent root = null;
		try {
			//fxPath : 현재 프로젝트 위치 + member...
			URL url = new URL( URLService.fxPath + "member/fxml/member.fxml" );
			FXMLLoader loader = new FXMLLoader( url );
			root = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		memberStage.setScene(scene);
		memberStage.show();
	}
	public void viewFx( Parent root ) {
		Stage memberStage = (Stage)root.getScene().getWindow();
		//Parent root = null;
		try {
			//fxPath : 현재 프로젝트 위치 + member...
			URL url = new URL( URLService.fxPath + "member/fxml/member.fxml" );
			FXMLLoader loader = new FXMLLoader( url );
			root = loader.load();
			
			MemberController ctrl = loader.getController();
			ctrl.setRoot( root );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		memberStage.setScene(scene);
		memberStage.show();
	}
}





