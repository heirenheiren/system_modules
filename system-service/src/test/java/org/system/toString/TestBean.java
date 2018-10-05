package org.system.toString;

public class TestBean extends BaseBean {
	private int id;
    public int getId() {
       return id;
    }
    public void setId(int id) {
       this.id = id;
    }
    public static void main(String[] args) {
       TestBean testBean = new TestBean();
       testBean.setId(9);
       System.out.println(testBean.toString());
    }
}
