package com.forbitbd.videodownloader.ui.home;

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View mView) {
        this.mView = mView;
    }

}
