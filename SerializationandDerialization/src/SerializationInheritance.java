import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationInheritance {

	public static void main(String[] args) throws Exception{
		
		Dog1 d=new Dog1();
		d.i=100;
		d.j=200;
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(d);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog1 d1=(Dog1) ois.readObject();
		System.out.println(d1.i +"  "+d1.j);

	}

}
class Animal
{

	int i=10;
}

class Dog1 extends Animal implements Serializable{
	
	int j=20;
}