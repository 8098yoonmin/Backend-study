import java.util.*;

public class LectureIterator<Student> implements Iterator<Student>{
    Lecture lecture;
    int index = 0;

    public LectureIterator(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public boolean hasNext() {
        if(lecture.students.length > this.index) {
        return true;
    }   
    else {
        return false;
        }
    }

    @Override
    public Student next() {
        return (Student) lecture.students[this.index++];
    }
}