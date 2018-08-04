package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class ViewsVO {
    @SerializedName("viewedTimeStamp")
    var viewedTimeStamp: String? = null

    @SerializedName("seekerSkill")
    var seekerSkill: List<SeekerSkillVO>? = null

    @SerializedName("seekerId")
    var seekerId: Int? = null

    @SerializedName("seekerName")
    var seekerName: String? = null

    @SerializedName("whyShouldHire")
    var hire: List<HireVO>? = null

    @SerializedName("seekerProfilePicUrl")
    var seekerProfilePicUrl: String? = null

}