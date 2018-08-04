package xyz.waiphyoag.kuunyiapp.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import xyz.waiphyoag.kuunyiapp.mvp.views.BaseView

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
abstract class BasePresenter<T : BaseView>: ViewModel() {
    lateinit var mView: T
    lateinit var context: Context
    lateinit var mErrorLd: MutableLiveData<String>
    open fun initPresenter(mView: T) {
        this.mView = mView
        mErrorLd = MutableLiveData()
    }

    fun getErrorLd(): LiveData<String> {
        return mErrorLd
    }
}