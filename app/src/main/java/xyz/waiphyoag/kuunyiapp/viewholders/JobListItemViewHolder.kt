package xyz.waiphyoag.kuunyiapp.viewholders

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_job_list.view.*
import xyz.waiphyoag.kuunyiapp.R
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.delegate.JobListItemDelegate

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
class JobListItemViewHolder(itemView: View, private val mDelegate: JobListItemDelegate) : BaseViewHolder<JobPostVO>(itemView) {

    override fun setData(data: JobPostVO) {
        mData = data
        var salary1: String = "" + data.offerAmount!!.amount + " kyats " + data.offerAmount!!.duration

        itemView.tvJobTitle.text = data.jobTags!![0].tag
        itemView.tvJobDescInFew.text = data.shortDesc
        itemView.tvJobLocation.text = data.location
        itemView.tvJobSalary.text = salary1
        itemView.tvJobDuration.text = "" + data.jobDuration!!.totalWorkingDays + " days "

        itemView.btnApply.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mDelegate.onTapApplyJob()
            }
        })

    }


    override fun onClick(v: View?) {
        mDelegate.onTapJobList(mData!!)

    }






}
