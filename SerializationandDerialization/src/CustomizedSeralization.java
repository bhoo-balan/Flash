import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomizedSeralization {

	public static void main(String[] args) throws Exception {
		
		Account a1=new Account();
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(a1);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Account a2=(Account) ois.readObject();
		System.out.println(a2.name+"   "+a2.pwd +"   "+a2.pin);
	}

}
class Account implements Serializable{
	
	
	String name="boo";
	transient String pwd="balan";
	transient int pin=1234;
	
	private void writeObject(ObjectOutputStream os) throws Exception{
		
		os.defaultWriteObject();
		String epwd="123"+pwd;
		os.writeObject(epwd);
		int eoin=444+pin;
		os.writeObject(eoin);
	}
	
	private void readObject(ObjectInputStream oi) throws Exception{
		
		oi.defaultReadObject();
		String epwd=(String) oi.readObject();
		pwd=epwd.substring(3);
		int epin=(int) oi.readObject();
		pin=epin-444;

	}
	
}
