import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketWindow {
	private Train[] trains;
	private Route[] routes;
	private Station[] stations;
	
	public TicketWindow(Train[] trains, Route[] routes, Station[] stations) {
		this.trains = trains;
		this.routes = routes;
		this.stations = stations;
	}
	
	public void setTrains(Train[] trains) {
		this.trains = trains;
	}
	public void setRoutes(Route[] routes) {
		this.routes = routes;
	}
	public void setStations(Station[] stations) {
		this.stations = stations;
	}


	private int findStation(Request request) throws Exception {
		int stInd = 0;
		while(stInd < stations.length && !stations[stInd].getName().equals(request.getDestination())) {
			stInd++;
		}
		if(stInd == stations.length) {
			throw new Exception("� ���������, �������� �� ������� '" + request.getDestination() + "' �� �������. ��������� ������������ �������.");
		}
		else {
			if(request.getDestination() == "������"){
				throw new Exception("�� ��� ���������� �� ������� '" + request.getDestination() + "'.");
			}
			else {
				return stInd;
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void findTrains(Request request) throws Exception {
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("*********************************************************************************");
		System.out.println(request);
		System.out.println();
		
		Station dest = stations[findStation(request)];
		Train[] tr = dest.getTrains();
		int counter = 0;
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < tr.length; i++) {
			TTime startTime = tr[i].getStart();
			if (Math.abs((startTime.add(tr[i].getRoute().getTime(dest.getName()))).delta(request.getArrivalTime2())) < 60) {
				counter++;
				System.out.println(tr[i]);
				System.out.println("�������� �� ������� '" + request.getDestination() + "' � " + tr[i].getStart().add(tr[i].getRoute().getTime(dest.getName())));
				System.out.println("���� ������ " + tr[i].getRoute().getPrice(dest.getName()));
				numbers.add(tr[i].getNumber());
			}
		}
		
		if(counter == 0) {
			throw new Exception(String.format("� ���������, �������� �� ������� '%s'  ��  '%s'  �� �������. ���������� ������ ������ �����.", 
												request.getDestination(), 
												request.getArrivalTime()));
		}
		else {
			int num = chooseTrain(numbers, in);
			giveTicket(num, request);
		}
	}
	
	protected int chooseTrain(List<Integer> list, Scanner in){
		System.out.println();
		System.out.println("��� ������� ������ �� ����� ������� ��� �����.");
		System.out.println("���� �� ���������� �������� �����, ������� '-1'.");
		//int num = Integer.parseInt(in.nextLine());
		int num = in.nextInt();
		
		while(list.indexOf(num) == (-1) && num!=(-1)){
			System.out.println("�������� ������ � ������, ������� ���������� ��������.");
			num = in.nextInt();
		}
		
		return num;
	}

	protected void giveTicket(int code, Request rq) {
		if(code == -1) {
			System.out.println("�� �������� ����� ������.");
		}
		else {
			Train t = new Train();
			for(int i = 0; i < trains.length; i++) {
				if(trains[i].getNumber() == code) {
					t = trains[i];
					break;
				}
			}
			System.out.println("///////////////////////////////////////////////");
			System.out.println("�� ��������� ����� �� ����� �" + t.getNumber());
			System.out.println("����������� �� ������� '������' � " + t.getStart());
			System.out.println("�������� �� �������� '" + rq.getDestination() + "' " + rq.getArrivalTime());
			System.out.println("///////////////////////////////////////////////");
		}
	}
}
