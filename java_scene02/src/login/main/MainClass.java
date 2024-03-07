package login.main;

import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import login.controller.Controller;
import login.url.URLService;

public class MainClass extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		/*
		System.out.println(getClass().getResource(""));//기조방법은 같은 패키지 안에 있을때만 가능
		System.out.println(Paths.get("").toAbsolutePath().toString());//다른 패키지에 있을때는 기존 방법으로 불러올 수 없음 경로를 다른 방법으로 잡아준다.
		//위에는 프로젝트 불러오는거. 아래는 경로 불러오는거.
		System.out.println("file:/"+Paths.get("").toAbsolutePath().toString()+"/bin/login/fxml/Login.fxml");
		*/
		
		URL url = new URL(URLService.fxPath+"login/fxml/Login.fxml");
		FXMLLoader loader = new FXMLLoader(url);
		//fxml은 url으로만 받으려고 함, 문자로 넣으면 에러
		
		Parent root = loader.load(); //컨트롤러 만들어지는 시점
		
		Controller ctrl = loader.getController(); //z컨트롤러 클래스에 있는 객체 불러옴
		//Controller ctrl = new Controller; //이렇게 객체생성하면 안됌 (fxml에서 연결한 그 위치의 그 파일만 연동이 되는거라서 
		ctrl.setRoot(root);
		
		//스테이지 > 신 > 루트 불러오는건 반대로 했음
		
		Scene sc = new Scene(root);
		arg0.setScene(sc);
		
		arg0.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
