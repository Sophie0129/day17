package common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


//많이 공통되는 내용을 따로 모아놓아 편리하게 쓸 수 있다.

public interface CommonService { //인터페이스에는 추상화가 들어와야함. 일반 메소드는 못들어옴. static으로 들어올수 있다
	public static void myAlert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);;
		alert.show();
	}
public static void cancelFunc(Parent root) {
	Stage stage = (Stage)root.getScene().getWindow();
	stage.close();
}
}
