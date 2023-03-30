package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UsernameManager {

    public static String username,password;

    private static final Messages messages = new Messages();

    private static final PasswordManager passwordManager = new PasswordManager();

    private static final Main main = new Main();

    static ArrayList<User> users = new ArrayList<>();


    public static User chooseUser(ArrayList<User> users) {//Is used when choosing other user
        Messages.userListMessage();
        for (int i = 0; i < users.size(); i++) {
            String printOutUsers = (users.get(i).getUsername());

            System.out.println((i + 1) + ". " + printOutUsers);

        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > users.size()) {
            messages.invalidOption();
            choice = scanner.nextInt();
        }
        return users.get(choice - 1);
        // because index starts with 0
    }



    public static void login(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = chooseUser(users); // Choose user from list of users
        username = currentUser.getUsername();
        // Ask user to confirm password
        passwordManager.confirmPassword(password);

        if (password.equals(currentUser.getPassword())) {
            // Password is correct, switch to user's account

            main.Menu();
        } else {
            // Password is incorrect, stay logged out
            messages.wrongPassword();
            passwordManager.createPassword();
        }
    }



    /**
     * This method prompts the user to create a new account
     * It ensures that the username is not already taken and that the password is entered correctly
     */
    public static ArrayList<User> createUser(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        messages.createUsername();
        username = scanner.nextLine();

        // Check if username already exists in list of users
        while (isUsernameTaken(username, users)) {
            messages.alreadyExists();
            messages.createUsername();
            username = scanner.nextLine();
        }


        //Check if password is correctly passed
        password = passwordManager.createPassword();
        passwordManager.confirmPassword(password);

        // Create new user object and add it to list of users
        User newUser = new User(username, password);
        users.add(newUser);
        messages.successfullyCreatedNewAccount(username, password);
        return users;
    }

    /**
     * This method checks whether a given username already exists in the list of users
     * @param username the username to check
     * @param users the list of users to check against
     * @return true or false based on whether the username already exists
     */
    private static boolean isUsernameTaken(String username, ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }



    /**
     * /
     *
     * @return true or false based if it Username already exists
     * @boolean isUsernameTaken(username - lattest username to be registered also currently used account)
     */
    public static void createNewAccount() {
        messages.letsCreateNewAccount();
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
        while (isUsernameTaken(username, users)) {
            messages.alreadyExists();
            messages.createUsername();
            username = scanner.nextLine();
        }
        password = passwordManager.createPassword();
        passwordManager.confirmPassword(password);
        User newUser = new User(username, password);
        users.add(newUser);
        messages.successfullyCreatedNewAccount(username, password);

    }

    public static void changeUsername() {
        messages.createUsername();
        Scanner scanner = new Scanner(System.in);
        String newUsername = scanner.nextLine();

        if (isUsernameTaken(newUsername, users)) {
            Messages.alreadyExists();
            changeUsername();
        }else if (newUsername.length() > 15 || !newUsername.matches("[a-zA-Z0-9]+")) {
            Messages.wrongUsername();
            Messages.createUsername();
            changeUsername();
        } else {




            //Loops trough the array list to get the correct username and then setUsername to that user
            users.get(findUserIndex(users, username)).setUsername(newUsername);


            messages.changedUser(username, newUsername);

            //username used as current account
            username = newUsername;
        }
    }

    /**
     * This method counts the number of users in the arraylist
     * @return the number of users in the arraylist
     */
    public static int countUsers() {//Counts Users in arraylist
        return users.size();
    }

    //Loops threw arraylist to find index of object that contains username
    public static int findUserIndex(ArrayList<User> userList, String username) {
        int i;
        for (i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return i;
    }
    public static User noUsersToSwitch(ArrayList<User> users) {
        Messages.noUsersSwitch();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option < 1 || option > 3) {
            messages.invalidOption();
            option = scanner.nextInt();
        }
        switch (option) {
            case 1:
                createUser(users);//Create new User option
            case 2:
                main.Menu();
            case 3:
                main.endGame();//End game option
            default:
                return null;
        }
    }




}
