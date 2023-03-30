package org.example;

import java.util.Scanner;

public class PasswordManager {
    private static int incorrectPasswordAttempts = 0;

    public static String createPassword() {
        Scanner scanner = new Scanner(System.in);
        String password;
        Messages messages = new Messages();

        while (true) {
            Messages.createPassword();
            password = scanner.nextLine();
            if (password.length() <= 15 && password.matches("[a-zA-Z0-9]+")) {
                return password;
            } else {
                Messages.tooLongPassword();
            }
        }
    }

    public static String confirmPassword(String password) {
        Scanner scanner = new Scanner(System.in);
        Messages messages = new Messages();
        String confirmedPassword;

        while (true) {
            Messages.confirmNewPassword();
            confirmedPassword = scanner.nextLine();

            if (password.equals(confirmedPassword)) {
                return password;
            } else {
                incorrectPasswordAttempts++;
                if (incorrectPasswordAttempts >= 3) {
                    Messages.wrong3TimesPassword();
                    while (true) {
                        String inputString = scanner.nextLine();
                        int input = Integer.parseInt(inputString);
                        if (input == 1) {
                            incorrectPasswordAttempts = 0;
                            break;
                        } else if (input == 2) {
                            Messages.endGame();
                            System.exit(0);
                        } else {
                            Messages.invalidOption();
                        }
                    }
                } else {
                    Messages.incorrectConfirmPassword();
                }
            }
        }
    }
}



