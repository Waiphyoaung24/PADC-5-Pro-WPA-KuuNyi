package xyz.waiphyoag.kuunyiapp

import android.app.Application
import xyz.waiphyoag.kuunyiapp.data.models.JobsModel

/**
 * Created by WaiPhyoAg on 8/2/18.
 */
class KuuNyiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        JobsModel.initJobsAppModel(applicationContext)
    }
}