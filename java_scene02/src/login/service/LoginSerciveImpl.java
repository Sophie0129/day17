package login.service;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.main.MemberMain;

public class LoginSerciveImpl implements LoginSercive {

	@Override
	public void loginFunc(TextField fxid, TextField fxpwd) {
		System.out.println("--- 서비스 로그인 ---");
		System.out.println("id : "+fxid.getText());
		System.out.println("pwd : "+fxpwd.getText());
		LoginDTO dto = LoginDAO.db.get(fxid.getText());
		System.out.println("dto : "+dto);

		String msg = null;

		Alert alert = new Alert(AlertType.INFORMATION);	

		if(dto !=null) {
			if(dto.getPwd().equals(fxpwd.getText()));
			msg = dto.getName() + "님 인증성공";
		}else {
			msg = "존재하지 않는 아이디입니다";
		}

		alert.setContentText(msg); alert.show();
		System.out.println(msg);
	}

	@Override
	public void cancelFunc(Parent root) {
		System.out.println("--- 서비스 창 닫기 ---");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void registerFunc() {
		System.out.println("--- 서비스 회원가입 ---");
		MemberMain member = new MemberMain();
		member.viewFx();
	}
		
		public void registerFunc(Parent root) {
			System.out.println("--- 서비스 회원가입 ---");
			MemberMain member = new MemberMain();
			member.viewFx(root);
			
	}

}
