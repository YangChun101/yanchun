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
	Image img,imgUp0,imgUp1,imgUp2,imgDown0,imgDown1,imgDown2;
	Image imgleft0,imgleft1,imgleft2,imgright0,imgright1,imgright2;
	Image currentImg;

	int X,Y;

	int LeftFlag,UpFlag,DownFlag,RightFlag;

	Image HeroImageUp[]=new Image[3];
	Image HeroImageDown[]=new Image[3];
	Image HeroImageLeft[]=new Image[3];
	Image HeroImageRight[]=new Image[3];

	public MainCanvas(){
		try{
			X=120;
			Y=100;
			LeftFlag=0;
			UpFlag=0;
			DownFlag=0;
			RightFlag=0;
		//img=Image.createImage("/sayo10.png");



		for(int i=0;i<HeroImageUp.length;i++){
				HeroImageUp[i]=Image.createImage("/sayo"+i+"4.png");
			
		}
		// imgUp0=Image.createImage("/sayo14.png");
		// imgUp1=Image.createImage("/sayo04.png");
		// imgUp2=Image.createImage("/sayo24.png");

		for(int i=0;i<HeroImageDown.length;i++){
				HeroImageDown[i]=Image.createImage("/sayo"+i+"0.png");
			
		}
		// imgDown0=Image.createImage("/sayo10.png");
		// imgDown1=Image.createImage("/sayo20.png");
		// imgDown2=Image.createImage("/sayo00.png");

		for(int i=0;i<HeroImageLeft.length;i++){
				HeroImageLeft[i]=Image.createImage("/sayo"+i+"2.png");
			
		}
		// imgleft0=Image.createImage("/sayo12.png");
		// imgleft1=Image.createImage("/sayo22.png");
		// imgleft2=Image.createImage("/sayo02.png");

		for(int i=0;i<HeroImageRight.length;i++){
				HeroImageRight[i]=Image.createImage("/sayo"+i+"6.png");
			
		}
		// imgright0=Image.createImage("/sayo16.png");
		// imgright1=Image.createImage("/sayo26.png");
		// imgright2=Image.createImage("/sayo06.png");

		currentImg=HeroImageDown[1];
			//img=Image.createImage("/sayo10.png");
		}catch(IOException e){
			e.printStackTrace();
	
		}
	} 
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,X,Y,0);
	}


	public void keyPressed(int keyCode){
	//UP,DOWN,LEFT,RIGHT
	int action=getGameAction(keyCode);
		switch(action){
			case UP:
				if(UpFlag==0){
					currentImg=HeroImageUp[1];
					UpFlag=1;
	
				}else if(UpFlag==1){
					currentImg=HeroImageUp[0];
					UpFlag=2;


				}else if(UpFlag==2){
					currentImg=HeroImageUp[2];
					UpFlag=0;
				}
				Y-=3;

				// System.out.println("UP");
				break;
			case DOWN:

				if(DownFlag==0){
					currentImg=HeroImageDown[1];
					DownFlag=1;
		
				}else if(DownFlag==1){
					currentImg=HeroImageDown[0];
					DownFlag=2;


				}else if(DownFlag==2){
					currentImg=HeroImageDown[2];
					DownFlag=0;
				}
				Y+=3;

				// System.out.println("DOWN");
				break;
			case LEFT:
				if(LeftFlag==0){
					currentImg=HeroImageLeft[1];
					LeftFlag=1;
			
				}else if(LeftFlag==1){
					currentImg=HeroImageLeft[0];
					LeftFlag=2;


				}else if(LeftFlag==2){
					currentImg=HeroImageLeft[2];
					LeftFlag=0;
				}
				X-=3;

				// System.out.println("LEFT");
				break;
			case RIGHT:
				if(RightFlag==0){
					currentImg=HeroImageRight[1];
					RightFlag=1;
			
				}else if(RightFlag==1){
					currentImg=HeroImageRight[0];
					RightFlag=2;


				}else if(RightFlag==2){
					currentImg=HeroImageRight[2];
					RightFlag=0;
				}
				X+=3;
				// System.out.println("RIGHT");
				break;
		}	
	repaint();
	//HeroMove(action,currentImg);
	}

	
	public void HeroMove( int action,Image HeroNestImg){
	
		repaint();
		//System.out.println(action);
	}

}