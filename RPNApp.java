package week10;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**.
 *  @author James Tucker
 *  @author Liam Flynn
 *  @author Ben Stacey
 */
public class RPNApp {
    private static Stack<Long> rpnStack;
    /**.
     * Method invoked by main() and is run infinite times.
     * Description:
     * entryPoint() function will contain code for:
     * - Reading user input via readInUserInput()
     * - !!! Determine special cases: brackets, 'c', 'r',  repeat operators,
     * - If no special cases, perform basicCompute()
     * @param userInput
     */
    private static void entrypoint(String userInput) {
        rpnStack = new Stack<Long>();
        try {
            System.out.println(compute(userInput));
        }   catch (NumberFormatException e) {
            String exceptionToken = e.getMessage().substring(e.getMessage().indexOf('"') + 1, e.getMessage().length()-1);
            System.out.println("Error: bad token '" + exceptionToken + "'");
        }   catch (ArithmeticException e) {
            /** CHANGE THIS -- we need to determine
             * WHETHER or not we have a:
             * division by 0 OR
             * remainder by 0.
             * */
            System.out.println("Error: division by 0");
        }   catch (EmptyStackException e) {
            System.out.println("Error: too few operands");
        }   catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Error: negative copy");
        }
    }

    /**.
     * This function will prevent code duplication
     * within our main switch branch.
     * @param operator -
     */
    private static void handleExclamation(String operator) {
        /* Top element must be set to
           the first popped element of the stack.
        */
        long result = 0L;
        int stackSize = rpnStack.size();
        for (int i = 0; i < stackSize; i++) {
            if (i == 0) {
                result = rpnStack.pop();
            }   else {
                switch (operator) {
                    case ("+!"): {
                        result += rpnStack.pop();
                        break;
                    }
                    case ("-!"): {
                        result -= rpnStack.pop();
                        break;
                    }
                    case ("/!"): {
                        result /= rpnStack.pop();
                        break;
                    }
                    case ("*!"): {
                        result *= rpnStack.pop();
                        break;
                    }
                    case ("%!"): {
                        result %= rpnStack.pop();
                        break;
                    }
                }
            }
        }
        rpnStack.push(result);
    }

    /**.
     *
     */
    private static void handleRotate() {
        // how many places we will rotate
        long rotateBy = rpnStack.pop()-1;
        // the "value" which we will rotate.
        long rotateValue = rpnStack.pop();
        // the size of the rpnStack
        int stackSize = rpnStack.size();
        // new temporary stack
        Stack<Long> tStack = new Stack<Long>();
        // remove elements of stack up to our
        // "rotateBy value"
        for (int i = 0; i < rotateBy; i++) {
            tStack.push(rpnStack.pop());
        }
        // push the rotateValue onto the stack
        rpnStack.push(rotateValue);
        int tStackSize = tStack.size();
        // rebuild the stack from the tStack stack.
        for (int i = 0; i < tStackSize; i++) {
            rpnStack.push(tStack.pop());
        }
    }

    /**.
     *
     */
    private static void handleCopy() {
        long copyBy = rpnStack.pop();
        // Cannot negative copy, so throw error.
        if (copyBy < 0) throw new IllegalArgumentException();
        long valueToCopy = rpnStack.pop();
        for (int i = 0; i < copyBy; i++) {
            rpnStack.push(valueToCopy);
        }
    }

    /**.
     * @param topOfStack - repeated k times where k is the number on top of the stack when the ‘(’ is encountered
     * @param userInputArray - the formatted string of characters
     * @param index - current offset
     * @return offset index.
     */
    private static int handleOpeningParenthesis(long topOfStack, String [] userInputArray, int index) {
        /*
          Idea is to get all elements after the opening parenthesis
          until the closing parenthesis.
          Then "recursively" call compute() on the expression.
          Push result onto stack.

          Also we need to remove the characters from "index"
          to index offset.
        */
        StringBuilder expression = new StringBuilder();
        int currentParenthesisState = 1;
        int offsetIndex = index+1;
        int currentIndex = 0;
        for (currentIndex = offsetIndex; currentIndex < userInputArray.length; currentIndex++) {
            if (userInputArray[currentIndex].equals("(")) {
                currentParenthesisState++;
                if (currentParenthesisState != 0) {
                    expression.append("( ");
                }
            }   else if (userInputArray[currentIndex].equals(")")) {
                currentParenthesisState--;
                if (currentParenthesisState != 0) {
                    expression.append(") ");
                }   else break;
            }   else {
                expression.append(userInputArray[currentIndex]).append(" ");
            }
        }
        offsetIndex = currentIndex;
        if (currentParenthesisState == 0) {
            // repeated k times where k is the number on top of the stack when the ‘(’ is encountered
            // so compute original expression, get result -> call next expression using the result:
            String result = expression.toString();
            for (int i = 0; i < topOfStack; i++) {
                // recursively call compute...
                compute(result);
            }
        }   else {
            // Change this exception to something unique maybe.
            throw new IllegalArgumentException("unmatched parenthesis");
        }
        return offsetIndex;
    }

    /**.
     *
     * @param userInput
     * @return
     * @throws ArithmeticException
     * @throws EmptyStackException
     * @throws NumberFormatException
     */
    private static String compute(String userInput) throws ArithmeticException, EmptyStackException, NumberFormatException {
        /*
          We are using an index for our loop
          as opposed to a for-each loop as we need
          to retain the index in order to handle the
          cases where there is a parenthesis.
        */
        String userInputArray[] = userInput.split("\\s+");
        for (int index = 0; index < userInputArray.length; index++) {
            String token = userInputArray[index];
            /** enhanced switch, no need for break statements */
            switch (token) {
                /* Addition */
                case "+": {
                    rpnStack.push(rpnStack.pop() + rpnStack.pop());
                    break;
                }
                    /* Subtraction */
                case "-": {
                    rpnStack.push(-rpnStack.pop() + rpnStack.pop());
                    break;
                }
                    /* Multiplication */
                case "*": {
                    rpnStack.push(rpnStack.pop() * rpnStack.pop());
                    break;
                }
                    /* Division */
                case "/": {
                    long divisor = rpnStack.pop();
                    rpnStack.push(rpnStack.pop() / divisor);
                    break;
                }
                    /* Modulo */
                case "%": {
                    long modulo = rpnStack.pop();
                    rpnStack.push(rpnStack.pop() % modulo);
                    break;
                }
                    /* Exclamation */
                case "+!":
                case "*!":
                case "-!":
                case "%!":
                case "/!": {
                    handleExclamation(token);
                    break;
                }
                    /* Duplication */
                case "d": {
                    rpnStack.push(rpnStack.peek());
                    break;
                }
                    /* Output top item */
                case "o": {
                    System.out.print(rpnStack.peek() + " ");
                    break;
                }
                    /* Copy top element method */
                case "c": {
                    handleCopy();
                    break;
                }
                    /* Roll-rotate method. */
                case "r": {
                    handleRotate();
                    break;
                }
                case "(": {
                    index = handleOpeningParenthesis(rpnStack.pop(), userInputArray, index);
                    break;
                }
                default: {
                    rpnStack.push(Long.parseLong(token));
                }
            }
        }
        return rpnStack.toString();
    }
    /**.
     * We are using a infinite while loop to keep reading
     * and processing user input via the entrypoint() function
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            entrypoint(sc.nextLine());
        }
    }
}
