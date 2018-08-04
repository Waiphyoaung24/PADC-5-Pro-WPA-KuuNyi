package xyz.waiphyoag.kuunyiapp.delegate

import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
interface JobListItemDelegate{
    fun onTapJobList(jobPostVO: JobPostVO)
    fun onTapApplyJob()
}