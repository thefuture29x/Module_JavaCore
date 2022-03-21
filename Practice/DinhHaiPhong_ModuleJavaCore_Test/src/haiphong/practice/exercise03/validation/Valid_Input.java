package haiphong.practice.exercise03.validation;

import java.util.regex.Pattern;

public class Valid_Input {
    public boolean validNumber(String input_number){
        String check_number ="^[-+]?[\\d+([,]\\d+)]*\\.?[0-9]+$";
        if(input_number.matches(check_number)){
            return true;
        }else{
            System.out.println("Not a number valid");
            return false;
        }
    }

    public  boolean validString(String input_number){
        Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (!pattern.matcher(input_number).matches()) {
            System.out.println("Invalid String");
            return false;
        }
        return true;
    }

}
