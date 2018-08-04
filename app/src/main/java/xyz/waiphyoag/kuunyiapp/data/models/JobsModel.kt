package xyz.waiphyoag.kuunyiapp.data.models

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.media.MediaPlayer
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import com.google.firebase.database.*
import xyz.waiphyoag.kuunyiapp.data.vos.JobPostVO
import xyz.waiphyoag.kuunyiapp.utils.AppConstants
import java.lang.Exception
import java.lang.RuntimeException
import java.util.ArrayList

/**
 * Created by WaiPhyoAg on 8/2/18.
 */
class JobsModel private constructor(context: Context) {

    private var mDatabaseReference: DatabaseReference? = null
    private lateinit var mJobsFeedDR: DatabaseReference

    private var mFirebaseAuth: FirebaseAuth? = null
    private var mFirebaseUser: FirebaseUser? = null
    var jobsList = ArrayList<JobPostVO>()

    companion object {
        private var objInstance: JobsModel? = null
        fun getInstance(): JobsModel {
            if (objInstance == null) {
                throw RuntimeException("JobsModel is  being invoked before initializing")
            }
            val i = objInstance
            return i!!

        }

        fun initJobsAppModel(context: Context) {
            objInstance = JobsModel(context)
        }
    }


    fun isUserSignIn(): Boolean {
        return mFirebaseUser != null
    }


    init {
        mDatabaseReference = FirebaseDatabase.getInstance().reference

    }

    fun loadJobsList(mJobsListLd: MutableLiveData<List<JobPostVO>>, errorLd: MutableLiveData<String>) {
        mJobsFeedDR = mDatabaseReference!!.child(AppConstants.JOB_POST)
        mJobsFeedDR.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError?) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot != null) {
                    dataSnapshot?.children?.forEach { snapShot: DataSnapshot ->
                        var jobs: JobPostVO = snapShot.getValue(JobPostVO::class.java)!!
                        jobsList.add(jobs)

                    }

                    mJobsListLd.value = jobsList
                }
            }

        })


    }

    fun authenticateUserWithGoogleAccount(googleSignInAccount: GoogleSignInAccount, delegate: signInWithGoogleAccountDelegate) {

        val credential: AuthCredential = GoogleAuthProvider.getCredential(googleSignInAccount.idToken, null)
        mFirebaseAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(p0: Task<AuthResult>) {
                        if (!p0.isSuccessful) {
                            delegate.onFailureSignIn(p0.exception!!.message!!)
                        } else {
                            delegate.onSuccessSignIn(googleSignInAccount)
                            mFirebaseAuth = FirebaseAuth.getInstance()
                            mFirebaseUser = mFirebaseAuth!!.currentUser
                        }
                    }

                }).addOnFailureListener(object : OnFailureListener {
                    override fun onFailure(p0: Exception) {
                        delegate.onFailureSignIn(p0.message!!)
                    }
                })

    }

    fun getJobDetailById(jobPostId: Int): JobPostVO? {

        if (jobsList.isNotEmpty()) {
            for (jobPostVO: JobPostVO in jobsList) {
                if (jobPostVO.jobPostId!!.equals(jobPostId))
                    return jobPostVO
            }

        }
        return null

    }

    interface signInWithGoogleAccountDelegate {
        fun onSuccessSignIn(signInAccount: GoogleSignInAccount)

        fun onFailureSignIn(errorMsg: String)
    }
}
