package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Initialize variables
    private static int input,usercount=0;



    // Initialize message and password managers
    private static final Messages messages = new Messages();

    private static final UsernameManager usernameManager = new UsernameManager();


    // Initialize arraylist to hold user objects
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        // Display welcome message and prompt user to create an account
        messages.firstWelcomeMessage();
        usernameManager.createUser(usernameManager.users);
        // Display main menu
        Menu();
    }

    /**
     * This method displays the classic menu and handles the user's chosen option
     */
    public static void Menu() {
        // Display welcome back message and classic menu
        Messages.welcomeBack(usernameManager.username);
        Messages.classicMenu();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            try {
                input = Integer.parseInt(inputString);
                switch (input) {
                    case 1:
                        if (usernameManager.countUsers() <= 1) {
                            usernameManager.noUsersToSwitch(usernameManager.users);// Allow user to switch between accounts
                            // if more than one exists

                        } else {
                            usernameManager.login(usernameManager.users);//If there are more than 1 account to switch to
                        }
                        break;
                    // Allow user to change their username
                    case 2:
                        usernameManager.changeUsername();
                        Menu();
                        break;
                    // Allow user to create a new account
                    case 3:
                        usernameManager.createNewAccount();
                        Menu();
                        // Exit the program
                    case 4:
                        endGame();
                        break;
                    // Display an error message for an invalid option
                    default:
                        Messages.invalidOption();
                        break;
                }

            } catch (NumberFormatException e) {
                Messages.invalidOption();
            }

        }

    }


    //Ends game
    public static void endGame(){
        Messages.endGame();
        System.exit(0);
    }
}