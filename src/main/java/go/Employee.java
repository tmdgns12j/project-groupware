package go;



public class Employee {
    private String empNo;
    private long enterTime;
   
    public Employee() {}
    public Employee(String empNo) {
        this.empNo = empNo;
        this.enterTime = System.currentTimeMillis(); //�����͸� �и��ʷ� ����
    }
   
    public String getEmpNo() {
        return empNo;
    }
    public long getEnterTime() {
        return enterTime;
    }
   
}