
//call by reference or object reference

class Operation2{  
 int datax=50;  
  
 void change(Operation2 opp){  
 opp.datax=opp.datax+100;//changes will be in the instance variable  
 }  
     
    
 public static void main(String args[]){  
   Operation2 opp=new Operation2();  
  
   System.out.println("before change "+opp.datax);  
   opp.change(opp);//passing object  
   System.out.println("after change "+opp.datax);  
  
 }  
}  
