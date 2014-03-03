package kz.greetgo.homecreditdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Anim02Activity extends Activity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.anim02_activity);
    
    View view = findViewById(R.id.wall02);
    
    view.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        return touch(event);
      }
    });
    
    image = (ImageView)findViewById(R.id.image);
    
  }
  
  private ImageView image;
  
  private boolean touch(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      down(event);
      return true;
    }
    if (event.getAction() == MotionEvent.ACTION_MOVE) {
      move(event);
      return true;
    }
    if (event.getAction() == MotionEvent.ACTION_UP) {
      up(event);
      return true;
    }
    return true;
  }
  
  float x, y;
  boolean down = false;
  
  private void down(MotionEvent event) {
    x = event.getX();
    y = event.getY();
    down = true;
  }
  
  private void move(MotionEvent event) {
    if (!down) return;
    float dx = event.getX() - x;
    float dy = event.getY() - y;
    image.setTranslationX(dx);
    image.setTranslationY(dy);
  }
  
  private void up(MotionEvent event) {
    down = false;
    image.animate().translationX(0).translationY(0).withLayer();
  }
}