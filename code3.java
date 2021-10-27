
class code3{

public static void main(String[] args){
  int n=123;
  int last;
  for(int i=0;n!=0;i++){
    last=n%10;
    n=n/10;
    System.out.print(last);
  }
}
}