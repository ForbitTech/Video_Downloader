package com.forbitbd.videodownloader.fragments.allFragments;

public class AllFragmentPresenter implements AllFragmentContract.Presenter {

    private AllFragmentContract.View mView;

    public AllFragmentPresenter(AllFragmentContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAllFiles() {
        mView.getAllFiles();
    }
}
