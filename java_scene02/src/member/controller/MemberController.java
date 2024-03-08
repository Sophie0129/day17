package member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import member.service.MemberService;
import member.service.MemberServiceImpl;

public class MemberController implements Initializable  {
	@FXML public ComboBox<String> cmbAge;
	@FXML public TextField fxName, fxId;
	@FXML public PasswordField fxPwd, fxPwdChk;
	@FXML public CheckBox chkMusic, chkMovie, chkMung;
	@FXML public RadioButton rdoWoman;


	MemberService ms;
	Parent root;
	public void setRoot(Parent root) {
		ms.setRoot(root);
		this.root = root;
	}
	public MemberController() {
		System.out.println("생성자 초기화"+cmbAge); 
		//생성자에서는 객체를 얻기전 초기화라서 생성자초기화 대신 상속받는 initializable을 사용
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("초기화"+cmbAge);
		ms = new MemberServiceImpl();

		String[] cmbTxt = {"20대 미만", "20대", "30대", "40대", "50대 이상"};
		cmbAge.getItems().addAll(cmbTxt); //셋아이템 데이터만 새롭게 추가한다
		/*
		String[] cmbVal = {"1", "2", "3", "4", "5"};
		ObservableList<String> list = FXCollections.observableArrayList(cmbVal);
		cmbAge.setItems(list);
		 */
	}
	public void registerFunc() {
		ms.registerFunc();


	}
	public void cancelFunc() {
		ms.cancelFunc();

	}
}
