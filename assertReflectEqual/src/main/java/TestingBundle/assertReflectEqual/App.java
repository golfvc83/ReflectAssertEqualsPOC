package TestingBundle.assertReflectEqual;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import static org.unitils.reflectionassert.ReflectionAssert.*;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			
	}

	public class LabMouse {

		private String name;
		private int age;
		private double price;
		private Date dob;
		private byte code;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public byte getCode() {
			return code;
		}

		public void setCode(byte code) {
			this.code = code;
		}

	}
}
