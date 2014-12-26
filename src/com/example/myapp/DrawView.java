package com.example.myapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Maslyanko on 22.12.2014.
 */
public class DrawView extends View {


    private final int _height, _width;
    private Canvas _localCanvas;
    private int[] _currentColors = new int[] {Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY};

    public DrawView(Context context, int height, int width) {
        super(context);
        _height = height;
        _width = width;
    }

    @Override
    public void onDraw(Canvas canvas) {
        _localCanvas = canvas;
        DrawNewYearTree();
        DrawLightParts();
        DrawTreeTrunk();
    }

    private void DrawNewYearTree()
    {
        Paint treeBrush = new Paint();
        treeBrush.setColor(Color.GREEN);
        treeBrush.setStrokeWidth(3);

        final int halfWidth = _width/2;
        final int treeHeight = _height/10*6;

        _localCanvas.drawLine(halfWidth, 0, 0, treeHeight, treeBrush);
        _localCanvas.drawLine(halfWidth, 0,  _width, treeHeight, treeBrush);
        _localCanvas.drawLine(0, treeHeight,  _width, treeHeight, treeBrush);
    }

    private void DrawTreeTrunk()
    {
        Paint treeBrush = new Paint();
        treeBrush.setColor(Color.DKGRAY);

        final int halfWidth = _width/2;
        final int treeHeight = _height/10*6;

        _localCanvas.drawRect(halfWidth-30, treeHeight, halfWidth+30, treeHeight+50, treeBrush);
    }

    private void DrawLightParts()
    {
        Paint firstBrush = new Paint();
        firstBrush.setColor(_currentColors[0]);

        Paint secondBrush = new Paint();
        secondBrush.setColor(_currentColors[1]);

        Paint thirdBrush = new Paint();
        thirdBrush.setColor(_currentColors[2]);

        Paint fourthBrush = new Paint();
        fourthBrush.setColor(_currentColors[3]);

        Paint fifthBrush = new Paint();
        fifthBrush.setColor(_currentColors[4]);

        final int partHeight = _height/10;
        final int halfWidth = _width/2;
        final int treeHeight = _height/10*6;
        final double tangentA = (double)halfWidth/(double)treeHeight;

        //1 row
        _localCanvas.drawCircle(halfWidth, partHeight, partHeight/4, fifthBrush);

        //2 row
        _localCanvas.drawCircle((float)((halfWidth - partHeight*2*tangentA) + (partHeight*2*tangentA*2 /3)), partHeight*2, partHeight/4, fourthBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*2*tangentA) + (partHeight*2*tangentA*2 /3)*2), partHeight*2, partHeight/4, fourthBrush);

        //3 row
        _localCanvas.drawCircle((float)((halfWidth - partHeight*3*tangentA) + (partHeight*3*tangentA*2 /4)), partHeight*3, partHeight/4, thirdBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*3*tangentA) + (partHeight*3*tangentA*2 /4)*2), partHeight*3, partHeight/4, thirdBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*3*tangentA) + (partHeight*3*tangentA*2 /4)*3), partHeight*3, partHeight/4, thirdBrush);

        //4 row
        _localCanvas.drawCircle((float)((halfWidth - partHeight*4*tangentA) + (partHeight*4*tangentA*2 /5)), partHeight*4, partHeight/4, secondBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*4*tangentA) + (partHeight*4*tangentA*2 /5)*2), partHeight*4, partHeight/4, secondBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*4*tangentA) + (partHeight*4*tangentA*2 /5)*3), partHeight*4, partHeight/4, secondBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*4*tangentA) + (partHeight*4*tangentA*2 /5)*4), partHeight*4, partHeight/4, secondBrush);

        //5 row
        _localCanvas.drawCircle((float)((halfWidth - partHeight*5*tangentA) + (partHeight*5*tangentA*2 /6)), partHeight*5, partHeight/4, firstBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*5*tangentA) + (partHeight*5*tangentA*2 /6)*2), partHeight*5, partHeight/4, firstBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*5*tangentA) + (partHeight*5*tangentA*2 /6)*3), partHeight*5, partHeight/4, firstBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*5*tangentA) + (partHeight*5*tangentA*2 /6)*4), partHeight*5, partHeight/4, firstBrush);
        _localCanvas.drawCircle((float)((halfWidth - partHeight*5*tangentA) + (partHeight*5*tangentA*2 /6)*5), partHeight*5, partHeight/4, firstBrush);
    }

    public void SetLights(int[] newColors)
    {
        _currentColors = newColors;
    }
}
