package com.laithlab.playground.BindingExample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;
import com.laithlab.playground.BR;

public class Image extends BaseObservable {
    @Bindable
    private String url;
    @Bindable
    private String title;

    public Image(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(SimpleDraweeView image, String url) {
        image.setImageURI(Uri.parse(url));
    }
}
