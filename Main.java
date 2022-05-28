import javax.swing.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Main {
    public static Scanner Get_Input = new Scanner(System.in);
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        while (true){
            User NowUser = null;
            boolean IsWorking = false;
            int Entry = Command(new String[]{"Login","Sign up"});
            switch (Entry){
                case 1:
                    NowUser = Entrance.Login();
                    IsWorking = true;
                    break;
                case 2:
                    NowUser = Entrance.SignUp();
                    IsWorking = true;
                    break;
            }

            while (IsWorking){
                int Command = Main.Command(new String[]{"See my user page","See my home page","See my chat page" , "See a User Page" , "Logout"});

                switch (Command){
                    case 1: // user page
                        NowUser.MyInfo();
                        break;

                    case 2: // home page
                        NowUser.HomePage();
                        break;

                    case 3:
                        boolean StartChat = true;

                        while (StartChat) {
                            Command = Main.Command(new String[]{"Create new chat", "Show old chats", "Back"});

                            switch (Command) {
                                case 1:
                                    Chat.CreatGroup(NowUser);
                                    break;

                                case 2:
                                    Chat.OpenGroups(NowUser);
                                    break;

                                case 3:
                                    StartChat = false;
                                    break;
                            }
                        }
                        break;

                    case 4:
                        NowUser.UserInfo();
                        break;

                    case 5:
                        IsWorking = false;
                        NowUser = null;
                        break;
                }
            }

        }
    }

    static int Command(String[] Options) {
        String[] comm = new String[Options.length];
        for (int option = 0; option < Options.length; option++) {
            int option_num = option+1;
            comm[option]=("For " + Options[option] + " enter " + option_num + "\n");
        }
        return Integer.parseInt(JOptionPane.showInputDialog(comm));
    }
}
