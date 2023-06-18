import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, "Celine",30);
        User user2 = new User(2, "Alabama", 20);
        User user3 = new User(3, "Paloma", 10);
        User user4 = new User(4, "Vesper", 20);
        User user5 = new User(5, "Clementine", 30);

        // List<User> list = new ArrayList<User>() {
        //     {
        //         add(user1);
        //         add(user2);
        //         add(user3);
        //         add(user4);
        //         add(user5);

        //     }
        // };

        Users users = new Users();
        users.addUser(user1);
        users.addUser(user2);
        users.addUser(user3);
        users.addUser(user4);
        users.addUser(user5);

        for(User u:users) {
            System.out.println(u);
        }

        // for(User u : list){
        //     System.out.println(u);
        // }

        // Collections.sort(list);//new DesendingOrder());
        // for(User o : list) {
        //     System.out.println(o);
        // }

        //foreach문이 default로 선언돼있음 
        // users.forEach((item)-> System.out.println(item));
        
    }
}
