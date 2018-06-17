package com.morirain.flowmemo.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.morirain.flowmemo.R;
import com.morirain.flowmemo.base.BaseFragment;
import com.morirain.flowmemo.databinding.FragmentMemoryBinding;
import com.morirain.flowmemo.viewmodel.MemoryViewModel;

public class MemoryFragment extends BaseFragment<FragmentMemoryBinding, MemoryViewModel> implements View.OnClickListener {

    @Override
    protected void init(Bundle savedInstanceState) {


        getViewModel().inputText.observe(this, message -> {
            if (message != null && message.length() > 0) {
                getBinding().buttonSend.setVisibility(View.VISIBLE);
                getBinding().buttonMore.setVisibility(View.INVISIBLE);
            } else {
                getBinding().buttonSend.setVisibility(View.INVISIBLE);
                getBinding().buttonMore.setVisibility(View.VISIBLE);
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {

    }

    /**
     * Bottom 被点击
     *
     * @param view 被点击 的 View
     */
    @Override
    public void onClick(View view) {
        //if (view == getBinding().buttonNewNote) {

//        }
    }

    @Override
    protected void setConnect() {
        getBinding().setViewModel(getViewModel());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_memory;
    }

    @Override
    protected Class<MemoryViewModel> getViewModelClass() {
        return MemoryViewModel.class;
    }


}