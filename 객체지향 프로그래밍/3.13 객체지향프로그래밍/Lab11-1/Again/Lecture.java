package Again;
import java.util.Iterator;

public class Lecture<User> implements Iterable<User>{
    int index;
    User[] users = new User[5];

    public Lecture(int size) {
        this.index =0;
        this.users = new User[size];
    }

    public void add(Student e) {
        if(this.index >= students.length) {
            System.out.println("pool is full!");
            return;
        }
        else {
            this.students[this.index++] = e;
        }
    }


    @Override
    public Iterator<Student> iterator() {
        return new LectureIterator<Student>(this);
    }
    
}
