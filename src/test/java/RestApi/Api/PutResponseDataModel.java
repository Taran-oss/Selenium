package RestApi.Api;

import java.util.Objects;

public class PutResponseDataModel {
    String employee_name2;
    String employee_salary2;
    String employee_age2;
    String id;

    public PutResponseDataModel(String employee_name, String employee_salary, String employee_age) {
        this.employee_name2 = employee_name;
        this.employee_salary2 = employee_salary;
        this.employee_age2 = employee_age;
    }

    public static boolean equals(PutResponseDataModel data, PutResponseDataModel data1) {
        return Objects.equals(data.employee_name2, data1.employee_name2) &&
                Objects.equals(data.employee_salary2, data1.employee_salary2) &&
                Objects.equals(data.employee_age2, data1.employee_age2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_name2, employee_salary2, employee_age2);
    }
}
