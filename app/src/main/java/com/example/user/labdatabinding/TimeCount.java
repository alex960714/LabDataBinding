package com.example.user.labdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TimeCount extends BaseObservable {
    private int hourSt, hourEn;
    private int minSt, minEn;

    public void setHours(int st, int en){
        this.hourSt=st;
        this.hourEn =en;
        notifyPropertyChanged(com.example.user.labdatabinding.BR.timeDiff);
    }

    public void setMin(int st, int en){
        this.minSt=st;
        this.minEn =en;
        notifyPropertyChanged(com.example.user.labdatabinding.BR.timeDiff);
    }

    @Bindable
    public String getTimeDiff() {
        if (hourEn>23 || hourSt>23 || minSt>59 || minEn>59){
            return "Incorrect data";
        }
        if (hourEn < hourSt || (hourEn == hourSt && minEn < minSt)){
            hourEn += 24;
        }
        return Integer.toString(hourEn *60+ minEn -hourSt*60-minSt);
    }
}
