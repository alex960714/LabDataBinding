package com.example.user.labdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TimeCount extends BaseObservable {
    private int hourSt, hourFin;
    private int minSt, minFin;

    public void setHours(int st, int en){
        this.hourSt=st;
        this.hourFin=en;
        notifyPropertyChanged(com.example.user.labdatabinding.BR.timeDiff);
    }

    public void setMin(int st, int en){
        this.minSt=st;
        this.minFin=en;
        notifyPropertyChanged(com.example.user.labdatabinding.BR.timeDiff);
    }

    @Bindable
    public int getTimeDiff() {
        return (hourFin*60+minFin-hourSt*60-minSt)%(24*60);
    }
}
