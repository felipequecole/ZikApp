// Generated code from Butter Knife. Do not modify!
package com.example.frankson.zikapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AedesScreen_ViewBinding implements Unbinder {
  private AedesScreen target;

  private View view2131624079;

  @UiThread
  public AedesScreen_ViewBinding(final AedesScreen target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.button_aedes, "method 'AbreInfo'");
    view2131624079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.AbreInfo();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131624079.setOnClickListener(null);
    view2131624079 = null;
  }
}
