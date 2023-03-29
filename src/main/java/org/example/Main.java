package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String username, password;

    private static int input;
    private static final int userCount = 0;

    private static final Messages messages = new Messages();
    private static final PasswordManager passwordManager = new PasswordManager();
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        //Instances
        messages.firstWelcomeMessage();
        createUser(users);
        Menu();
    }

    /**
     * This handles Classic menu and option which user uses!
     */
    private static void Menu() {
        Messages.welcomeBack(username);
        Messages.classicMenu();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            try {
                input = Integer.parseInt(inputString);
                switch (input) {
                    case 1:
                        if (countUsers() <= 1) {
                            noUsersToSwitch(users);//If there are no accoutns to switch to
                        } else {
                            login(users);//If there are more then 1 account to switch to
                        }
                        break;
                    case 2:
                        changeUsername();
                        Menu();
                        break;
                    case 3:
                        createNewAccount();
                        Menu();
                    case 4:
                        endGame();
                        break;
                    default:
                        Messages.invalidOption();
                        break;
                }

            } catch (NumberFormatException e) {
                Messages.invalidOption();
            }

        }

    }

    /**
     * @createUsers() creates user
     * @While loop check that lenght is no longer then 14 and doesn't contain any special characters
     */
    public static ArrayList<User> createUser(ArrayList<User> users) {
            Scanner scanner = new Scanner(System.in);
            messages.createUsername();
            username = scanner.nextLine();

        // Check if username already exists in list of users
        while (isUsernameTaken(username,users)){
            messages.alreadyExists();
            messages.createUsername();
            username = scanner.nextLine();}


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
     * /
     *
     * @return true or false based if it Username already exists
     * @boolean isUsernameTaken(username - lattest username to be registered also currently used account)
     */
    private static void createNewAccount(){
        messages.letsCreateNewAccount();
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
       while (isUsernameTaken(username,users)){
            messages.alreadyExists();
            messages.createUsername();
            username = scanner.nextLine();}
        password=passwordManager.createPassword();
        passwordManager.confirmPassword(password);
        User newUser = new User(username, password);
        users.add(newUser);
        messages.successfullyCreatedNewAccount(username, password);
        
    }
    private static boolean isUsernameTaken(String username, ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public static int countUsers() {//Counts Users in arraylist
        return users.size();
    }
    /**
     * @changeUser() checks if array list is not empty
     * and checks if option enterd is valid.
     * Then according to chosen option continues actions
     */

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
                Menu();
            case 3:
                endGame();//End game option
            default:
                return null;
        }
    }

    public static void login(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = chooseUser(users); // Choose user from list of users
        username=currentUser.getUsername();
        // Ask user to confirm password
        passwordManager.confirmPassword(password);

        if (password.equals(currentUser.getPassword())) {
            // Password is correct, switch to user's account

            Menu();
        } else {
            // Password is incorrect, stay logged out
            messages.wrongPassword();
            passwordManager.createPassword();
        }
    }
    private static void changeUsername(){
        messages.createUsername();
        Scanner scanner = new Scanner(System.in);
        String newUsername = scanner.nextLine();

        // Validate the new username
        while (newUsername.length() > 15 || !newUsername.matches("[a-zA-Z0-9]+")) {
            Messages.wrongUsername();
            Messages.createUsername();
            newUsername = scanner.nextLine();
        }

        // Check if the new username already exists
        if (isUsernameTaken(newUsername, users)){
            while (isUsernameTaken(newUsername, users)) {
                Messages.alreadyExists();
                Messages.createUsername();
                newUsername = scanner.nextLine();
                while (newUsername.length() > 15 || !newUsername.matches("[a-zA-Z0-9]+")) {
                    Messages.wrongUsername();
                    Messages.createUsername();
                    newUsername = scanner.nextLine();
                }
            }

        }else {
            // loop trough the array list to get the correct username and then setUsername to that user
            users.get(findUserIndex(users,username)-1).setUsername(newUsername);//-1 because index starts with 0

            //username used as current account
            username = newUsername;
            messages.changedUser(username,newUsername);
        }
        // Find the User object that corresponds to the current user

            // Set the new username for the current user
            /**username variable is used as current account when registered
             so when username is changed we must change it too
             */

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


    //Method for user to chooser User
    public static User chooseUser(ArrayList<User> users) {//Is used when choosing other user
        Messages.userListMessage();
        System.out.print("List size:"+users.size()+"\n");
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
    //Ends game
    private static void endGame(){
        Messages.endGame();
        System.exit(0);
    }
}

