package com.jjoe64.graphview_demos.examples;

import android.os.Handler;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.Passppg;
import com.jjoe64.graphview_demos.R;
import com.jjoe64.graphview_demos.app.Main3Activity;

import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class FixedFrame extends BaseExample {
    private final Handler mHandler = new Handler();
    private Runnable mTimer;
    private double graphLastXValue = 50d;

    private LineGraphSeries<DataPoint> mSeries;

    @Override
    public void onCreate(FullscreenActivity activity) {
        GraphView graph = (GraphView) activity.findViewById(R.id.graph);
        initGraph(graph);
    }

    @Override
    public void initGraph(GraphView graph) {
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(50);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(1024);

        // first mSeries is a line
        mSeries = new LineGraphSeries<>();
        graph.addSeries(mSeries);
    }

    public void onResume() {
        mTimer = new Runnable() {
            @Override
            public void run() {
                if (graphLastXValue == 50) {
                    graphLastXValue = 0;
                    mSeries.resetData(new DataPoint[] {
                            new DataPoint(graphLastXValue, getRandom())
                    });
                }

                graphLastXValue += 1d;
                mSeries.appendData(new DataPoint(graphLastXValue, getRandom()), false, 50);
                mHandler.postDelayed(this, 50);}

        };
        mHandler.postDelayed(mTimer, 200);
    }

    public void onPause() {
        mHandler.removeCallbacks(mTimer);
    }

    double mLastRandom = 2;
    private double getRandom() {
        double i =Passppg.makeJsonObjectRequest();
        return i;
//        mLastRandom++;
//        return Math.sin(mLastRandom*0.5) * 50 * (Math.random() * 10 + 1);
    }
}
