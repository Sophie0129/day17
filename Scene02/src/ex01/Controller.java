package ex01;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Controller {
	@FXML public TextField tf; // 텍스트 필드 객체 만들기 < 메소드 밖에 위치
	@FXML public TextField tf02;
	public void btnFunc() {
		System.out.println("버튼 클릭");
		System.out.println("tf : "+tf);
		//System.out.println(tf.getText());
		//tf.setText("");
		String msg = tf02.getText();
		tf.setText(msg);
		
		Alert alert = new Alert(AlertType.INFORMATION);//이미지
		alert.setTitle("alert 창 입니다");
		alert.setHeaderText("머릿글");
		alert.setContentText("문제 발생");
		alert.show();
	}
}
