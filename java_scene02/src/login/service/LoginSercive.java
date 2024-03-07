package login.service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface LoginSercive {
	public void loginFunc(TextField fxid, TextField fxpwd);
	public void cancelFunc(Parent root);
	public void registerFunc();
	public void registerFunc(Parent root);

}
