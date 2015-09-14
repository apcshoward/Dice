import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

   Die lowellDice;
int value=(int)(Math.random()*6)+1;
int sum=0;
public void setup()
{
	size(500,500);
	background(0,100,0);
	noLoop();
}
public void draw()
{
	background(0);
	for(int myX=0;myX<500;myX=myX+50)
	{
		for(int myY=0;myY<500;myY=myY+50)
		{
			Die lowellDice=new Die(myX,myY);
			lowellDice.show();
			lowellDice.roll();
			if(value<7)
			{
				sum=sum+value;
			}
		}
	}
	strokeWeight(3);
	stroke(255);
	fill(240,10,10);
	rect(200,200,100,100);
	fill(255,215,0);
	textSize(35);
	textAlign(CENTER);
	text(sum,250,260);
}
public void mousePressed()
{
	redraw();
	sum=0;
}
class Die 
{
	int x,y;
	Die(int myX, int myY) 
	{
		roll();
		x=myX;
		y=myY;
	}
	public void roll()
	{
		if(Math.random()<0.16f)
		{
			value=1;
		}
		else if(Math.random()<0.33f)
		{
			value=2;
		}
		else if(Math.random()<0.5f)
		{
			value=3;
		}
		else if(Math.random()<0.67f)
		{
			value=4;
		}
		else if(Math.random()<0.83f)
		{
			value=5;
		}
		else
		{
			value=6;
		}
	}
	public void show()
	{
		stroke(255);
		strokeWeight(3);
		fill(0,100,0);
		rect(x,y,50,50);//your code here
		strokeWeight(10);
		stroke(255);
		fill(255);
		if(value==1)		
		{
			point(x+25,y+25);
		}
		else if(value==2)
		{
			point(x+10,y+10);
			point(x+40,y+40);		
		}
		else if(value==3)
		{
			point(x+10,y+10);
			point(x+25,y+25);
			point(x+40,y+40);
		}
		else if(value==4)
		{
			point(x+10,y+10);
			point(x+40,y+10);
			point(x+10,y+40);
			point(x+40,y+40);
		}
		else if(value==5)
		{
			point(x+10,y+10);
			point(x+40,y+10);
			point(x+25,y+25);
			point(x+10,y+40);
			point(x+40,y+40);
		}
		else
		{
			point(x+10,y+10);
			point(x+40,y+10);
			point(x+10,y+25);
			point(x+40,y+25);
			point(x+10,y+40);
			point(x+40,y+40);
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
