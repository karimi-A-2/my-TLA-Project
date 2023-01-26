import java.math.BigInteger;
import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public void print( String message ) {
        System.out.print(message);
    }
    
    public void println( String message ) {
        System.out.println(message);
    }
    
    public void printPrompt( String message ) {
        print("\t [> " + message + ": ");
    }
    
    public void printInfo( String message ) {
        println("\t ~~~ " + message);
    }
    
    public void printWarning( String message ) {
        println("\t !!~~ " + message);
    }
    
    public BigInteger getBigInteger( String message ) {
        printPrompt(message);
        return getBigInteger();
    }
    
    public String getString( String message ) {
        printPrompt(message);
        return getString();
    }
    
    public int getInt( String message ) {
        printPrompt(message);
        return getInt();
    }
    
    public double getDouble( String message ) {
        printPrompt(message);
        return getDouble();
    }
    
    public boolean getBoolean( String message ) {
        printPrompt(message);
        return getAdvanceBoolean();
    }
    
    public boolean getAdvanceBoolean() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        while (true) {
            String strYesNo = getString();
            switch (strYesNo) {
                case "yes":
                case "true":
                case "yap":
                    return true;
                case "no":
                case "false":
                case "nope":
                    return false;
                default:
                    printWarning(String.format("\"%s\" is invalid (yes/no)", strYesNo));
            }
        }
    }
    
    public BigInteger getBigInteger() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        String string = getString();
        
        return new BigInteger(string);
    }
    
    public int getIndex() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        printPrompt("Enter index");
        return getInt();
    }
    
    public String getString() {
        return SCANNER.nextLine();
    }
    
    public byte getByte() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        byte aByte = SCANNER.nextByte();
        getString();
        return aByte;
    }
    
    public int getInt() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        int anInt = SCANNER.nextInt();
        getString();
        return anInt;
    }
    
    public float getFloat() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        float aFloat = SCANNER.nextFloat();
        getString();
        return aFloat;
    }
    
    public double getDouble() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        double aDouble = SCANNER.nextDouble();
        getString();
        return aDouble;
    }
    
    public boolean getSimpleBoolean() {
        // TODO: 9/12/2021 improve to check validation and exception handling 
        boolean aBoolean = SCANNER.nextBoolean();
        getString();
        return aBoolean;
    }
    
    public void demandEnter() {
        // TODO: 9/12/2021 improve to check only for "Enter" character and nothing more 
        print("\t (▶) Enter to proceed (▶) ");
        getString();
    }
    
    public void demandEnter( String message ) {
        print("\t (▶) " + message + " (▶) ");
        getString();
    }
    
}
