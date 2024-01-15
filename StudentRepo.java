import java.io.*;
import java.util.List;

public class StudentRepo implements Repository<Student>{


    List<Student> students;
    private static StudentRepo singleton;

    private StudentRepo(List<Student> students) {
        this.students = students;
    }
public static StudentRepo getInstance() throws IOException, ClassNotFoundException {
        if (singleton==null){
            singleton= new StudentRepo(loadData());
        }
        return singleton;
}

    private static List<Student> loadData() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("studentsDb.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (List<Student>) objectInputStream.readObject();
    }

    @Override
    public void save(Student student) {
       students.add(student);
       uploadData();
    }

    private void uploadData() {
        try (        OutputStream outputStream = new FileOutputStream("studentsDb.txt");
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream))
        {
            objectOutputStream.writeObject(students);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List findAll() {
        return students;
    }

    @Override
    public void delete(Student student) {

    }
}
