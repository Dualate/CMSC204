import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Camron M. Franklin
 *
 */
public class PasswordCheckerTest_STUDENT_Test {


    /**
     * Test if the password is less than 8 characters long.
     * This test should throw a LengthException for second case.
    */
    @Test
    public void testIsValidPasswordTooShort() throws LengthException
    {
        try {
            assertTrue(PasswordCheckerUtility.isValidLength("1234567890"));
            assertFalse(PasswordCheckerUtility.isValidLength("1234"));
            assertTrue(PasswordCheckerUtility.isValidLength("123456"));
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha() throws NoUpperAlphaException
    {
        try{
            assertTrue(PasswordCheckerUtility.hasUpperAlpha("PANCAKE"));
            assertFalse(PasswordCheckerUtility.hasUpperAlpha("syrups"));
            assertTrue(PasswordCheckerUtility.hasUpperAlpha("Butter"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha() throws NoLowerAlphaException
    {
        try{
            assertTrue(PasswordCheckerUtility.hasLowerAlpha("Hockey"));
            assertFalse(PasswordCheckerUtility.hasLowerAlpha("FOOTBALL"));
            assertTrue(PasswordCheckerUtility.hasLowerAlpha("TENNIs"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsWeakPassword() throws WeakPasswordException
    {
        try {
            assertFalse(PasswordCheckerUtility.isWeakPassword("1234567890"));
            assertTrue(PasswordCheckerUtility.isWeakPassword("123456"));
            assertFalse(PasswordCheckerUtility.isWeakPassword("12345678901"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence() throws InvalidSequenceException
    {
        try{
            assertFalse(PasswordCheckerUtility.hasSameCharInSequence("butter"));
            assertTrue(PasswordCheckerUtility.hasSameCharInSequence("buttter"));
            assertFalse(PasswordCheckerUtility.hasSameCharInSequence("butTter"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit()
    {
        try{
            assertTrue(PasswordCheckerUtility.hasDigit("12345"));
            assertFalse(PasswordCheckerUtility.hasDigit("onetwothree"));
            assertTrue(PasswordCheckerUtility.hasDigit("1twothree"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful() throws Exception
    {
        try{
            assertTrue(PasswordCheckerUtility.isValidPassword("Bel1atheBul!dog"));
            assertTrue(PasswordCheckerUtility.isValidPassword("K3na!&koda"));
            assertTrue(PasswordCheckerUtility.isValidPassword("0reO1sde&d"));
        }
        catch (Exception ex){
            throw ex;
        }
    }

    /**
     * Test the invalidPasswords method
     * Check the results of the ArrayList of Strings returned by the validPasswords method
     */
    @Test
    public void testInvalidPasswords() {
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();

        passwords.add("Butt3r!sGood");
        passwords.add("!amT1red");
        passwords.add("s3venDead!y");
        passwords.add("JamesCorden");
        passwords.add("peanut_butter");

        test.add("JamesCorden - The password must contain at least one digit");
        test.add("peanut_butter - The password must contain at least one uppercase alphabetic character");
        assertEquals(PasswordCheckerUtility.getInvalidPasswords(passwords), test);
    }

}