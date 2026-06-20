import java.util.ArrayList;
import java.util.Scanner;

public class WalletService {

    public User findUser(ArrayList<User> users, String name){
      return users.stream()
              .filter(u -> u.getName().equalsIgnoreCase(name))
              .findFirst()
              .orElse(null);

    }
}
