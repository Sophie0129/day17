package login.service;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.main.MemberMain;

public class LoginSerciveImpl implements LoginSercive {
	private LoginDAO dao;
	public LoginSerciveImpl() {
		dao = new LoginDAO();
	}

	@Override
	public void loginFunc(TextField fxid, TextField fxpwd) {
		System.out.println("--- 서비스 로그인 ---");
		System.out.println("id : "+fxid.getText());
		System.out.println("pwd : "+fxpwd.getText());
		//LoginDTO dto = LoginDAO.db.get(fxid.getText());

		LoginDTO dto = dao.getUser(fxid.getText());

		System.out.println("dto : "+dto);
		String msg = null;

		//Alert alert = new Alert(AlertType.INFORMATION);	

		if(dto !=null) {
			if(dto.getPwd().equals(fxpwd.getText())) {//if문 뒤에 ;세미콜론으로 종료시켜버리면 if문이 무조건 실행된다.
				msg = dto.getName() + "님 인증성공";
			}else {
				msg = "비밀번호가 틀렸습니다";
			}
		}else {
			msg = "존재하지 않는 아이디입니다";
		}//시작 if문의 조건문을...잘 보자........
		//시작에서 애초에 값이 있을때에 비밀번호를 확인하러 들어가는데, 자바 dto는 실행 될때마다 계속 초기화 되는 상태이고, 값이 없다는건 등록된 아이디가 없다는것.
		//근데..?sql에 값이 있는건 어떻게 알지...? 위에 dao.getUser를 불러 실행하는데 그 안에 sql값을 불러오는 식이 있다.

		//alert.setContentText(msg); alert.show();
		CommonService.myAlert(msg);
		System.out.println(msg);
	}

	@Override
	public void cancelFunc(Parent root) {
		System.out.println("--- 서비스 창 닫기 ---");
		//Stage stage = (Stage)root.getScene().getWindow();
		//stage.close();
		CommonService.cancelFunc(root);
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
