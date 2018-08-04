package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class SeekerSkillVO {
    @SerializedName("skillName")
    var skillName: String? = null

    @SerializedName("skillId")
    var skillId: Int? = null
}