package calc_p;

import java.util.*;

public class infix_calc {
	
	public static void main(String[] args) {
	// insert user input below 

		Scanner in = new Scanner(System.in);

		System.out.print("Enter expression: ");

		String exp = in.nextLine(); 
		
	// call method below 
		System.out.println("Evaluation = " + calc(exp));

		{

		    }

		}
	

	public static boolean precedence (char a, char b)

	{

	if (b == '(' || b == ')')

	return false;

	if ((a == '*' || a == '/') && (b == '+' || b == '-'))

	return false;

	else

	return true;

	}
	
   // stack for function and num 
	
	public static int calc (String expression)

	{

	char[] input = expression.toCharArray();


	Stack<Integer> values = new Stack<Integer>();


	Stack<Character> function = new Stack<Character>();

	for (int i = 0; i < input.length; i++)

	{

	

	if (input[i] == ' ')

	continue;

	

	if (input[i] >= '0' && input[i] <= '9')

	{

	StringBuffer s = new StringBuffer();

	

	while (i < input.length && input[i] >= '0' && input[i] <= '9')

	s.append(input[i++]);

	values.push(Integer.parseInt(s.toString()));

	

	i--;

	  }
	
	else if (input[i] == '(')

	function.push(input[i]);

	

	else if (input[i] == ')')

	{

	while (function.peek() != '(')

	values.push(start(function.pop(),values.pop(),values.pop()));

	function.pop();
 
	      }

	
	else if (input[i] == '+' || input[i] == '-' || input[i] == '*' ||

	input[i] == '/')

	{

	// insert a while loop 

	while (!function.empty() && precedence(input[i],function.peek()))

	values.push(start(function.pop(),values.pop(), values.pop()));

	function.push(input[i]); 

	              }

	        }

	
	while (!function.empty())

	values.push(start(function.pop(),values.pop(),values.pop()));

	return values.pop(); 

	  }

	

	public static int start(char opps,int b, int a) {

	switch (opps)

	{

	      case '+':

	      return a + b;

	      case '-':

	      return a - b;

	      case '*':

	      return a * b;

	      case '/':
	    	 
	    	 
// test case below 
	    	 
	if (b == 0)

	throw new UnsupportedOperationException("Cannot divide by zero");

	return a / b;

	     }

	return 0;

	   }
	
	
	
}
