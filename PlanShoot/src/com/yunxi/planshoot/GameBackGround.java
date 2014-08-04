package com.yunxi.planshoot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

//��Ϸ������
public class GameBackGround {
	private Bitmap bmpBg1;
	private Bitmap bmpBg2;
	private int speed=3;
	private int bg1X,bg1Y,bg2X,bg2Y;
	private Matrix matrix;
	public GameBackGround(Bitmap bmpBg ){
		this.bmpBg1 = bmpBg;
		this.bmpBg2 = bmpBg;
		//bg1Y = -Math.abs(bmpBg1.getHeight()-MainSurfaceView.screenH);
		//bg2Y = bg1Y-bmpBg1.getHeight() +111;
		bg1Y=0;
		bg2Y = -MainSurfaceView.screenH;//+300;
		calcScaleMatrix();
	}
	
	public void draw(Canvas canvas, Paint paint){
		
		Matrix translateMatrix=new Matrix();
		translateMatrix.set(matrix);
		translateMatrix.postTranslate(0, bg1Y);
		canvas.drawBitmap(bmpBg1, translateMatrix, paint);
		
		translateMatrix.set(matrix);
		translateMatrix.postTranslate(0, bg2Y );
		canvas.drawBitmap(bmpBg2, translateMatrix, paint);
		
	}
	
	public void logic(){
		bg1Y += speed;
		bg2Y += speed;
		if(bg1Y > MainSurfaceView.screenH){
			//bg1Y = bg2Y-bmpBg1.getHeight()+300;
			bg1Y = bg2Y-MainSurfaceView.screenH;//+300;
		}
		if(bg2Y > MainSurfaceView.screenH){
			//bg2Y = bg1Y-bmpBg1.getHeight()+300;
			bg2Y = bg1Y-MainSurfaceView.screenH;//+300;
		}
	}
	
	public void calcScaleMatrix(){
		float sw =MainSurfaceView.screenW;
		float bw = bmpBg1.getWidth();
		float wp = sw/bw;
		float sh = MainSurfaceView.screenH;
		float bh = bmpBg1.getHeight();
		float hp = sh/bh;
		matrix = new Matrix();
		matrix.postScale(wp, hp);
	}
}