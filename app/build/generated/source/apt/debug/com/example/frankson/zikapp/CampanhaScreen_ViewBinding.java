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

public class CampanhaScreen_ViewBinding implements Unbinder {
  private CampanhaScreen target;

  private View view2131624080;

  @UiThread
  public CampanhaScreen_ViewBinding(final CampanhaScreen target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.button_campanha, "method 'AbreCamera'");
    view2131624080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.AbreCamera();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131624080.setOnClickListener(null);
    view2131624080 = null;
  }
}