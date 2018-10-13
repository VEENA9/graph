package com.jjoe64.graphview_demos.examples;

import android.os.Handler;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview_demos.FullscreenActivity;
import com.jjoe64.graphview_demos.Passtemp;
import com.jjoe64.graphview_demos.R;

import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class RealtimeScrolling extends BaseExample {
    private final Handler mHandler = new Handler();
    double mLastRandom = 1;
    Random mRand = new Random();
    private Runnable mTimer;
    private double graphLastXValue = 5d;
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
        graph.getViewport().setMaxX(4);

        graph.getGridLabelRenderer().setLabelVerticalWidth(100);

        // first mSeries is a line
        mSeries = new LineGraphSeries<>();
        mSeries.setDrawDataPoints(true);
        mSeries.setDrawBackground(true);
        graph.addSeries(mSeries);
    }

    public void onResume() {
        mTimer = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 0.25d;
                mSeries.appendData(new DataPoint(graphLastXValue, getRandom()), true, 22);
                mHandler.postDelayed(this, 5000);
            }
        };
        mHandler.postDelayed(mTimer, 200);
    }

    public void onPause() {
        mHandler.removeCallbacks(mTimer);
    }

    private double getRandom() {

        Log.d("DATA_Y", Passtemp.makeJsonObjectRequest()+"");
//        return mLastRandom += 0.5;
        return 5;
//            return Passtemp.makeJsonObjectRequest();

    }
}


