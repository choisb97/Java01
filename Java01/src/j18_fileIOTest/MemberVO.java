package j18_fileIOTest;

import java.io.Serializable;

// ** VO (Value Object)
// => setter, getter, toString

// ** 媛앹껜 吏곷젹�솕
// => implements Serializable
// => implements �븞�븯硫� java.io.NotSerializableException 諛쒖깮
public class MemberVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	private String lev;
	private String birthd;
	private int point;
	private double weight;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return id + ", " + password + ", " + name + ", " + lev + ", "
				+ birthd + ", " + point + ", " + weight;
	}
} // class
