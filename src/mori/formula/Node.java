package mori.formula;

import java.util.Vector;

public class Node {

	public final static int NULL_NODE = 0;
	
	public final static int NUMBER_NODE = 1;
	
	public final static int ADD_NODE = 2;
	
	public final static int SUB_NODE = 3;
	
	public final static int MULTI_NODE = 4;
	
	public final static int DIV_NODE = 5;
	
	public final static int PARENTHESIS_NODE = 6;
	
	private final static int[] mOperatorPriority = {
			DIV_NODE,
			MULTI_NODE,
			ADD_NODE,
			SUB_NODE
	};
	
	public int mNodeType;
	
	public String mValue;
	
	public Vector<Node> mSubNodes;
	
	private Parser mParser;
	
	private Arithmetor mArithmetor;
	
	public Node(){
		
	}
	
	public Node(String aValue, int aNodeType){
		
		mValue = new String(aValue);
		
		mNodeType = aNodeType;
	}
	
	public void add(String aValue, int aNodeType){
		
		Node node = new Node(aValue, aNodeType);
		
		add(node);
	}
	
	public void add(Node arg){
		
		if(mSubNodes == null){
			
			mSubNodes = new Vector<Node>();
		}
		
		mSubNodes.add(arg);
	}
	
	public String mParse()throws Exception{
		
		if(mSubNodes == null){
		
			return mValue;
		}
		
		int size = mSubNodes.size();
		
		if(size == 0){
			
			return mValue;
			
		}else
		if(size == 1){
			
			Node node = mSubNodes.elementAt(0);
			
			if(node.mNodeType == PARENTHESIS_NODE){
				
				mValue = node.mValue.substring(1, node.mValue.length() - 1);
				
				mNodeType = PARENTHESIS_NODE;
				
				mParser = new Parser();
				
				mValue = mParser.add(mValue);
				
				return mValue;
				
			}else{
				
				mValue = node.mValue;
				
				mNodeType = node.mNodeType;
				
				return mValue;
			}
		}else
		if(size == 2){
			// nothing to do.
		}else{
			
			for(int oId = 0; oId < mOperatorPriority.length; oId++){
				
				int pos = mSearchNode(mOperatorPriority[oId]);
				
				if(pos >= 1){
					
					Node leftNode = new Node();
					
					Node rightNode = new Node();
					
					for(int id = 0; id < pos; id++){
						
						Node node = mSubNodes.elementAt(id);
						
						leftNode.add(node);
					}
					
					for(int id = (pos+1); id < size; id++){

						Node node = mSubNodes.elementAt(id);
						
						rightNode.add(node);
					}
					
					mArithmetor = new Arithmetor();
					
					String ans = mArithmetor.mExe(leftNode, rightNode, mOperatorPriority[oId]);
					
					return ans;
					
				}// if pos
			}// for oId
		}

		StringBuffer errMsg = new StringBuffer();
		
		for(int id = 0; id < size; id++){
			
			Node node = mSubNodes.elementAt(id);
			
			errMsg.append(id + ":");
			
			errMsg.append(node.mValue);
			
			errMsg.append("/");
		}
		
		throw new Exception(errMsg.toString());
	}
	
	private int mSearchNode(int aNodeType){
		
		int size = mSubNodes.size();
		
		for(int id = 0; id < size; id++){
			
			Node node = mSubNodes.elementAt(id);
			
			if(node.mNodeType == aNodeType){
				
				return id;
			}
		}
		
		return -1;
	}
}
