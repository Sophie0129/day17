package login.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import login.service.LoginSercive;
import login.service.LoginSerciveImpl;
//컨트롤러는 연결만을 위한 틀래스로 사용하는걸 권장
public class Controller implements Initializable { //initializable > 초기화
	@FXML public TextField fxid; //골뱅이부분 어노테이션 이용 객체 생성
	@FXML public TextField fxpwd;
	Parent root;
	
	LoginSercive ls;
	
	public void setRoot(Parent root) {
		this.root = root;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginSerciveImpl();
		System.out.println("초기화 메소드");
		
	
	}
	public void loginFunc() {
		ls.loginFunc(fxid, fxpwd);
		System.out.println("확인 버튼 클릭");
		

	}
	public void cancelFunc() {
		System.out.println("취소 버튼 클릭");
		System.out.println("root : "+root);
		ls.cancelFunc(root);
	

	}
	public void registerFunc() {
		System.out.println("회원가입 클릭");
		//ls.registerFunc();
		ls.registerFunc(root);
	}

}

