package ua.com.foxminded.longdivision;

import java.util.ArrayList;
import java.util.List;

public class Division {

    public List<String> getLastReminders(int dividend, int divisor) {
        List attributes = new ArrayList<>();
        StringBuffer reminder = new StringBuffer();
        dividend = Math.abs(dividend);
        divisor  = Math.abs(divisor);
        String[] digits = String.valueOf(dividend).split("");
        Integer reminderNumber;
        Integer mod;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());
            if (reminderNumber >= divisor) {
                attributes.add(reminderNumber);
                mod = reminderNumber % divisor;
                reminder.replace(0, reminder.length(), mod.toString());
            }
        }
        return attributes;
    }

    public List getMultiplyResults(int dividend, int divisor) {
        List attributes = new ArrayList();
        StringBuffer reminder = new StringBuffer();
        dividend = Math.abs(dividend);
        divisor  = Math.abs(divisor);
//        int [] digits =
        String[] digits = String.valueOf(dividend).split("");
        int dividendDigits = calculateDigits(dividend);
        Integer reminderNumber;
        Integer multiplyResult;
        Integer mod;

        for (int i = 0; i < dividendDigits; i++) {

            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());
            if (reminderNumber >= divisor) {
                mod            = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                reminder.replace(0, reminder.length(), mod.toString());
                attributes.add(multiplyResult);
            }
        }
        return attributes;
    }

    public int getFinalReminder(int dividend, int divisor) {
        int finalReminder = 0;
        StringBuffer reminder = new StringBuffer();
        dividend = Math.abs(dividend);
        divisor  = Math.abs(divisor);
        String[] digits = String.valueOf(dividend).split("");
        Integer reminderNumber;
        Integer multiplyResult;
        Integer mod;

        for (int i = 0; i < digits.length; i++) {

            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());
            if (reminderNumber >= divisor) {
                mod            = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                reminder.replace(0, reminder.length(), mod.toString());
                reminderNumber = Integer.parseInt(reminder.toString());
            }
            if (i == digits.length - 1) {
                finalReminder = reminderNumber;
            }
        }
        return finalReminder;
    }

    private int calculateDigits(int digits) {
        return (int) Math.log10(digits) + 1;
    }

    public int appendInteger(int firstDigit, int secondDigit) {
        int apended;
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit).append(secondDigit);
        return apended = Integer.parseInt(sb.toString());
    }

}
