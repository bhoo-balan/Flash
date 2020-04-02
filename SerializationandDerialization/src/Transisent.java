import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Transisent {
	
	public static void main(String[] args) throws Exception {
		
		Student s=new Student();
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=	new ObjectOutputStream(fos);
		oos.writeObject(s);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Student s2=(Student) ois.readObject();
		System.out.println(s2.name +"  "+s2.pass);
		
	}

}
class Student  implements Serializable {
	
	String name="boo";
	//only for variables
	//declare static variable and final varibale as transisent no use
	//static varibale not part of object not practipate in serialxiaiton
	//final part direct value in serizaltion in compile time it will assign the value as final
	transient String pass="boo";
}