package xyz.waiphyoag.kuunyiapp.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import xyz.waiphyoag.kuunyiapp.R
import xyz.waiphyoag.kuunyiapp.adapters.JobListAdapter
import kotlinx.android.synthetic.main.activity_job_list.*
import xyz.waiphyoag.kuunyiapp.components.OnFabMenuItemClickListener
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.mvp.presenters.JobListPresenter
import xyz.waiphyoag.kuunyiapp.mvp.views.JobListView
import android.support.design.widget.FloatingActionButton
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient


class JobListActivity : AppCompatActivity(), JobListView, OnFabMenuItemClickListener, GoogleApiClient.OnConnectionFailedListener {


    protected lateinit var mGoogleApiClient: GoogleApiClient
    private lateinit var mJobListAdapter: JobListAdapter
    private lateinit var mPresenter: JobListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_list)
        mPresenter = ViewModelProviders.of(this).get(JobListPresenter::class.java)
        mPresenter.initPresenter(this)

        //lifecycle
        mPresenter.getJobListLD().observe(this, Observer<List<JobPostVO>> { t -> displayJobsListData(t!!) })


        //Adapter
        mJobListAdapter = JobListAdapter(applicationContext, mPresenter)
        rvJobList.layoutManager = LinearLayoutManager(applicationContext)
        rvJobList.adapter = mJobListAdapter


        //fabMenu
        val fabList = arrayOf<FloatingActionButton>(fabSignIn, fabSignUp)
        fabMenu.setFabList(fabList).setFabMain(fabMain).setFabMenuItemClickListener(this)


        //google-sign-in

        val googleSignIn: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("720576805655-krhcf3m87s0smje3o8470n48dg5ocpts.apps.googleusercontent.com")
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(applicationContext)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignIn)
                .build()


    }

    private fun processGoogleSignInResult(googleSignInResult: GoogleSignInResult) {
        if (googleSignInResult.isSuccess) {
            val account: GoogleSignInAccount = googleSignInResult.signInAccount!!

        }
    }

    private fun displayJobsListData(jobsList: List<JobPostVO>) {
        mJobListAdapter.appendNewData(jobsList)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_post, menu)
        val menuItem: MenuItem = menu!!.findItem(R.id.add_post)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id: Int = item!!.itemId

        if (id == R.id.add_post) {
            Snackbar.make(rvJobList, "New Job Post Is Added", Snackbar.LENGTH_LONG).show()

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFabMenuItemClick(view: View) {
        var id: Int = view.id
        if (id == fabSignIn.id) {

            Snackbar.make(rvJobList, "Sign In features", Snackbar.LENGTH_SHORT).show()
        } else if (id == fabSignUp.id) {
            Snackbar.make(rvJobList, "Sign Up feautres", Snackbar.LENGTH_SHORT).show()


        } else {

        }

    }

    override fun onTapApplyJobButton() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Applicant For The Job")
        builder.setMessage("Are you sure you want to apply for this job")
        builder.setPositiveButton("Yes") { dialog, which ->
            Snackbar.make(rvJobList, "You have applied for this job", Snackbar.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            Snackbar.make(rvJobList, "You have cancelled the job",
                    Snackbar.LENGTH_LONG).show()
        }.show()

    }

    override fun lauchJobDetailScreen(jobPostId: Int) {

        val intent = Intent(applicationContext, JobDetailActivity::class.java)
        intent.putExtra("jobPostId", jobPostId)
        startActivity(intent)
    }

}
