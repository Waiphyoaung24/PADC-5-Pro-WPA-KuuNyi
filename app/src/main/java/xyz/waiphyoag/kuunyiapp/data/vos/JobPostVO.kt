package xyz.waiphyoag.kuunyiapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Acer on 8/2/2018.
 */
class JobPostVO {
    @SerializedName("applicant")
    var applicant: List<ApplicantVO>? = null

    @SerializedName("availablePostCount")
    var availablePostCount: Int? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("fullDesc")
    var fullDesc: String? = null

    @SerializedName("genderForJob")
    var genderForJob: Int? = null

    @SerializedName("images")
    var images: List<String>? = null

    @SerializedName("importantNotes")
    var importantNotes: List<String>? = null

    @SerializedName("interested")
     var interested: List<InterestedVO>? = null

    @SerializedName("isActive")
    var isActive: Boolean? = null

    @SerializedName("jobDuration")
    var jobDuration: JobsDurationVO? = null

    @SerializedName("jobPostId")
    var jobPostId: Int? = null

    @SerializedName("jobTags")
    var jobTags: List<JobTagsVO>? = null

    @SerializedName("location")
    var location: String? = null

    @SerializedName("makeMoneyRating")
    var makeMoneyRating: Int? = null

    @SerializedName("offerAmount")
    var offerAmount: OfferAmountVO? = null

    @SerializedName("phoneNo")
    var phoneNo: String? = null

    @SerializedName("postClosedDate")
    var postClosedDate: String? = null

    @SerializedName("postedDate")
    var postedDate: String? = null

    @SerializedName("relevant")
    var relevant: List<RelevantVO>? = null

    @SerializedName("requiredSkill")
    var requiredSkill: List<RequiredSkillVO>? = null

    @SerializedName("viewed")
    var viewed: List<ViewsVO>? = null

    @SerializedName("shortDesc")
    var shortDesc: String? = null





}