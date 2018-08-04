package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class InterestedVO {
    @SerializedName("seekerSkill")
    var seekerSkill: List<SeekerSkillVO>? = null

    @SerializedName("seekerId")
    var seekerId: Int? = null

    @SerializedName("seekerName")
    var seekerName: String? = null

    @SerializedName("seekerProfilePicUrl")
    var seekerProfilePicUrl: String? = null

    @SerializedName("interestedTimeStamp")
    var interestedTimeStamp: String? = null
}