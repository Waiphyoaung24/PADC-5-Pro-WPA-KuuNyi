package xyz.waiphyoag.kuunyiapp.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_job_detail.*
import kotlinx.android.synthetic.main.item_job_list.*
import xyz.waiphyoag.kuunyiapp.R
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.mvp.presenters.JobDetailPresenter
import xyz.waiphyoag.kuunyiapp.mvp.views.JobDetailView

/**
 * Created by WaiPhyoAg on 8/3/18.
 */
class JobDetailActivity : BaseActivity(), JobDetailView {

    private lateinit var mPresenter: JobDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
        val w = window // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        mPresenter = ViewModelProviders.of(this).get(JobDetailPresenter::class.java)
        mPresenter.initPresenter(this)

        val jobPostId = intent.getIntExtra("jobPostId", -1)
        mPresenter.onUIReady(jobPostId).observe(this, Observer<JobPostVO> { t -> displayJobDetail(t!!) })

    }

    fun displayJobDetail(jobPostVO: JobPostVO) {
        tvJobDetailTitle.text = jobPostVO.jobTags!![0].tag
        tvJobDetailDesc.text = jobPostVO.fullDesc
        tvJobDetailSalary.text = "" + jobPostVO.offerAmount!!.amount + " kyats " + jobPostVO.offerAmount!!.duration
        tvJobDetailLocation.text = jobPostVO.location
    }


}