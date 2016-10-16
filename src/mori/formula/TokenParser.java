package mori.formula;

import static mori.formula.Node.*;
import mori.util.NumericChecker;

public class TokenParser {

	private static NumericChecker mNumericChecker = new NumericChecker();
	
	private Node mRoot;
	
	private StringBuffer mStrBuf;
	
	private int mNodeType0;
	
	private int mNodeType1;
	
	private int mParenthesisDepth;
	
	public TokenParser(){
		
		mRoot = new Node();
	}
	
	public void mExe(String token)throws Exception{
	
		if(mStrBuf == null){
			
			mStrBuf = new StringBuffer();
		}
	
		mNodeType1 = mNodeType0;
		
		if(mNumericChecker.mExe(token)){
			
			mStrBuf.append(token);
			
			mNodeType0 = NUMBER_NODE;
			
		}else
		if(token.equals("+")){

			mAddNumberNode();
			
			mStrBuf.append(token);
			
			mNodeType0 = ADD_NODE;
			
			mAddNode();
			
		}else
		if(token.equals("-")){

			mAddNumberNode();
			
			mStrBuf.append(token);
			
			mNodeType0 = SUB_NODE;

			mAddNode();
			
		}else
		if(token.equals("*")){

			mAddNumberNode();

			mStrBuf.append(token);
			
			mNodeType0 = MULTI_NODE;

			mAddNode();
			
		}else
		if(token.equals("/")){

			mAddNumberNode();

			mStrBuf.append(token);
			
			mNodeType0 = DIV_NODE;

			mAddNode();
			
		}else
		if(token.equals("(")){

			mAddNumberNode();
			
			mStrBuf.append(token);
			
			mNodeType0 = PARENTHESIS_NODE;
			
			mParenthesisDepth++;

		}else
		if(token.equals(")")){

			mStrBuf.append(token);
			
			mNodeType0 = PARENTHESIS_NODE;
			
			mParenthesisDepth--;
			
			mAddNode();
		}
				
	}
	
	private void mAddNumberNode(){
		
		if(mNodeType1 == NUMBER_NODE
		&& mParenthesisDepth == 0){
			
			mRoot.add(mStrBuf.toString(), NUMBER_NODE);
			
			mStrBuf = new StringBuffer();
		}
	}
	
	private void mAddNode(){

		if(mParenthesisDepth == 0){
			
			mRoot.add(mStrBuf.toString(), mNodeType0);
			
			mStrBuf = null;
		}
	}
	
	public String mParse()throws Exception{

		if(mNodeType0 == NUMBER_NODE){
			
			mRoot.add(mStrBuf.toString(), NUMBER_NODE);
			
			mStrBuf = null;
		}
		
		String ans = mRoot.mParse();
		
		return ans;
	}
}
