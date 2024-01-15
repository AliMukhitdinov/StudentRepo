import java.util.List;

public class StudentRepo implements Repository{


    List<Student> students;
    private static StudentRepo singleton;

    private StudentRepo(List<Student> students) {
        this.students = students;
    }
public static StudentRepo getInstance(){
        if (singleton==null){
            singleton= new StudentRepo(loadData());
        }
        return singleton;
}

    private static List<Student> loadData() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void delete(Object o) {

    }
}
