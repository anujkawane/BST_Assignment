import com.akawane0813.model.Student;

import java.util.Arrays;
import java.util.List;

public class TestData {

    private List<Student> testData= Arrays.asList(
            new Student(90105, "George", "Jones", 3.59),
            new Student(90103, "Susan", "Smith", 3.67),
            new Student(90102, "Kevin", "Williams",3.23),
            new Student(90104, "Anthony", "Harris",2.49),
            new Student(90101, "AnIan", "Vazquezuj",3.99),
            new Student(90106, "Kristy", "Williams",4.0),
            new Student(90107, "Katherine", "Hurst",3.08),
            new Student(90108, "Stacey", "Gordon",2.79),
            new Student(90109, "Catherine", "Green",4.0),
            new Student(90110, "Jessica", "Martin",3.99)
    );

    public List<Student> getTestData() {
        return testData;
    }

}
