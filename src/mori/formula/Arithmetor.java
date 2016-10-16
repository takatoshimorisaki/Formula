package mori.formula;

import static java.lang.System.out;
import static mori.formula.Node.*;

public class Arithmetor {

	public String mExe(
			Node aLeftNode,
			Node aRightNode,
			int aNodeType
	)throws Exception{
		String leftStr = aLeftNode.mParse();
		
		String rightStr = aRightNode.mParse();
		
		out.printf("%s:%s:%s\n", leftStr, Node.mToString(aNodeType), rightStr);
		
		double leftValue = Double.parseDouble(leftStr);
		
		double rightValue = Double.parseDouble(rightStr);
		
		double value = 0.0;
		
		if(aNodeType == ADD_NODE){
			
			value = leftValue + rightValue;
			
		}else
		if(aNodeType == SUB_NODE){

			value = leftValue - rightValue;
			
		}else
		if(aNodeType == MULTI_NODE){

			value = leftValue * rightValue;
			
		}else
		if(aNodeType == DIV_NODE){

			value = leftValue / rightValue;
			
		}else{
			throw new Exception();
		}
		
		String ans = String.format("%f", value);
		
		return ans;
	}
}
