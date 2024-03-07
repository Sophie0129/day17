package login.service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface LoginService {
	public void loginFunc(TextField fxId ,TextField fxPwd);
	public void cancelFunc( Parent root );
	public void registerFunc();
	public void registerFunc( Parent root );
}
