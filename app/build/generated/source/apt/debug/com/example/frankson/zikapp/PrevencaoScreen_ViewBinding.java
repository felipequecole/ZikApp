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

public class PrevencaoScreen_ViewBinding implements Unbinder {
  private PrevencaoScreen target;

  private View view2131689618;

  @UiThread
  public PrevencaoScreen_ViewBinding(final PrevencaoScreen target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.button_prevencao, "method 'AbreInfo'");
    view2131689618 = view;
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


    view2131689618.setOnClickListener(null);
    view2131689618 = null;
  }
}
