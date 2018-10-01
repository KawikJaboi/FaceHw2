package com.example.jacang21.face;
/**
 * This is the Face class
 * This class create the face that appears on the surface view
 * with varies draw methods
 *
 * @author Kawika Jacang
 * Created on 9/29/18
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.SurfaceView;


public class Face extends SurfaceView {
    private Paint skinColor =  new Paint(); //Define the skin paint
    private Paint eyeColor = new Paint(); //Define the eye paint
    private Paint hairColor = new Paint(); //Define the


    //These are int values for the colors
    private int eyeRedValue, eyeGreenValue, eyeBlueValue, hairRedValue, hairGreenValue
            ,hairBlueValue, skinRedValue, skinGreenValue, skinBlueValue;

    private int hairStyle;


    public Face(Context context) {
        super(context);
        generalInit();
        randomize();

    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();
        randomize();

    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
        randomize();

    }

    public void generalInit() {
        setWillNotDraw(false);
    }

    public void setColors() {
        skinColor.setColor(Color.rgb(skinRedValue, skinGreenValue, skinBlueValue));
        hairColor.setColor(Color.rgb(hairRedValue, hairGreenValue, hairBlueValue));
        eyeColor.setColor(Color.rgb(eyeRedValue, eyeGreenValue, eyeBlueValue));

    }

    public void setEyeColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        eyeRedValue = rVal;
        eyeGreenValue = gVal;
        eyeBlueValue = bVal;

        //New eyes color
        eyeColor.setColor(Color.rgb(eyeRedValue, eyeGreenValue, eyeBlueValue));
    }

    public void setSkinColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        skinRedValue = rVal;
        skinGreenValue = gVal;
        skinBlueValue = bVal;

        //New skin color
        skinColor.setColor(Color.rgb(skinRedValue, skinGreenValue, skinBlueValue));
    }

    public void setHairColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        hairRedValue = rVal;
        hairGreenValue = gVal;
        hairBlueValue = bVal;

        //New hair color
        hairColor.setColor(Color.rgb(hairRedValue, hairGreenValue, hairBlueValue));
    }

    public int getEyeRedValue(){
        return eyeRedValue;
    }

    public int getEyeGreenValue(){
        return eyeGreenValue;
    }

    public int getEyeBlueValue(){
        return eyeBlueValue;
    }

    public int getSkinRedValue(){
        return skinRedValue;
    }

    public int getSkinGreenValue(){
        return skinGreenValue;
    }

    public int getSkinBlueValue(){
        return skinBlueValue;
    }

    public int getHairRedValue(){
        return hairRedValue;
    }

    public int getHairGreenValue(){
        return hairGreenValue;
    }

    public int getHairBlueValue(){
        return hairBlueValue;
    }

    public void randomize() {
        //Random rgb values for eyes
        eyeRedValue =(int)(Math.random() * 256);
        eyeGreenValue =(int)(Math.random() * 256);
        eyeBlueValue =(int)(Math.random() * 256);
        //Random rgb values for hair
        hairRedValue =(int)(Math.random() * 256);
        hairGreenValue =(int)(Math.random() * 256);
        hairBlueValue =(int)(Math.random() * 256);
        //Random rgb values for skin
        skinRedValue =(int)(Math.random() * 256);
        skinGreenValue =(int)(Math.random() * 256);
        skinBlueValue =(int)(Math.random() * 256);

        //Set the new random color
        setColors();

        //Random hair style
        hairStyle = (int)(Math.random() * 3);

    }

    public void drawHead(Canvas canvas) {


        //Draw the head
        canvas.drawCircle((float)(getWidth()/2), (float)(getHeight()/2), 500.0f, skinColor );


        //Draw the nose
        Paint blackPaint = new Paint();
        canvas.drawCircle((float)(getWidth()/2),(float)(getHeight()/2), 50.0f,blackPaint);

        //Draw the smile
        RectF rectF = new RectF((float)(getWidth()/2 - 250), (float)(getHeight()/2),(float)(getWidth()/2 + 250),(float)(getHeight()/2 + 250));
        Path path = new Path();
        path.arcTo(rectF, 30, 120, true);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(5.0f);
        canvas.drawPath(path, blackPaint);




    }

    public void setRectHair(){
        hairStyle = 1;
    }

    public void setOvalHair(){
        hairStyle = 2;
    }

    public void setBald(){
        hairStyle = 0;
    }

    public void drawRectHair(Canvas canvas) {
        //Draw rectangle haircut
        canvas.drawRect((float) (getWidth() / 2 - 400), (float) (getHeight() / 2 - 500), (float) (getWidth() / 2 + 400),
                (float) (getHeight() / 2 - 300), hairColor);


    }

    public void drawOvalHair(Canvas canvas) {
        //Draw oval haircut
        RectF rect = new RectF((float) (getWidth() / 2 - 400), (float) (getHeight() / 2 - 500), (float) (getWidth() / 2 + 400),
                (float) (getHeight() / 2 - 200));
        Path bowlPath = new Path();
        bowlPath.arcTo(rect, 0, 359, true);
        canvas.drawPath(bowlPath, hairColor);

    }

    public void drawEyes(Canvas canvas) {
        //Draw the white part of the eyes
        Paint eyePaint = new Paint();
        eyePaint.setColor(Color.WHITE);
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),100.0f, eyePaint);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),100.0f, eyePaint);

        //Draw the iris of the eyes
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),60.0f, eyeColor);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),60.0f, eyeColor);

        //Draw the pupil of the eyes
        eyePaint.setColor(Color.BLACK);
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),25.0f, eyePaint);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),25.0f, eyePaint);
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawHead(canvas);
        if(hairStyle == 1){
            drawRectHair(canvas);
        }
        else if(hairStyle == 2){
            drawOvalHair(canvas);
        }
        drawEyes(canvas);


    }

}
