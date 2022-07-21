package assistedprojects;


class studentinfo{
	  int id;
	  String name;
	studentinfo()  //default constructor
	{
	  id=2345433;
	  name= "Manav";
	}
	studentinfo(int a,String b) //parameterised constructor
	  {
	  id=a;
	  name=b;
	  }
	void display() {
	  System.out.println(id+" "+name);
	  }

	}
public class constructors {
	public static void main(String[] args) {

		  studentinfo std1=new studentinfo();
		  studentinfo std2=new studentinfo();
		  studentinfo std3=new studentinfo(2,"Alex");
		  studentinfo std4=new studentinfo(10,"Annie");

		  std1.display();
		  std2.display();
		  std3.display();
		  std4.display();
		  }
}
