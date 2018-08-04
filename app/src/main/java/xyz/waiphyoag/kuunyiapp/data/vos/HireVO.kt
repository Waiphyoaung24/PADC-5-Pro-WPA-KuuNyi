package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class HireVO {
    @SerializedName("msg")
    var msg: String? = null

    @SerializedName("timestamp")
     var timestamp: String? = null

    @SerializedName("whyShouldHireId")
     var hireId: Int? = null


}