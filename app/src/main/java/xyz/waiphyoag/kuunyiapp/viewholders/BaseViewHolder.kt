package xyz.waiphyoag.kuunyiapp.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by WaiPhyoAg on 8/2/18.
 */
abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    protected var mData: W? = null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun setData(data: W)
}