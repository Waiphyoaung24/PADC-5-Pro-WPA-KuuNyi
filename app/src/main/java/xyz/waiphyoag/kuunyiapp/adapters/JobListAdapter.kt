package xyz.waiphyoag.kuunyiapp.adapters

import android.content.Context
import android.view.ViewGroup
import xyz.waiphyoag.kuunyiapp.R
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.delegate.JobListItemDelegate
import xyz.waiphyoag.kuunyiapp.viewholders.BaseViewHolder
import xyz.waiphyoag.kuunyiapp.viewholders.JobListItemViewHolder

/**
 * Created by WaiPhyoAg on 8/2/18.
 */
class JobListAdapter(context: Context,private val mDelegate: JobListItemDelegate) : BaseRecyclerAdapter<JobListItemViewHolder, JobPostVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobListItemViewHolder {
        val jobListItemView = mLayoutInflator.inflate(R.layout.item_job_list, parent, false)
        return JobListItemViewHolder(jobListItemView,mDelegate)
    }



}