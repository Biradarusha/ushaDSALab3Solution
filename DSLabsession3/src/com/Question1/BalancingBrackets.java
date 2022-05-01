package com.Question1;

import java.util.Stack;

public class BalancingBrackets {

	static boolean checkingBracketBalanced(String bracketexp) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i < bracketexp.length(); i++)
		{
		char x =bracketexp.charAt(i);
		if(x == '(' || x =='{' || x == '[')
		{
			stack.push(x);
			continue;
			
		}
		if(stack.isEmpty())
			return false;
		char check;
		switch(x) {
		case ')':
			check = stack.pop();
			if(check == '{' || check =='[')
				return false;
			break;
		case '}':
			check = stack.pop();
			if(check == '(' || check =='[')
				return false;
			break;
		case ']':
			check = stack.pop();
			if(check == '(' || check =='{')
				return false;
			break;
		
		}
		
		
	}
		return(stack.isEmpty());
}
	public static void main(String[] args) {
		String bracketexp = "( [ [ { } ] ] )";
		if(checkingBracketBalanced(bracketexp))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}
		
	}
	