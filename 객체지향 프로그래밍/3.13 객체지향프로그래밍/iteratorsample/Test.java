public class Test {
   public static void main(String[] args) {
    Lecture lecture = new Lecture(5);
    lecture.add(new Student(1, "Celine"));
    lecture.add(new Student(2, "Vesper")); 
    lecture.add(new Student(3, "Paloma"));
    lecture.add(new Student(4, "Yoom"));

    //lecture을 foreach문에 돌리기 위해 implements Iterable 실행
    
    LectureIterator iterator = (LectureIterator) lecture.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next());
    }

   }
}
