import java.util.List;

public class Test {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Train[] createTrains(Route[] r) {
		Train[] tr = new Train[10];
		
		tr[0] = new Train(11, r[0], "11:10");
		tr[1] = new Train(12, r[0], "12:15");
		tr[2] = new Train(13, r[0], "17:00");
		tr[3] = new Train(14, r[1], "16:50");
		tr[4] = new Train(15, r[1], "18:30");
		
		tr[5] = new Train(16, r[2], "7:10");
		tr[6] = new Train(17, r[2], "11:10");
		tr[7] = new Train(18, r[2], "15:10");
		tr[8] = new Train(19, r[2], "19:10");
		tr[9] = new Train(10, r[2], "23:10");
		
		return tr;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Station[] createStations() {
		Station[] st = new Station[6];
		
		st[0] = new Station("Вокзал");
		st[1] = new Station("Весёлое");
		st[2] = new Station("Зелёное");
		st[3] = new Station("Колобки");
		st[4] = new Station("Рыбинск");
		st[5] = new Station("Залесье");
		return st;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void setTrains(Station[] st, Train[] tr) {
		for(int i = 0; i < 3; i++) {
			st[0].addTrain(tr[i]);
			st[1].addTrain(tr[i]);
			st[2].addTrain(tr[i]);
		}
		
		for(int i = 3; i < 5; i++) {
			st[0].addTrain(tr[i]);
			st[1].addTrain(tr[i]);
			st[3].addTrain(tr[i]);
		}
		
		for(int i = 5; i < 10; i++) {
			st[0].addTrain(tr[i]);
			st[4].addTrain(tr[i]);
			st[5].addTrain(tr[i]);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Route[] createRoutes(Station[] st) {
		Route[] r = new Route[3];
		
		TTime[][] t = new TTime[3][3];
		Station[][] s = new Station[3][3];
		int[][] p = new int[3][3];
		
		s[0][0] = st[0]; // вокзал - весёлое - зеленое
		s[1][0] = st[0]; // вокзал - весёлое - колобки
		s[2][0] = st[0]; // вокзал - рыбинск - залесье
		
		s[0][1] = st[1];
		s[1][1] = st[1];
		s[2][1] = st[4];
		
		s[0][2] = st[2];
		s[1][2] = st[3];
		s[2][2] = st[5];
		
		p[0][0] = 0; // вокзал - весёлое - зеленое
		p[1][0] = 0; // вокзал - весёлое - колобки
		p[2][0] = 0; // вокзал - рыбинск - залесье
		
		p[0][1] = 10;
		p[1][1] = 10;
		p[2][1] = 5;
		
		p[0][2] = 5;
		p[1][2] = 2;
		p[2][2] = 2;
		
		t[0][0] = new TTime(); // вокзал - весёлое - зеленое
		t[1][0] = new TTime(); // вокзал - весёлое - колобки
		t[2][0] = new TTime(); // вокзал - рыбинск - залесье
		
		t[0][1] = new TTime(60);
		t[1][1] = new TTime(60);
		t[2][1] = new TTime(20);
		
		t[0][2] = new TTime(30);
		t[1][2] = new TTime(15);
		t[2][2] = new TTime(10);
		
		r[0] = new Route(t[0], p[0], s[0]);
		r[1] = new Route(t[1], p[1], s[1]);
		r[2] = new Route(t[2], p[2], s[2]);

		return r;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		Station[] st = createStations();
		Route[] rt = createRoutes(st);
		Train[] tr = createTrains(rt);
		setTrains(st, tr);
	
					
		Connector<Train> conT = new Connector<>("trains.dat");
		Connector<Station> conS = new Connector<>("stations.dat");
		Connector<Route> conR = new Connector<>("routes.dat");
			
		conT.write(tr);
		conS.write(st);
		conR.write(rt);
			
		List<Train> tList = conT.read();
		List<Station> sList = conS.read();
		List<Route> rList = conR.read();
			
		Train[] stockArr1 = new Train[tList.size()];
		Route[] stockArr2 = new Route[rList.size()];
		Station[] stockArr3 = new Station[sList.size()];
		TicketWindow win = new TicketWindow(tList.toArray(stockArr1), rList.toArray(stockArr2), sList.toArray(stockArr3));
			
		Request[] rq = new Request[6];
		rq[0] = new Request("Зелёное", "27.10 12:40"); // точное прибытие
		rq[1] = new Request("Залесье", "27.10 8:20");  // прибытие в пределах допустимого отклонения (1 час)
		rq[2] = new Request("Весёлое" , "28.10 17:10");// прибытие не на конечную
		rq[3] = new Request("Колобки", "27.10 15:00"); // нет подходящего поезда
		rq[4] = new Request("Зилёное", "27.10 12:40"); // ошибка в запросе
		rq[5] = new Request("Вокзал" , "27.10 11:10"); // едем на вокзал
			
		for(int i = 0; i < 6; i++) {
			try {
				win.findTrains(rq[i]);
			} catch (Exception e) {
				System.out.println(e);
				//e.printStackTrace();
			}
		}
	}
}
