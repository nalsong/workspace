package ed.kh.test2_1;

public class Test {
	public void test() {
		IPInfo[] ii = new IPInfo[3];
		
		for(int i = 0; i<ii.length; i++) {
			ii[0] = new IPInfo(); 

			ii[1] = new IPInfo("1.1", "dd");

			ii[2] = new IPInfo("ㅎㅎ", "");
			System.out.println("ip : "+ii[i].getIp());
		}
	}

}
