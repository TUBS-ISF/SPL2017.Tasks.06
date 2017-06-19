import interfaces.IEnable;
import interfaces.IText;

public class ByScore implements IText, IEnable {

	@Override
	public String getStarttext() {
		return "Stage Mode";
	}

	@Override
	public String getName() {
		return "ByScore";
	}

}
