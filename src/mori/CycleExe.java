package mori;

import mori.LogService.C_LogService;

public class CycleExe {

	public static void main(String[] args){
		C_LogService log       = null;

		try{
			log = new C_LogService();
			log.mStartService();
		}catch(Exception ex){
			ex.printStackTrace();
			System.err.println(ex);
		}
		
		mori.formula.Main lieMain = new mori.formula.Main(log);
		
		lieMain.mStartService();
	}
}
