import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialzationandDesriazation {

	public static void main(String[] args) throws Exception {
		
		Dog2 d1=new Dog2();
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(d1);
		
		FileInputStream fis= new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog2 d2=(Dog2) ois.readObject();
		System.out.println(d2.i +"   "+d2.j);

	}

}
class Dog2 implements Serializable
{
	
	int i=10;
	int j=20;
}