import java.util.ArrayList;

public class PasswordCheckerUtility {

    public PasswordCheckerUtility(){
    }

    /**
     * @author Camron M. Franklin
     */
    /**
     * Checks if two passwords match, throws exception if they do not
     * @param password -- password string to be compared
     * @param passwordConfirm -- second password string to be compared
     * @throws UnmatchedException -- thrown if passwords do not match (case sensitive)
     */
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm))
            throw new UnmatchedException("Passwords do not match");
    }

    /**
     * Checks if two passwords match, returns false if they do not
     * @param password -- password string to be compared
     * @param passwordConfirm -- second password string to be compared
     * @return true if the passwords match, false if they do not (case sensitive)
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
        return password.equals(passwordConfirm);
    }

    /**
     * Checks the strength of the password
     * @param password -- password string to be checked for strength
     * @return true if password length is between six and nine characters
     */
    public static boolean hasBetweenSixAndNineChars(String password){
        return password.length() >= 6 && password.length() <= 9;
    }

    /**
     * Checks password digit requirement
     * @param password -- password string to be checked
     * @return true if password meets requirement
     * @throws NoDigitException if password does not meet digit requirement
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        for (int i = 0; i < password.length(); i++){
            if ("0123456789".contains(Character.toString(password.charAt(i))))
                return true;
        }
        throw new NoDigitException("The password must contain at least one digit");
    }

    /**
     * Checks password lowercase alpha requirement
     * @param password -- password string to be checked
     * @return true if password meets requirement
     * @throws NoLowerAlphaException if password does not mean lowercase alpha requirement
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        for (int i = 0; i < password.length(); i++){
            if ("acbdefghijklmnopqrstuvwxyz".contains(Character.toString(password.charAt(i))))
                return true;
        }
        throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
    }

    /**
     * Checks password subsequence requirement
     * @param password -- password string to be checked
     * @return false if password meets requirement (careful)
     * @throws InvalidSequenceException if password does not meet subsequence requirement
     */
    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++){
            //casts individual characters into strings to be compared
            if (Character.toString(password.charAt(i)).equals(Character.toString(password.charAt(i + 1)))){
                //checks neighboring character and the neighbor's neighbor
                if (Character.toString(password.charAt(i)).equals(Character.toString(password.charAt(i + 2))))
                    throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
            }
        }
        return false;
    }

    /**
     * Checks password special character requirement
     * @param password -- password string to be checked
     * @return true is requirement is met
     * @throws NoSpecialCharacterException if password does not meet special character requirement
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        for (int i = 0; i < password.length(); i++){
            if ("!@#$%^&*()_+=-{}[]:;\"'?/>.<,\\|`~".contains(Character.toString(password.charAt(i))))
                return true;
        }
        throw new NoSpecialCharacterException("The password must contain at least one special character");
    }

    /**
     * Checks password uppercase alpha requirement
     * @param password -- password string to be checked
     * @return true if password meets requirement
     * @throws NoUpperAlphaException if password does not meet upper alpha requirement
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        for (int i = 0; i < password.length(); i++){
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(Character.toString(password.charAt(i))))
                return true;
        }
        throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
    }

    /**
     * Checks password length requirement
     * @param password -- password string to be checked
     * @return true if password meets requirement
     * @throws LengthException if password does not meet length requirement
     */
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() >= 6)
            return true;
        throw new LengthException("The password must be at least 6 characters long");
    }

    /**
     * Checks all password requirements
     * @param password -- password string to be checked
     * @return true if password meets all requirements, false if it doesn't
     * @throws LengthException if length requirement not met
     * @throws NoUpperAlphaException if uppercase alpha requirement not met
     * @throws NoLowerAlphaException if lowercase alpha requirement not met
     * @throws NoDigitException if digit requirement not met
     * @throws NoSpecialCharacterException if special character requirement not met
     * @throws InvalidSequenceException if subsequence requirement not met
     */
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        try{
            if(PasswordCheckerUtility.isValidLength(password)){
                if(PasswordCheckerUtility.hasUpperAlpha(password)){
                    if(PasswordCheckerUtility.hasLowerAlpha(password)){
                        if(PasswordCheckerUtility.hasDigit(password)){
                            if(PasswordCheckerUtility.hasSpecialChar(password)){
                                if(!PasswordCheckerUtility.hasSameCharInSequence(password))
                                    return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex){
            throw ex;
        }
        return false;
    }

    /**
     *
     * @param password -- password to be checked
     * @return true if password is weak, false if it's strong
     * @throws WeakPasswordException
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (PasswordCheckerUtility.hasBetweenSixAndNineChars(password))
            throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
        else
            return false;
    }

    /**
     * Checks a String ArrayList of passwords, returns all that aren't valid
     * @param passwords String ArrayList of passwords
     * @return string comprised of all invalid passwords
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)  {
        ArrayList<String> invalidPasswords = new ArrayList<String>();
        for (String password : passwords) {
            try {
                PasswordCheckerUtility.isValidPassword(password);
            } catch (Exception ex) {
                invalidPasswords.add(password + " - " + ex.getMessage());
            }
        }
        return invalidPasswords;
    }
}


