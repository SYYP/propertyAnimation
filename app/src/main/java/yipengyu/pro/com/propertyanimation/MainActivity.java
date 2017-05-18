package yipengyu.pro.com.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得资源id
        img = (ImageView) findViewById(R.id.img);
         //设置透明动画
//        ObjectAnimator objectAnimator=new ObjectAnimator().ofFloat(img,"alpha",0f,1);
//        objectAnimator.setDuration(1000);
//        objectAnimator.setRepeatCount(2);
        //objectAnimator.start();
        //设置缩放动画
        PropertyValuesHolder propertyValuesHolderX=PropertyValuesHolder.ofFloat("scaleX",0f,1f);
        PropertyValuesHolder propertyValuesHolderY=PropertyValuesHolder.ofFloat("scaleY",0f,1f);
        //同时播放两个动画
        ObjectAnimator.ofPropertyValuesHolder(img,propertyValuesHolderX,propertyValuesHolderY).setDuration(1000).start();
        //旋转动画
        ObjectAnimator objectAnimator1=new ObjectAnimator().ofFloat(img,"rotation",0f,360f);
         objectAnimator1.setDuration(1000);
        objectAnimator1.setRepeatCount(2);
        //objectAnimator1.start();
        //动画组合
        AnimatorSet animatorSetGroup1 = new AnimatorSet();
        ObjectAnimator objectAnimatorScaleX1 = ObjectAnimator.ofFloat(img, "scaleX", 0f, 1f);
        ObjectAnimator objectAnimatorScaleY1 = ObjectAnimator.ofFloat(img, "scaleY", 0f, 1f);
        ObjectAnimator objectAnimatorRotateX1 = ObjectAnimator.ofFloat(img, "rotationX", 0f, 360f);
        ObjectAnimator objectAnimatorRotateY1 = ObjectAnimator.ofFloat(img, "rotationY", 0f, 360f);
        animatorSetGroup1.setDuration(1000);
        animatorSetGroup1.play(objectAnimatorScaleX1).with(objectAnimatorScaleY1)
                .before(objectAnimatorRotateX1).before(objectAnimatorRotateY1);
      //  animatorSetGroup1.start();
        //动态改变控件颜色
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(img, "backgroundColor", Color.BLUE, Color.GREEN, Color.RED);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}
