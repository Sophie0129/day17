package member.service;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberServiceImpl implements MemberService{
	ComboBox<String> cmbAge;
	TextField fxName, fxId;
	PasswordField fxPwd, fxPwdChk;
	CheckBox chkMusic, chkMovie, chkMung;
	RadioButton rdoWoman;
	
	//fxml에 연결된건 특정 클래스이기 때문에 여기서는 사용할 수 없어서 @FXML public  쓸 필요가 없다
	
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void registerFunc() {
		
		cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		fxPwdChk = (PasswordField)root.lookup("#fxPwdChk");
		
		chkMusic = (CheckBox)root.lookup("#chkMusic");
		chkMovie = (CheckBox)root.lookup("#chkMovie");
		chkMung = (CheckBox)root.lookup("#chkMung");

		rdoWoman = (RadioButton)root.lookup("#rdoWoman");
		
		System.out.println(cmbAge.getValue());
		if(cmbAge.getValue() == null ) {
			System.out.println("콤보박스를 선택하세요");
			cmbAge.requestFocus();
		}else if(fxId.getText().isEmpty()) {
			System.out.println("아이디를 입력하세요");
			fxId.requestFocus();
		}
		System.out.println("id : "+fxId.getText());
		System.out.println("name : "+fxName.getText());
		System.out.println("pwd : "+fxPwd.getText());
		System.out.println("pwd chk : "+fxPwdChk.getText());

		System.out.println("chkMusic : "+chkMusic.getText());
		System.out.println("chkMovie : "+chkMovie.getText());
		System.out.println("chkMung : "+chkMung.getText());
		
		//둘중 하나는 선택되어야 한다. //woman이 선택되면 true, 아니면 false //false가 나오면 man이 선택되었다고 판단

		System.out.println("rdoWoman : "+rdoWoman.isSelected());
	}

	@Override
	public void cancelFunc() {
		Stage st = (Stage)root.getScene().getWindow();
		st.close();
		
	}

}
