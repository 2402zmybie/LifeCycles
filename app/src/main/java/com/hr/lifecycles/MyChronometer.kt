package com.hr.lifecycles

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyChronometer:Chronometer,LifecycleObserver{

    var elapsedTime:Long = 0L;

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pauseMeter() {
        elapsedTime = SystemClock.elapsedRealtime() - this.base
        this.stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumeMeter() {
        this.base =  SystemClock.elapsedRealtime() - elapsedTime
        this.start()
    }


}