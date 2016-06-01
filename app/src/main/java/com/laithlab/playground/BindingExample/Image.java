package com.laithlab.playground.BindingExample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;
import com.laithlab.playground.BR;

public class Image extends BaseObservable {
    private String title;
    private String url;

    @Bindable
    public String getUrl() {
        return this.url;
    }

    @Bindable
    public String getTitle() {
        return this.title;
    }

    public Image(String title, String url) {
        this.title = title;
        this.url = url;
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
