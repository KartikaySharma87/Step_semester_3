public class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee ce1 = new CompanyEmployee("Asha", 40000);
        CompanyEmployee ce2 = new CompanyEmployee("Ravi", 45000);
        CompanyEmployee ce3 = new CompanyEmployee("Neha", 50000);

        CompanyEmployee.printCompanyInfo();
    }
}