package member.service;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberServiceImpl implements MemberService{
	ComboBox<String> cmbAge;
	TextField fxName, fxId;
	PasswordField fxPwd, fxPwdChk;
	CheckBox chkMusic, chkMovie, chkMung;
	RadioButton rdoWoman;
	
	//fxml에 연결된건 특정 클래스이기 때문에 여기서는 사용할 수 없어서 @FXML public  쓸 필요가 없다
	
	MemberDAO dao;
	
	Parent root;
	
	public MemberServiceImpl() {
		dao = new MemberDAO();
	}
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
		String str = null;
		if(cmbAge.getValue() == null ) {
			System.out.println("콤보박스를 선택하세요");
			str = "콤보박스를 선택하세요";
			cmbAge.requestFocus();
		}else if(fxId.getText().isEmpty()) {
			str = "아이디를 선택하세요";
			System.out.println("아이디를 입력하세요");
			fxId.requestFocus();
		}
		CommonService.myAlert(str);
		
		
		System.out.println("id : "+fxId.getText());
		System.out.println("name : "+fxName.getText());
		System.out.println("pwd : "+fxPwd.getText());
		System.out.println("pwd chk : "+fxPwdChk.getText());

		System.out.println("chkMusic : "+chkMusic.getText());
		System.out.println("chkMovie : "+chkMovie.getText());
		System.out.println("chkMung : "+chkMung.getText());
		
		//둘중 하나는 선택되어야 한다. //woman이 선택되면 true, 아니면 false //false가 나오면 man이 선택되었다고 판단

		System.out.println("rdoWoman : "+rdoWoman.isSelected());
		
		MemberDTO dto = new MemberDTO();
		dto.setId(fxId.getText());
		dto.setPwd(fxPwd.getText());
		dto.setName(fxName.getText());
		//dto.setGender(rdoWoman.isSelected() ? 1:0); //1:여성,0:남성
		
		int num=0;
		if(rdoWoman.isSelected()) {//선택되면 true
			num = 1;
		}else {
			num = 0;
		}
		dto.setGender(num);
		
		dto.setAge(cmbAge.getValue());
		//1:음악, 2:영화, 4:멍 >>음악과 영화가 선택되면 합이 3으로 무엇을 선택했는지 알수 있다. 중복이 없는 숫자배열 1,2,4
		
		int hobby =0;
		if(chkMusic.isSelected()) hobby+=1;
		if(chkMovie.isSelected()) hobby+=2;
		if(chkMung.isSelected()) hobby+=4;
		dto.setHobby(hobby);
		
		int  result = dao.register(dto);
		String msg = null;
		if(result == 1) {
			System.out.println("저장 성공");
			cancelFunc();//저장이 성공적이면 창을 닫아준다.
		}else {
			msg = "문제 발생";
			System.out.println("문제 발생");
		}
		CommonService.myAlert(msg);
		
	}
	//sql에서 삭제, 추가 같은 데이터수정을 할 경우에는 커밋을 안해주면 자바에서 데이터 저장시 무한로딩걸림

	@Override
	public void cancelFunc() {
		//Stage st = (Stage)root.getScene().getWindow();
		//st.close();
		CommonService.cancelFunc(root);
	}

}
