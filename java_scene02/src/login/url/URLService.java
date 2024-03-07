package login.url;

import java.nio.file.Paths;

public interface URLService {
	public String fxPath = "file:/"+Paths.get("").toAbsolutePath().toString()+"/bin/"; //앞뒤 문자열 빼고 코드는 C부터 오는 절대경로를 나타냄
	//여러번 쓰는거라 인터페이스에 만들어 놓고 메인에서 불러서 계속 씀

}
