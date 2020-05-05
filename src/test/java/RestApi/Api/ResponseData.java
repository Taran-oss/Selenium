package RestApi.Api;

import java.util.Objects;

public class ResponseData {
    String name;
    String salary;
    String age;
    Integer id;

    public static boolean equals(ResponseData data, ResponseData data1) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ResponseData that = (ResponseData) o;
        return Objects.equals(data.name, data1.name) &&
                Objects.equals(data.salary, data1.salary) &&
                Objects.equals(data.age, data1.age);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }

    public ResponseData(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;

    }
}
