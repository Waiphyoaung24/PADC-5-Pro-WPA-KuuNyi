package xyz.waiphyoag.kuunyiapp.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import xyz.waiphyoag.kuunyiapp.data.models.JobsModel
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.delegate.JobListItemDelegate
import xyz.waiphyoag.kuunyiapp.mvp.views.JobListView

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
class JobListPresenter : BasePresenter<JobListView>(), JobListItemDelegate {
    private lateinit var jobListLd: MutableLiveData<List<JobPostVO>>

    override fun initPresenter(mView: JobListView) {
        super.initPresenter(mView)
        jobListLd = MutableLiveData()
        JobsModel.getInstance().loadJobsList(jobListLd, mErrorLd)

    }

    override fun onTapJobList(jobPostVO: JobPostVO) {
        mView.lauchJobDetailScreen(jobPostVO.jobPostId!!)

    }

    override fun onTapApplyJob() {
        mView.onTapApplyJobButton()

    }

    fun getJobListLD(): LiveData<List<JobPostVO>> {
        return jobListLd
    }


}