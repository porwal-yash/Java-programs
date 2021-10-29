import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

class bulletthread extends Thread
{
int a,z,d;
public void run()
{
a=game.p1.x;
d=game.p1.y;
a+=23;  
d+=55;
Button b=new Button();
try
{
z=game.p1.z;
z=z%360;
for(int i=0;i<=1000;i+=5) 
{
if (z>0 && z<90){
b.setBounds(a+(z*i)+15,d-i+10,10,10);}
if (z>=90 && z<180){
b.setBounds(a+(z*i)+15,d+i+10,10,10);}
if (z>=180 && z<270){
b.setBounds(a-(z*i)+15,d+i+10,10,10);}
if (z>=270 && z<360){
b.setBounds(a-(z*i)+15,d-i+10,10,10);}




game.f.add(b);
Thread.sleep(130);
}
}
catch(Exception e)
{
}
}
}

class scorethread extends Thread{
public void run(){
try{
String str="Health->";
while(timethread.i!=0){
String str1=new String();
str1=str1+str+game.li.get(0)+"...";
game.l1.setText(str1);
if(game.li.get(0)<=0)
{
str1=new String();
Thread.sleep(700);
str1=str1+str+"0"+"...";
game.l1.setText(str1);
break;}
}
int x=JOptionPane.showConfirmDialog(null,"You Lost,Want to Restart");
if (x==0){
timethread.i=600;
game.li.set(0,100);
run();
}
if (x==2){
game.l1.setText("Close to Exit, Health:0");
}
if (x==1){
game.f.dispose();
}
}
catch(Exception e){}
}
}


class timethread extends Thread{
static int i=600;
public void run(){
try{
while(i!=0){
game.l2.setText("Time->"+(i/60)+":"+(i-((i/60)*60)));
i--;
Thread.sleep(1000);
}
game.l2.setText("Time Up!!!");
Thread.sleep(1000);
int x=JOptionPane.showConfirmDialog(null,"Want to Restart");
if (x==0){
timethread.i=600;
game.li.set(0,100);
run();
}
if (x==2){
game.l2.setText("Close to Exit, Timeleft:0");
}
if (x==1){
game.f.dispose();
}
}
catch(Exception e){}
}}
class MyPanel extends JPanel{
int x=20;
int y=480;
int z;
ArrayList<Rect> lob=new ArrayList<>();

public void paint(Graphics g){
super.paint(g);
Graphics2D g2d = (Graphics2D)g;
g2d.setColor(Color.green);
if(x>=100 && x<=180 && y<=180 && y>=100)
{game.li.set(0,game.li.get(0)-20);
x+=30;
y+=30;
}
if(x+40>=100 && x<=180 && y<=180 && y+40>=100)
{game.li.set(0,game.li.get(0)-20);
x-=30;
y-=30;
}

Rectangle rect3 = new Rectangle(100,100,80,80);

g2d.draw(rect3);
g2d.fill(rect3);
Rectangle rect2 = new Rectangle(x,y,40,40);
g2d.rotate(Math.toRadians(z),x+20,y+20);
g2d.draw(rect2);
g2d.fill(rect2);
g2d.setColor(Color.red);

Rectangle rect1 = new Rectangle(x+15,y-10,10,30);
g2d.draw(rect1);
g2d.fill(rect1);

}
}

class Rect
{
int x,y;
Rect(int x,int y)
{
this.x=x;
this.y=y;
}
}

class game implements KeyListener{
static Frame f;
Panel p;
static MyPanel p1;
static Label l1,l2;
static ArrayList<Integer> li;
static int aa;
static bulletthread bt;
game()
{
f=new Frame();
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e){
f.dispose();
}});
f.addKeyListener(this);
p=new Panel();
p1=new MyPanel();
Rect r=new Rect(100,100);
p1.lob.add(r);
l1=new Label();
l2=new Label();
li=new ArrayList<>();
p1.setBackground(Color.blue);
li.add(100);
li.add(90);
l2.setFont(new Font("Arial",1,20));
l1.setFont(new Font("Arial",1,20));
timethread t1=new timethread();
t1.start();
scorethread t2=new scorethread();
t2.start();
p.add(l1);
p.add(l2);
p1.setLayout(new FlowLayout());
p.setLayout(new FlowLayout());

f.add(p,BorderLayout.NORTH);
f.add(p1);
f.setSize(600,600);
f.setVisible(true);
}
public void keyPressed(KeyEvent e){
int c=e.getKeyCode();
//System.out.println(c);
if (c==32){
bt=new bulletthread();
bt.start();
}
if (c==50)
p1.z+=10;
if (c==49)
p1.z-=10;
if (c==37)
p1.x-=10;
if (c==38)
p1.y-=10;
if (c==39)
p1.x+=10;
if (c==40)
p1.y+=10;
if ((p1.x>5 && p1.x<540 && p1.y<480 && p1.y>5)||(c==50 || c==49)){
Rect r;
r=new Rect(p1.x,p1.y);
p1.lob.add(r);
aa+=1;
p1.repaint();}
else{
if (c==37)
p1.x+=10;
if (c==38)
p1.y+=10;
if (c==39)
p1.x-=10;
if (c==40)
p1.y-=10;
}
}

public void keyReleased(KeyEvent e){
}

public void keyTyped(KeyEvent e){
}
public static void main(String ar[]){
new game();
}
}