package com.example.myapp;

import android.graphics.Color;

/**
 * Created by Maslyanko on 23.12.2014.
 */
public class LightSequenceManager {

    //Gray - default color
    private final int[] _currentColors = new int[] {Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY, Color.LTGRAY};
    private LightStep _currentLightStep = LightStep.NONE;

    public void SetDefaultColors()
    {
        for (int i=0; i<_currentColors.length; i++)
            _currentColors[i] = Color.LTGRAY;

        _currentLightStep = LightStep.NONE;
    }

    public int[] GetCurrentColors()
    {
        return _currentColors;
    }

    public void RenewLightColors()
    {
        if(_currentColors[4] == Color.LTGRAY)
            SetNewColor();
        else
            RenewExistingColor();
    }

    private void SetNewColor()
    {
        switch (_currentLightStep) {
            case NONE: {
                _currentColors[0] = Color.RED;

                _currentLightStep = LightStep.SECOND;
                break;
            }
            case FIRST: {
                _currentColors[0] = Color.RED;

                _currentLightStep = LightStep.SECOND;
                break;
            }
            case SECOND: {
                _currentColors[0] = Color.BLUE;
                _currentColors[1] = Color.RED;

                _currentLightStep = LightStep.THIRD;
                break;
            }
            case THIRD: {
                _currentColors[0] = Color.YELLOW;
                _currentColors[1] = Color.BLUE;
                _currentColors[2] = Color.RED;

                _currentLightStep = LightStep.FOURTH;
                break;
            }
            case FOURTH: {
                _currentColors[0] = Color.GREEN;
                _currentColors[1] = Color.YELLOW;
                _currentColors[2] = Color.BLUE;
                _currentColors[3] = Color.RED;

                _currentLightStep = LightStep.FIFTH;
                break;
            }
            case FIFTH: {
                _currentColors[0] = Color.WHITE;
                _currentColors[1] = Color.GREEN;
                _currentColors[2] = Color.YELLOW;
                _currentColors[3] = Color.BLUE;
                _currentColors[4] = Color.RED;

                _currentLightStep = LightStep.FIRST;
                break;
            }
        }
    }

    private void RenewExistingColor()
    {
        switch (_currentLightStep) {
            case NONE: {
                _currentColors[0] = Color.RED;
                _currentColors[1] = Color.WHITE;
                _currentColors[2] = Color.GREEN;
                _currentColors[3] = Color.YELLOW;
                _currentColors[4] = Color.BLUE;

                _currentLightStep = LightStep.SECOND;
                break;
            }
            case FIRST: {
                _currentColors[0] = Color.RED;
                _currentColors[1] = Color.WHITE;
                _currentColors[2] = Color.GREEN;
                _currentColors[3] = Color.YELLOW;
                _currentColors[4] = Color.BLUE;

                _currentLightStep = LightStep.SECOND;
                break;
            }
            case SECOND: {
                _currentColors[0] = Color.BLUE;
                _currentColors[1] = Color.RED;
                _currentColors[2] = Color.WHITE;
                _currentColors[3] = Color.GREEN;
                _currentColors[4] = Color.YELLOW;

                _currentLightStep = LightStep.THIRD;
                break;
            }
            case THIRD: {
                _currentColors[0] = Color.YELLOW;
                _currentColors[1] = Color.BLUE;
                _currentColors[2] = Color.RED;
                _currentColors[3] = Color.WHITE;
                _currentColors[4] = Color.GREEN;

                _currentLightStep = LightStep.FOURTH;
                break;
            }
            case FOURTH: {
                _currentColors[0] = Color.GREEN;
                _currentColors[1] = Color.YELLOW;
                _currentColors[2] = Color.BLUE;
                _currentColors[3] = Color.RED;
                _currentColors[4] = Color.WHITE;

                _currentLightStep = LightStep.FIFTH;
                break;
            }
            case FIFTH: {
                _currentColors[0] = Color.WHITE;
                _currentColors[1] = Color.GREEN;
                _currentColors[2] = Color.YELLOW;
                _currentColors[3] = Color.BLUE;
                _currentColors[4] = Color.RED;

                _currentLightStep = LightStep.FIRST;
                break;
            }
        }
    }

}
