import java.util.Scanner;

class program {

  String name;
  int teacher_id;
  String subject;

  teacher() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter  the  name:  ");
    name = sc.nextLine();
    System.out.print("\nEnter  teacher  id:  ");
    teacher_id = sc.nextInt();
    System.out.print("\nChoose  the  type\n1.  Programming\n2.Theory\n");
    int opt = sc.nextInt();
    if (opt == 1)
      subject = "Artificial Intelligence";
    else
      subject = "Design and Analysis of Algorithms";
  }

  public void output() {
    System.out.println("Name:  " + name);
    System.out.println("Teacher  ID:  " + teacher_id);
    System.out.println("Subject:  " + subject);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    teacher t[] = new teacher[100];
    System.out.println("Enter  number  of  teachers  (maximum  100):  ");
    int n = sc.nextInt();
    
    for (int i = 0; i < n; i++)
      t[i] = new teacher();
    
    for (int i = 0; i < n; i++)
      t[i].output();
  }
}
