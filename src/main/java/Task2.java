import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    // 2. Создать класс Employee (Сотрудник) с полями:
    // String name, int age, double salary, String department
    static class Employee {
        private String name;
        private int age;
        private double salary;
        private String department;

        public Employee() {}

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    // 2.1 Создать список из 10-20 сотрудников
    private static List<Employee> generateListOfEmployees() {
        return List.of(
                new Employee("Иванов Иван", 25, 70_000, "Aftersales"),
                new Employee("Петров Петр", 35, 80_000, "Aftersales"),
                new Employee("Сидоров Сидор", 38, 90_000, "Aftersales"),
                new Employee("Иванова Анна", 22, 7_000, "Accounting"),
                new Employee("Перова Инна", 24, 100_000, "Accounting"),
                new Employee("Сидорова Яна", 21, 70_000, "Accounting"),
                new Employee("Филимонов Филипп", 30, 80_000, "Service"),
                new Employee("Гусев Иван", 34, 80_000, "Service"),
                new Employee("Уткин Алексей", 28, 80_000, "Service"),
                new Employee("Воробьев Андрей", 31, 8_000, "Service"),
                new Employee("Гусева Мария", 26, 75_000, "Reception"),
                new Employee("Уткина Галина", 24, 75_000, "Reception"),
                new Employee("Филимонова Ирина", 23, 9_000, "Reception"),
                new Employee("Мишин Михаил", 32, 70_000, "Diagnostics"),
                new Employee("Алексеев Алексей", 33, 70_000, "Diagnostics"),
                new Employee("Антонов Антон", 29, 70_000, "Diagnostics")
        );
    }


    public static void main(String[] args) {
        List<Employee> employees = generateListOfEmployees();

        // 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println(
                employees.stream()
                        .map(Employee::getDepartment)
                        .distinct()
                        .toList()
        );

        // 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream()
                .filter(it -> it.getSalary() < 10_000)
                .forEach(it -> it.setSalary(it.getSalary() * 1.2));
        System.out.println(employees);

        // 2.4* Из списка сотрудников с помощью стрима создать Map<String, List<Employee>>
        // с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> map1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(map1);

        // 2.5* Из списока сорудников с помощью стрима создать Map<String, Double>
        // с отделами и средней зарплатой внутри отдела
        Map<String, Double> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map2);
    }




}
