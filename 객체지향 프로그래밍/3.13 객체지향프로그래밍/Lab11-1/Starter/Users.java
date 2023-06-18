import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Users implements Iterable<User> {
   List<User> userList = new ArrayList<User>();

   public void addUser(User user) {
    userList.add(user);

   }

   @Override
   public Iterator<User> iterator() {
    return this.userList.iterator();
   }
}
