package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class JobTagsVO{

     @SerializedName("JobCountWithTag")
     var jobCountWithTag: Int? = null

     @SerializedName("desc")
     var desc: String? = null

     @SerializedName("tag")
     var tag: String? = null

     @SerializedName("tagId")
     var tagId: Int? = null
}