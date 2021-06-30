package go;

import java.util.Vector;
 
public class Commute {
    private Vector v = new Vector();
    private Employee e;
   
    //출근 사원 등록
    public void setEnter(String empNo) {
        e = new Employee(empNo);
        v.add(e);
    }
   
    //출근 사원 목록에서 퇴근하는 사원을 제거
    public void setExit(String empNo) {
        for (int i = 0; i < getSize(); i++) {
            Employee emp = (Employee)v.get(i);
            if(emp.getEmpNo().equals(empNo)) {
                v.remove(i);
                return;
            }
        }
    }
   
    //벡터의 크기를 반환. 출근한 사원의 수
    public int getSize() {
        return v.size();
    }
   
    //인덱스값으로 벡터에 저장된 데이터를 반환
    public Employee getData(int i) {
        return (Employee)v.get(i);
    }
}