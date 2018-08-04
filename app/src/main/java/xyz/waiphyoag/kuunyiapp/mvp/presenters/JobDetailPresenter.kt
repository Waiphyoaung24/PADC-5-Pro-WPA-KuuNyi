package xyz.waiphyoag.kuunyiapp.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import xyz.waiphyoag.kuunyiapp.data.models.JobsModel
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.mvp.views.JobDetailView

/**
 * Created by WaiPhyoAg on 8/4/18.
 */
class JobDetailPresenter : BasePresenter<JobDetailView>() {
    private lateinit var getJobDetailById: MutableLiveData<JobPostVO>

    override fun initPresenter(mView: JobDetailView) {
        super.initPresenter(mView)
        getJobDetailById = MutableLiveData()

    }

    fun onUIReady(jobPostId: Int): MutableLiveData<JobPostVO> {
        val jobPostVO = JobsModel.getInstance().getJobDetailById(jobPostId)
        getJobDetailById.value = jobPostVO
        return getJobDetailById

    }
}