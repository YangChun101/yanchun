import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image heroImg[][]=new Image[4][3];
	//4个方向、每个方向3张图片，0表示left、1表示right、2表示up、3表示down
	/*
	规则二维数组
	*/

	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][1];
			x=120;
			y=100;

			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			if(leftFlag==1){
				currentImg=heroImg[0][0];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=heroImg[0][2];
				leftFlag=1;
			}
			x=x-1;
			repaint();
		}
		if(action==UP){
			if(upFlag==1){
				currentImg=heroImg[2][0];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=heroImg[2][2];
				upFlag=1;
			}
			y=y-1;
			repaint();
		}
		if(action==RIGHT){
			if(rightFlag==1){
				currentImg=heroImg[1][0];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=heroImg[1][2];
				rightFlag=1;
			}
			x=x+1;
			repaint();
		}
		if(action==DOWN){
			if(downFlag==1){
				currentImg=heroImg[3][0];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=heroImg[3][2];
				downFlag=1;
			}
			y=y+1;
			repaint();
		}
	}
}