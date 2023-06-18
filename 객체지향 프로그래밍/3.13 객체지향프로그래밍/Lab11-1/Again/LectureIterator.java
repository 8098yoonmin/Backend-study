package Again;

import java.util.Iterator;

public class LectureIterator<User> implements Iterator<User> {
    Lecture lecture;
    int index = 0;

    public LectureIterator(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public boolean hasNext() {
        if(lecture.users.length > this.index){ 
        }
        else {
            return false;
        }
        return false;
    }

    @Override
    public User next() {
        return lecture.users[this.index++];
    }
}
