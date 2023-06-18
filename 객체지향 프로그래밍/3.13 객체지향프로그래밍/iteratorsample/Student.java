public class Student {
    private int studentNo;
    private String name;
    private String department;
    private String address;

    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}