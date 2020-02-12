package ua.com.foxminded.longdivision;

import java.util.List;

public class ResultFormatter {

    String divide(int dividend, int divisor) {
        Division user = new Division();

        StringBuffer result = new StringBuffer();
        if (divisor == 0) {
            System.out.println("Unable to divide by zero");
        } else if (dividend < divisor
                || dividend == 0) {
            System.out.println(dividend + " / " + divisor + " = " + 0);
        } else {
            List lastReminders = user.getLastReminders(dividend, divisor);
            List multiplyResults = user.getMultiplyResults(dividend, divisor);
            int finalReminder = user.getFinalReminder(dividend, divisor);
            result = drawHz(lastReminders, multiplyResults, finalReminder);
            modifyResultView(result, dividend, divisor);
        }
        return result.toString();
    }

    private StringBuffer drawHz(List lastReminders, List multiplyResults, int finalReminder) {
        StringBuffer resultBuilder = new StringBuffer();
        int lastRemindersSize = lastReminders.size();

        for (int i = 0; i < lastRemindersSize; i++) {
            int multiplyResultsSize = (int) multiplyResults.get(i);

            String lastReminder = String.format("%" + (i + 2) + "s", "_" + lastReminders.get(i));
            resultBuilder.append(lastReminder).append("\n");

            String multiply = String.format("%" + (i + 2) + "d", multiplyResults.get(i));
            resultBuilder.append(multiply).append("\n");

            Integer tab = lastReminder.length() - multiply.length();
            resultBuilder.append(createDivisor(multiplyResultsSize, tab)).append("\n");

            if (i == lastRemindersSize - 1) {
                String lastReminder3 = String.format("%" + (i + 2) + "s", finalReminder);

                resultBuilder.append(lastReminder3);
            }
        }
        return resultBuilder;
    }

    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder assemblyString = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            assemblyString.append(symbol);
        }
        return assemblyString.toString();
    }

    private String createDivisor(int reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigits(reminderNumber), '-');
    }

    private int calculateDigits(int digits) {
        return (int) Math.log10(digits) + 1;
    }

    private void modifyResultView(StringBuffer resultBuilder, Integer dividend, Integer divisor) {
        int result = dividend / divisor;
        String quotient = String.valueOf(result);
        int[] index = new int[3];
        for (int i = 0, j = 0; i < resultBuilder.length(); i++) {
            if (resultBuilder.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        int tab = calculateDigits(dividend) + 1 - index[0];
        resultBuilder.insert(index[2], assemblyString(tab, ' ') + "|" + quotient);
        resultBuilder.insert(index[1], assemblyString(tab, ' ') + "|" + assemblyString(quotient.length(), '-'));
        resultBuilder.insert(index[0], "|" + divisor);
        resultBuilder.replace(1, index[0], dividend.toString());
    }
}
