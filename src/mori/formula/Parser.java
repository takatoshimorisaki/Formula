package mori.formula;

import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Parser{
	
	private static String mCharSet = "UTF-8"; // "US-ASCII"; // "UTF-8";
	
	private TokenParser mTokenParser;
	
	public Parser(){
		
		//// this.read();
	}
	
	public String add(String arg){
		
		mTokenParser = new TokenParser();
				
		try{
			String msg = arg.trim();
			
			if(msg.length() == 0){
				
				return null;
			}else{
				
				int size = msg.length();
				
				for(int id = 0; id < size; id++){
					
					String token = msg.substring(id,  id+1);
					
					mTokenParser.mExe(token);
				}
				
				String ans = mTokenParser.mParse();
				
				return ans;
			}
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private void read(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("DOC/input.txt"),mCharSet));
			
			String line = null;

			while((line = br.readLine()) != null){

				if(line.startsWith("#")){
				}else{
					this.add(line);
				}
			}
			
			br.close();
		}catch(Exception ex){
			ex.printStackTrace();
			System.err.println(ex);
		}
	}
}

