package me.morirain.dev.flowmemo.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by morirain on 2018/6/2.
 * E-Mail Address：morirain.dev@outlook.com
 */


public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    private T mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResId() <= 0) throw new AssertionError("Subclass must provide a valid layout resource id");

        mBind = DataBindingUtil.setContentView(this, getLayoutResId());
        mBind.setLifecycleOwner(this);

        init(savedInstanceState);
     }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutResId();

    protected View getRoot() {
        return mBind.getRoot();
    }

    protected final T getBinding() {
        return mBind;
    }
}