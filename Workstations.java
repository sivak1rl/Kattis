import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Workstations {

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int inactiveTime = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(new Interval(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		int unlocksSaved = 0;
		// Queue<Interval> q = new LinkedList<Interval>();
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>();
		Interval intr = list.remove(0);
		pq.add(new Interval(intr.getDepartureTime(), inactiveTime));
		while(!list.isEmpty()) {
			while(!pq.isEmpty() && pq.peek().getDepartureTime() < list.get(0).arrivalTime) {
				pq.remove();
			}
			if (!pq.isEmpty() && (pq.peek().arrivalTime <= list.get(0).arrivalTime && pq.peek().getDepartureTime() >= list.get(0).arrivalTime)) {
				pq.remove();
				unlocksSaved ++;
				intr = list.remove(0);
				pq.add(new Interval(intr.getDepartureTime(), inactiveTime));
			} else {
				intr = list.remove(0);
				pq.add(new Interval(intr.getDepartureTime(), inactiveTime));
			}
		}
		System.out.println(unlocksSaved);
	}

}

class Interval implements Comparable<Interval> {
	Integer arrivalTime;
	Integer lengthStayed;

	/**
	 * @param arrivalTime
	 * @param lengthStayed
	 */
	public Interval(Integer arrivalTime, Integer lengthStayed) {
		super();
		this.arrivalTime = arrivalTime;
		this.lengthStayed = lengthStayed;
	}

	public Integer getDepartureTime() {
		return this.arrivalTime + this.lengthStayed;
	}

	@Override
	public int compareTo(Interval i) {
		if (this.arrivalTime.compareTo(i.arrivalTime) != 0) {
			return this.arrivalTime.compareTo(i.arrivalTime);
		}
		return i.getDepartureTime().compareTo(this.getDepartureTime());

	}
	
	@Override
	public String toString() {
		
		return "Arrival time: " + this.arrivalTime + "--Length Stayed: " + this.lengthStayed + "--Departure Time: " + this.getDepartureTime();
	}

}
