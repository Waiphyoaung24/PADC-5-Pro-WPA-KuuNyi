package xyz.waiphyoag.kuunyiapp.components

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * Created by WaiPhyoAg on 8/2/18.
 */
class EmptyViewPod : RelativeLayout {
    internal var ivEmpty: ImageView? = null

    internal var tvEmpty: TextView? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setEmptyData(emptyImageId: Int, emptyMsg: String) {
        ivEmpty!!.setImageResource(emptyImageId)
        tvEmpty!!.text = emptyMsg
    }

    fun setEmptyData(emptyMsg: String) {
        tvEmpty!!.text = emptyMsg
    }
}