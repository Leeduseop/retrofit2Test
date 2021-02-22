package com.sensor.test_sensor.retrofit2

import com.google.gson.JsonArray
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {
   @Multipart
   @POST("/data/uploadPlace")
   fun uploadPlaceFile(
       @Part("researcherID") id : String ,
       @Part file :MultipartBody.Part
   ) : Call<ResponseBody?>?

    @Multipart
    @POST("/data/uploadWeather")
    fun uploadWeatherFile(
        @Part("researcherID") id : String ,
        @Part file :MultipartBody.Part
    ) : Call<ResponseBody?>?

    @Multipart
    @POST("/data/uploadAmbience")
    fun uploadAmbienceFile(
        @Part("researcherID") id: RequestBody,
        @Part surveySoundFile: Array<MultipartBody.Part?>?,
        @Part ("timestampByFile") jsonArray: RequestBody

    ) : Call<ResponseBody?>?


    /*@Multipart
    @POST(WebServices.UPLOAD_SURVEY)
    fun uploadSurvey(
        @Part surveyImage: MultipartBody.Part?,
        @Part propertyImage: MultipartBody.Part?,
        @Part("DRA") dra: RequestBody?
    ): Call<UploadSurveyResponseModel?>?*/

}