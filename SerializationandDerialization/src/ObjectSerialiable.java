import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialiable {

	public static void main(String[] args) throws Exception {
	
		Hen h=new Hen();
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(h);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Hen h1=(Hen) ois.readObject();
		System.out.println(h1.c.r.i);

	}

}
class Hen implements Serializable{
	
	Cat c=new Cat();
}
class Cat implements Serializable{
	
	Rat r =new Rat();
	
}
class Rat implements Serializable{
	
	int i=10;
}