package com.example.administrator.progressview;

import android.os.Handler;
import android.os.Message;

/**
 * <pre>
 *     author : Leero
 *     e-mail : 925230519@qq.com
 *     time  : 2018-01-03
 *     desc  :
 *     version: 1.0
 * </pre>
 */
public class ProgressHelper {

    private ProgressView progressView;
    private int progress;

    public ProgressHelper(ProgressView view, int progress) {
        this.progressView = view;
        this.progress = progress;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (progressView != null) {
                progressView.setProgress(msg.what);
                handler.postDelayed(updateProgress, 20);
            }
        }
    };

    private Runnable updateProgress = new Runnable() {
        int currentProgress = 0;
        @Override
        public void run() {
            currentProgress++;
            Message msg = handler.obtainMessage();
            msg.what = currentProgress;
            handler.sendMessage(msg);
            if (currentProgress > progress) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    };

    public void start() {
        handler.post(updateProgress);
    }

}
