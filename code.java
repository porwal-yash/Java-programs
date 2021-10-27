//
//call by reference or object reference

class obj_ref
{
int a=10;
int b=20;
  void swap(int x,int y)   
  {
    int t;
     t=x;
     x=y;
     y=t;
   }
   public static void main(String[] a1) {
        obj_ref o1=new obj_ref();
        o1.swap(o1.a,o1.b);   
        System.out.println("A ="+o1.a);
        System.out.println("B ="+o1.b);
     }
}
