package ErrorHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            // 1. Arithmetic Exception (e.g., division by zero)
            int result = 10 / 0;
            System.out.println("Result: " + result);
            
            // 2. NullPointerException
            String str = null;
            System.out.println(str.length());
            
            // 3. ArrayIndexOutOfBoundsException
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
            
            // 4. FileNotFoundException
            File file = new File("nonexistentfile.txt");
            FileReader fr = new FileReader(file);
            
            // 5. NumberFormatException
            int num = Integer.parseInt("abc");
            System.out.println("Parsed number: " + num);
            
            // 6. InputMismatchException (e.g., when expecting an integer but getting a string)
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number:");
            int input = scanner.nextInt();
            System.out.println("You entered: " + input);
            
        } 
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } 
        finally {
            System.out.println("Execution completed. Resources can be cleaned up here if needed.");
        }
    }
}

