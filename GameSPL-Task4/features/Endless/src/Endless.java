import interfaces.IEnable;
import interfaces.IText;

public class Endless implements IText,IEnable {

	@Override
	public String getName() {
		return "Endless";
	}
	@Override
	public String getStarttext() {
		return "Click to Start";
	}


}
