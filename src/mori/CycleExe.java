package mori;

import mori.LogService.C_LogService;

/*
 * master 2016.06.20.03
 */
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
		
		mori.Lie.Main lieMain = new mori.Lie.Main(log);
		
		lieMain.mStartService();
	}
}
