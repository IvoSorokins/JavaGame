package org.example;


public class Messages {
    //used to Create colorfull text
    public static final String ANSI_GREEN = "\u001B[32m";//Green color set
    public static final String ANSI_RED = "\033[1;31m";//Red color set

    public static final String ANSI_YELLOW = "\u001B[33m";//Yellow color set

    public static final String ANSI_AMARANTH = "\u001B[38;2;219;47;105m";//Amaranth color set

    public static final String ANSI_VERMILION = "\u001B[38;2;227;66;52m";//Vermilion color set

    public static final String ANSI_ORANGE = "\u001B[38;2;255;165;0m";//Orange color set

    public static final String ANSI_BLUE ="\033[1;34m";//Blue color set

    public static final String ANSI_WHITE ="\033[0;97m";//White color set

    public static final String ANSI_CYAN = "\033[0;96m";//Cyan color set

    public static final String ANSI_PURPLE = "\033[1;95m";//Purple color set
    public static final String ANSI_RESET = "\u001B[0m";//Color reset


    private static final String terminalBorder = ANSI_YELLOW + "================================" + ANSI_RESET;

    public static void terminalBorder() {
        System.out.print(terminalBorder + "\n");
    }


    //All account messages
    public static void letsCreateNewAccount(){
        System.out.print(ANSI_ORANGE+"Let's create new Account!"+ANSI_RESET);
    }
    public static void firstWelcomeMessage() {
        System.out.print(terminalBorder + ANSI_GREEN+"\nWelcome"+ANSI_ORANGE+" to"+ANSI_PURPLE+ " the"+ANSI_BLUE+ " Login Game!"+ANSI_WHITE+"\nLets Create your first account!"+ANSI_RESET);
    }

    public static void successfullyCreatedNewAccount(String username, String password) {
        System.out.print(terminalBorder + "\nNew account with \nUsername:" + username +
                "\nPassword:" + password + ANSI_GREEN + "\nCreated succesfully!\n" + ANSI_RESET+terminalBorder);
    }
    //Password messages

    public static void createPassword() {
        System.out.print(ANSI_WHITE+"Enter your new password:"+ANSI_RESET);
    }
    public static void confirmNewPassword() {
        System.out.print(terminalBorder + ANSI_WHITE +"\nReEnter password to confirm:"+ANSI_RESET);
    }

    public static void wrongPassword() {
        System.out.print(ANSI_RED + "Wrong Password!\n" + ANSI_RESET + "Try again!\n");
    }

    public static void wrong3TimesPassword() {
        System.out.print(terminalBorder + "\nAre you sure you remember your password?\n1.Try again" +
                ANSI_AMARANTH + "\n2.End Game\n" + ANSI_RESET);
    }

    public static void incorrectConfirmPassword() {
        System.out.print(ANSI_RED + "New password is incorrect!" + ANSI_RESET + "\nTry Again!\n");
    }

    public static void tooLongPassword() {
        System.out.print("Hey!\nCalm down, it's just a game!\nThink of something simple!\n");
    }


    //Username messages


    public static void userListMessage(){
        System.out.print(ANSI_VERMILION+"Select User:\n"+ANSI_RESET);//Made here becaus of colorfull text
    }

    public static void noUsersSwitch() {
        System.out.println(terminalBorder + "\nNo users to switch to."+
                ANSI_YELLOW+"\nWhat would you like to do?\n"+ANSI_RESET+
                ANSI_PURPLE+"1. Create a new user\n"+ANSI_RESET+
                "2."+ANSI_BLUE+" Do nothing\n"+ANSI_RESET+
                ANSI_AMARANTH + "3. End the game" + ANSI_RESET);

    }

    public static void alreadyExists(){
        System.out.print(ANSI_RED+"\nUsername with this name already exists!"+ANSI_RESET+"\nTry another one!");
    }

    public static void changedUser(String username,String newUsername){
        System.out.println(ANSI_GREEN+"Username changed from "+username+"  to "+newUsername+" successfully!"
                +ANSI_RESET+"\n"+terminalBorder);
    }

    public static void wrongUsername() {
        System.out.print("Hmmmm.....\nIt's too long or contains strange characters!\nThink of something smaller!");
    }
    public static void createUsername(){
        System.out.print(ANSI_WHITE+"\nPlease Enter new username:"+ANSI_RESET);
    }


    public static void welcomeBack(String username) {
        System.out.print(ANSI_ORANGE+"\nWelcome back "+ANSI_GREEN + username +ANSI_ORANGE+ "!"+ANSI_RESET);
    }


    //All Menu messages
    public static void classicMenu() {
        System.out.print(ANSI_YELLOW+"\nWhat would you like to do?"+ANSI_RESET+"\n1."+ANSI_PURPLE+"Change User"+ANSI_RESET+"\n2."+ANSI_BLUE+"Change Username\n"+ANSI_RESET+
                ANSI_CYAN+"3.Create a new user"+ANSI_RESET+"\n4."+ANSI_AMARANTH+"End Game\n"+ANSI_RESET);
    }

    public static void invalidOption(){
        System.out.print(terminalBorder+ANSI_RED+"\nIncorrect option!\nTry again!\n"+ANSI_RESET);
    }
    public static void endGame(){
        System.out.print(terminalBorder +ANSI_WHITE+"\nThanks for playing!\nBYE!\n"+ANSI_RESET+terminalBorder);
    }

}

