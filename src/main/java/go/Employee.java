package go;



public class Employee {
    private String empNo;
    private long enterTime;
   
    public Employee() {}
    public Employee(String empNo) {
        this.empNo = empNo;
        this.enterTime = System.currentTimeMillis(); //데이터를 밀리초로 저장
    }
   
    public String getEmpNo() {
        return empNo;
    }
    public long getEnterTime() {
        return enterTime;
    }
   
}