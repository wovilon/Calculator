

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import static java.lang.Math.sqrt;
import javax.swing.*;



public class Calculator {
static JFrame Frame;
static JButton Bt1,Bt2,Bt3,Bt4,Bt5,Bt6,Bt7,Bt8,Bt9,Bt0,BtPoint;
static JButton BtOff,BtCe,BtC,BtPlusMinus,BtSqrt,BtPlus,BtMinus,BtMultiplie,BtDivide;
static JButton BtPercent,Bt1x,BtEqual;
static JTextField Screen;
static double x=0,y=0,res; //opetated values x+y=res
static boolean xSelected=false, ySelected=false;
static boolean EP=false; //equal button pressed sign
static boolean AP=false; //action (+,-,*,/) have just been performed
static String str; //text on screen
static String act; //action type (+,-,*,/)
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ScreenWidth=(int) screenSize.getWidth(); //screen size for frame
        int ScreenHeight=(int) screenSize.getHeight();
        int width=400, height=330;// frame sizes
        int w=60,h=30, dw=10, dh=10; //button and between sizez
        Frame=new JFrame("Calculator");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(null);
        Frame.setBounds(ScreenWidth/2-200,200,width,height);
        Frame.setVisible(true);
        Frame.setResizable(false);
        
        Screen=new JTextField("0");
        Screen.setHorizontalAlignment(JTextField.RIGHT);
        Screen.setBounds((width-w*5-dw*4)/2-8,30,w*5+dw*4,50);
        Screen.setFont(new Font("Arial",Font.PLAIN,30));
        
        Frame.add(Screen);
        
BtOff=new JButton("Off");
BtOff.setBounds((width-w*5-dw*4)/2-8,90,w,h);
BtOff.addActionListener(new ActionListener(){@Override  public void actionPerformed(ActionEvent e){
System.exit(0);}}); Frame.add(BtOff);
              
BtCe=new JButton("CE");
BtCe.setBounds((width-w*5-dw*4)/2-8+w*1+dw*1,90,w,h);
BtCe.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
str=null; Screen.setText("0");}});  Frame.add(BtCe);
        
BtC=new JButton("C");
BtC.setBounds((width-w*5-dw*4)/2-8+w*2+dw*2,90,w,h);
BtC.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
x=y=0; str=null;Screen.setText("0"); act=null; xSelected=false; ySelected=false; EP=false; 
}});  Frame.add(BtC);     



char ch=0xb1; String st=ch+"";
BtPlusMinus=new JButton(st);
BtPlusMinus.setBounds((width-w*5-dw*4)/2-8+w*3+dw*3,90,w,h);
BtPlusMinus.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (str!=null) x=Double.parseDouble(str);

xSelected=true; act="+-"; Action(); EP=false;
  }});   Frame.add(BtPlusMinus); 

ch=0x3c; st=ch+"";
BtSqrt=new JButton("Sqrt"); 
BtSqrt.setBounds((width-w*5-dw*4)/2-8+w*4+dw*4,90,w,h);
BtSqrt.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (str!=null) { x=Double.parseDouble(str);}
if(x>=0) { xSelected=true; act="Sqrt"; Action(); EP=false;}
else {Screen.setText("No root!");x=0;y=0;}
   }});   Frame.add(BtSqrt); 



Bt7=new JButton("7");
Bt7.setBounds((width-w*5-dw*4)/2-8,90+h*1+dh*1,w,h);
Bt7.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="7"; AP=false;}
else if(str==null) {str="7";}  else str+=7; 
Screen.setText(str);}});  Frame.add(Bt7); 

Bt8=new JButton("8");
Bt8.setBounds((width-w*5-dw*4)/2-8+w*1+dw*1,90+h*1+dh*1,w,h);
Bt8.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="8"; AP=false;}
else if(str==null) {str="8";}  else str+=8; 
Screen.setText(str);}});  Frame.add(Bt8);  

Bt9=new JButton("9");
Bt9.setBounds((width-w*5-dw*4)/2-8+w*2+dw*2,90+h*1+dh*1,w,h);
Bt9.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
   if (AP==true) {str="9"; AP=false;}
else  if(str==null) {str="9";}  else str+=9; 
Screen.setText(str);}});  Frame.add(Bt9);  

BtDivide=new JButton("/");
BtDivide.setBounds((width-w*5-dw*4)/2-8+w*3+dw*3,90+h*1+dh*1,w,h);
BtDivide.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
try{if (xSelected==false) {x=Double.parseDouble(str); xSelected=true; act="/";str=null; EP=false;}
else {{if (EP==false) {y=Double.parseDouble(str); Action(); act="/"; str=null;}} ySelected=true; EP=false;
   }}catch(NullPointerException e3){} }});  Frame.add(BtDivide);  

    
   
BtPercent=new JButton("%");
BtPercent.setBounds((width-w*5-dw*4)/2-8+w*4+dw*4,90+h*1+dh*1,w,h);
BtPercent.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
try{if (xSelected==false) {x=Double.parseDouble(str); xSelected=true; act="%";str=null; EP=false;}
else {{if (EP==false) y=Double.parseDouble(str);}  act="%"; str=null; ySelected=true; EP=false;
   }}catch(NullPointerException e3){} }});  Frame.add(BtPercent);  


 
Bt4=new JButton("4");
Bt4.setBounds((width-w*5-dw*4)/2-8,90+h*2+dh*2,w,h);
Bt4.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="4"; AP=false;}
else if(str==null) {str="4";}  else str+=4; 
Screen.setText(str);}});  Frame.add(Bt4); 

Bt5=new JButton("5");
Bt5.setBounds((width-w*5-dw*4)/2-8+w*1+dw*1,90+h*2+dh*2,w,h);
Bt5.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="5"; AP=false;}
else if(str==null) {str="5";}  else str+=5; 
Screen.setText(str);}});  Frame.add(Bt5);  

Bt6=new JButton("6");
Bt6.setBounds((width-w*5-dw*4)/2-8+w*2+dw*2,90+h*2+dh*2,w,h);
Bt6.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="6"; AP=false;}
else if(str==null) {str="6";}  else str+=6; 
Screen.setText(str);}});  Frame.add(Bt6);  

BtMultiplie=new JButton("*");
BtMultiplie.setBounds((width-w*5-dw*4)/2-8+w*3+dw*3,90+h*2+dh*2,w,h);
BtMultiplie.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
 try{
if (xSelected==false) {x=Double.parseDouble(str); xSelected=true; act="*";str=null; EP=false;}
else {if (EP==false) {y=Double.parseDouble(str); Action(); act="*";  AP=true;}
else act="*"; ySelected=false; EP=false;
   }}catch(NullPointerException e1){} }});  Frame.add(BtMultiplie);  

   
   
Bt1x=new JButton("1/x");
Bt1x.setBounds((width-w*5-dw*4)/2-8+w*4+dw*4,90+h*2+dh*2,w,h);
Bt1x.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (str!=null) { x=Double.parseDouble(str);}
if(x>=0) { xSelected=true; act="1/x"; Action(); EP=false;}
else {Screen.setText("No root!");x=0;y=0;}
   }});   Frame.add(Bt1x); 


   

Bt1=new JButton("1");
Bt1.setBounds((width-w*5-dw*4)/2-8,90+h*3+dh*3,w,h);
Bt1.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="1"; AP=false;}
else if(str==null) {str="1";}  else str+=1; 
Screen.setText(str);}});  Frame.add(Bt1);  

Bt2=new JButton("2");
Bt2.setBounds((width-w*5-dw*4)/2-8+w*1+dw*1,90+h*3+dh*3,w,h);
Bt2.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="2"; AP=false;}
else if(str==null) {str="2";}  else str+=2; 
Screen.setText(str);}});  Frame.add(Bt2);  

Bt3=new JButton("3");
Bt3.setBounds((width-w*5-dw*4)/2-8+w*2+dw*2,90+h*3+dh*3,w,h);
Bt3.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if (AP==true) {str="3"; AP=false;}
else if(str==null) {str="3";}  else str+=3; 
Screen.setText(str);}});  Frame.add(Bt3);  

BtMinus=new JButton("-");
BtMinus.setBounds((width-w*5-dw*4)/2-8+w*3+dw*3,90+h*3+dh*3,w,h);
BtMinus.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
try{
if (xSelected==false) {x=Double.parseDouble(str); xSelected=true; act="-";str=null; EP=false;}
else {if (EP==false) {y=Double.parseDouble(str); Action(); act="-";  AP=true;}
else act="-"; ySelected=false; EP=false;
   }}catch(NullPointerException e1){} }}); Frame.add(BtMinus); 

  
BtEqual=new JButton("=");
BtEqual.setBounds((width-w*5-dw*4)/2-8+w*4+dw*4,90+h*3+dh*3,w,h+dh+h);
BtEqual.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
try{if (EP==false){y=Double.parseDouble(str); Action(); ySelected=true; str=null;} 
else Action(); ySelected=true; EP=true;}catch(NullPointerException n){}
}});  Frame.add(BtEqual); 



Bt0=new JButton("0");
Bt0.setBounds((width-w*5-dw*4)/2-8,90+h*4+dh*4,w+dw+w,h);
Bt0.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if(str==null) {str="0";}  else str+=0; 
Screen.setText(str);}});  Frame.add(Bt0);  

BtPoint=new JButton(".");
BtPoint.setBounds((width-w*5-dw*4)/2-8+w*2+dw*2,90+h*4+dh*4,w,h);
BtPoint.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
if(str==null) {str="0.";}  else str+="."; 
Screen.setText(str);}});  Frame.add(BtPoint);  

BtPlus=new JButton("+");
BtPlus.setBounds((width-w*5-dw*4)/2-8+w*3+dw*3,90+h*4+dh*4,w,h);
BtPlus.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
    try{
if (xSelected==false) {x=Double.parseDouble(str); xSelected=true; act="+";str=null; EP=false;}
else {if (EP==false) {y=Double.parseDouble(str); Action(); act="+";  AP=true;}
else act="+"; ySelected=false; EP=false;
   }}catch(NullPointerException e1){}
}});  Frame.add(BtPlus);  

        Frame.repaint();
    }
static void Action(){
    switch (act){
            case ("+"):
                res=x+y; break;
            case ("-"):
                res=x-y; break;
            case ("*"):
                res=x*y; break;
            case ("/"):
                res=x/y; break;
            case ("Sqrt"):
                res=sqrt(x); break;
            case ("%"):
                res=x/100*y; break;
            case ("1/x"):
                res=1/x; break;
            case ("+-"):
                res=(-1)*x; break;
                
            
}
str=res+""; Screen.setText(str); x=res;
}   
}
