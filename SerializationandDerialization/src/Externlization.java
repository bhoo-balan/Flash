import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Externlization implements Externalizable  {
	String name;
	int i;
	int j;
	
	public Externlization() {
		
	}
	
	public Externlization(String name, int i, int j) {
	
		this.name = name;
		this.i = i;
		this.j = j;
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	name=(String) in.readObject();
	i=in.readInt();
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(i);
	}
	
	public static void main(String[] args) throws Exception {
		
		Externlization ex=new Externlization("boo",10,20);
		FileOutputStream fos=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(ex);
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Externlization ex1=(Externlization) ois.readObject();
		System.out.println(ex1.name +"  "+ex1.i + "    "+ex1.j);
	}

}

