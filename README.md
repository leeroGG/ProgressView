# ProgressView
用于统计图的水平进度条
</br>
</br>
**效果图**
</br>
</br>
![image](https://github.com/leeroGG/ProgressView/raw/master/result.gif)
</br>
</br>
**使用**
* 在xml中引用，可用属性：
进度颜色:progressColorValue，进度值：progressValue，进度字体颜色：textColor，进度字体大小：textSize
* 也可以在代码中调用setProgress()方法动态设置进度
* 通过ProgressHelper可以实现动态形式（效果图看着不太连贯，实际上是连贯地往前移动的...）
```
  ProgressHelper helper = new ProgressHelper(progressView1, 65);
  helper.start();
```
