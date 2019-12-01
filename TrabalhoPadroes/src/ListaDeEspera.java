import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListaDeEspera {
	private List<Observer> observers = new LinkedList<Observer>();
	private int state = 1;

	public int getState() {
		return state;
	}
	
	public void removeObserver() {
		observers.remove(1);
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
