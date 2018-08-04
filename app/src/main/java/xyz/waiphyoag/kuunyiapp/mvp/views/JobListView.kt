package xyz.waiphyoag.kuunyiapp.mvp.views

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
interface JobListView : BaseView {
    fun lauchJobDetailScreen(jobPostId :Int)
    fun onTapApplyJobButton()
}