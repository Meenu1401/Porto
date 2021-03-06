// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LoginsignuppageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CheckBox checkbox1;

  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final EditText edit1;

  @NonNull
  public final EditText edit2;

  @NonNull
  public final EditText editname;

  @NonNull
  public final TextView tv2;

  @NonNull
  public final TextView tvTnc;

  @NonNull
  public final TextView tvget;

  private LoginsignuppageBinding(@NonNull ConstraintLayout rootView, @NonNull CheckBox checkbox1,
      @NonNull ConstraintLayout container, @NonNull EditText edit1, @NonNull EditText edit2,
      @NonNull EditText editname, @NonNull TextView tv2, @NonNull TextView tvTnc,
      @NonNull TextView tvget) {
    this.rootView = rootView;
    this.checkbox1 = checkbox1;
    this.container = container;
    this.edit1 = edit1;
    this.edit2 = edit2;
    this.editname = editname;
    this.tv2 = tv2;
    this.tvTnc = tvTnc;
    this.tvget = tvget;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LoginsignuppageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LoginsignuppageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.loginsignuppage, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LoginsignuppageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.checkbox1;
      CheckBox checkbox1 = ViewBindings.findChildViewById(rootView, id);
      if (checkbox1 == null) {
        break missingId;
      }

      ConstraintLayout container = (ConstraintLayout) rootView;

      id = R.id.edit1;
      EditText edit1 = ViewBindings.findChildViewById(rootView, id);
      if (edit1 == null) {
        break missingId;
      }

      id = R.id.edit2;
      EditText edit2 = ViewBindings.findChildViewById(rootView, id);
      if (edit2 == null) {
        break missingId;
      }

      id = R.id.editname;
      EditText editname = ViewBindings.findChildViewById(rootView, id);
      if (editname == null) {
        break missingId;
      }

      id = R.id.tv2;
      TextView tv2 = ViewBindings.findChildViewById(rootView, id);
      if (tv2 == null) {
        break missingId;
      }

      id = R.id.tvTnc;
      TextView tvTnc = ViewBindings.findChildViewById(rootView, id);
      if (tvTnc == null) {
        break missingId;
      }

      id = R.id.tvget;
      TextView tvget = ViewBindings.findChildViewById(rootView, id);
      if (tvget == null) {
        break missingId;
      }

      return new LoginsignuppageBinding((ConstraintLayout) rootView, checkbox1, container, edit1,
          edit2, editname, tv2, tvTnc, tvget);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
