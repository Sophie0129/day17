package ex01;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Controller {
	@FXML public TextField tf;
	@FXML public TextField tf02;
	public void btnFunc() {
		System.out.println("버튼 클릭~");
		System.out.println("tf : "+tf);
		//System.out.println( tf.getText() );
		//tf.setText("");
		String msg = tf02.getText();
		tf.setText( msg );
		
		Alert alert = new Alert( AlertType.ERROR );
		alert.setTitle("alert 창 입니다");
		alert.setHeaderText("머릿글");
		alert.setContentText("문제가 발생했습니다");
		alert.show();
	}
}









