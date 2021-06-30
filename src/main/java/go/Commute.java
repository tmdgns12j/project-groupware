package go;

import java.util.Vector;
 
public class Commute {
    private Vector v = new Vector();
    private Employee e;
   
    //��� ��� ���
    public void setEnter(String empNo) {
        e = new Employee(empNo);
        v.add(e);
    }
   
    //��� ��� ��Ͽ��� ����ϴ� ����� ����
    public void setExit(String empNo) {
        for (int i = 0; i < getSize(); i++) {
            Employee emp = (Employee)v.get(i);
            if(emp.getEmpNo().equals(empNo)) {
                v.remove(i);
                return;
            }
        }
    }
   
    //������ ũ�⸦ ��ȯ. ����� ����� ��
    public int getSize() {
        return v.size();
    }
   
    //�ε��������� ���Ϳ� ����� �����͸� ��ȯ
    public Employee getData(int i) {
        return (Employee)v.get(i);
    }
}