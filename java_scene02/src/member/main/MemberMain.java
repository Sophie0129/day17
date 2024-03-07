package member.main;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.url.URLService;
import member.controller.MemberController;

public class MemberMain{
public void viewFx() {
	Stage memberStage = new Stage(); //해당 버튼을 눌렀을때 창이 2개가 된다.
	Parent root = null;
	try {
		URL url = new URL(URLService.fxPath + "member/fxml/member.fxml"); //fxpath : 현재 프로젝트 위치 + member...
		FXMLLoader loader = new FXMLLoader(url);
		root = loader.load();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	Scene sc = new Scene(root);
	memberStage.setScene(sc);;
	memberStage.show();
}
public void viewFx(Parent root) {
	Stage memberStage = (Stage)root.getScene().getWindow(); //이렇게 스테이지 객체를 만들면 한개의 창에서 내용이 바뀐다. Scene을 바꾼다.
	//Parent root = null;
	try {
		URL url = new URL(URLService.fxPath + "member/fxml/member.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		root = loader.load();
		
		MemberController ctrl = loader.getController();
		ctrl.setRoot(root);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	Scene sc = new Scene(root);
	memberStage.setScene(sc);;
	memberStage.show();
}

}
