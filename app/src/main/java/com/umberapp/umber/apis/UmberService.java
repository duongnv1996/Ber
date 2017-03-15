package com.umberapp.umber.apis;

import com.umberapp.umber.models.AuthResponse;
import com.umberapp.umber.models.Category;
import com.umberapp.umber.models.CheckResponse;
import com.umberapp.umber.models.Code;
import com.umberapp.umber.models.Config;
import com.umberapp.umber.models.DebitModel;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.Event;
import com.umberapp.umber.models.Expert;
import com.umberapp.umber.models.ExpertMarker;
import com.umberapp.umber.models.FaqItem;
import com.umberapp.umber.models.HICItem;
import com.umberapp.umber.models.NotificationItemPage;
import com.umberapp.umber.models.OrderItem;
import com.umberapp.umber.models.ParamRegUser;
import com.umberapp.umber.models.Tag;
import com.umberapp.umber.models.UpcommingItem;
import com.umberapp.umber.models.User;
import com.umberapp.umber.models.Work;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UmberService {
    @FormUrlEncoded
    @POST("sendmailactive")
    Call<ApiResponse<List<User>>> activeAcc(@Field("email") String str);

    @FormUrlEncoded
    @POST("giupviecmotlan")
    Call<ApiResponse> addNewOnTimeWork(@Field("address") String str, @Field("lat") double d, @Field("lng") double d2, @Field("time_end") String str2, @Field("time_start") String str3, @Field("note") String str4, @Field("thuong") double d3, @Field("tongchiphi") double d4, @Field("chonnguoi") int i, @Field("customer_id") String str5, @Field("makhuyenmai") String str6);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ResponseBody> becomeUser(@Header("Authorization") String str, @Field("type") String str2);

    @FormUrlEncoded
    @POST("user/update-password")
    Call<ApiResponse<String>> changePass(@Header("Authorization") String str, @Field("newPassword") String str2);

    @FormUrlEncoded
    @POST("checkmakhuyenmai")
    Call<ApiResponse<List<Code>>> checkCode(@Field("makhuyenmai") String str, @Field("customer_id") String str2);

    @GET("user-access/check-debt")
    Call<ApiResponse<DebitModel>> checkDebit(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("app/check-username")
    Call<ApiResponse<CheckResponse>> checkUsername(@Field("username") String str);

    @GET
    Call<ResponseBody> downloadFilePin(@Url String str);

    @GET("user-access/order?type=rating")
    Call<ResponseBody> feedbackExpert(@Header("Authorization") String str, @Query("comment") String str2, @Query("id") String str3, @Query("star") double d);

    @GET("user-access/find-experts-available")
    Call<ApiResponse<List<ExpertMarker>>> findExpert(@Header("Authorization") String str, @Query("category_id") String str2, @Query("lat") double d, @Query("lng") double d2, @Query("radius") long j);

    @GET("user-access/find-hci-available")
    Call<ApiResponse<List<HICItem>>> findHCI(@Header("Authorization") String str, @Query("lat") double d, @Query("lng") double d2, @Query("radius") long j);

    @FormUrlEncoded
    @POST("forgotpassword")
    Call<ApiResponse<List<User>>> forgotPassword(@Field("email") String str);

    @GET("app/app-config")
    Call<ApiResponse<Config>> getAppConfig();

    @GET("user-access/category")
    Call<ApiResponse<List<Category>>> getCategory(@Header("Authorization") String str, @Query("lang") String str2);

    @GET("user/orders")
    Call<ApiResponse<DetailOrderItem>> getDetailOrder(@Header("Authorization") String str, @Query("orderId") String str2);

    @GET("user-access/events")
    Call<ApiResponse<List<Event>>> getEvents(@Header("Authorization") String str);

    @GET("user-access/faq")
    Call<ApiResponse<List<FaqItem>>> getFAQ(@Header("Authorization") String str);

    @GET("user-access/order")
    Call<ApiResponse<List<UpcommingItem>>> getHistory(@Header("Authorization") String str, @Query("page") int i, @Query("type") String str2);

    @GET("user-access/profile")
    Call<ApiResponse<User>> getInfor(@Header("Authorization") String str);

    @GET("user-access/expert")
    Call<ApiResponse<Expert>> getInforEx(@Header("Authorization") String str, @Query("id") String str2);

    @GET("user-access/notification")
    Call<ApiResponse<List<NotificationItemPage>>> getNotification(@Header("Authorization") String str, @Query("page") String str2);

    @FormUrlEncoded
    @POST("auth/customer-ak")
    Call<ApiResponse<User>> getProfileWithAK(@Field("accessToken") String str);

    @GET("auth/customer-facebook")
    Call<ApiResponse<User>> getProfileWithFb(@Query("accessToken") String str);

    @GET("auth/customer-google")
    Call<ApiResponse<User>> getProfileWithGG(@Query("accessToken") String str);

    @GET("auth/customer-instagram")
    Call<ApiResponse<User>> getProfileWithInsta(@Query("accessToken") String str);

    @GET("user-access/category?type='lastCategory'")
    Call<ApiResponse<List<Category>>> getRecentlyCategory(@Header("Authorization") String str, @Query("lang") String str2);

    @GET("user-access/tag")
    Call<ApiResponse<List<Tag>>> getTags(@Header("Authorization") String str, @Query("tag") String str2, @Query("category") String str3);

    @GET("allservices")
    Call<ApiResponse<List<Work>>> getTypeWorks();

    @GET("user-access/order")
    Call<ApiResponse<List<UpcommingItem>>> getUpcoming(@Header("Authorization") String str, @Query("type") String str2);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ResponseBody> linkSocial(@Header("Authorization") String str, @Field("type") String str2, @Field("accessToken") String str3);

    @GET("user-access/logout")
    Call<ResponseBody> logOut(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("auth/customer-signin")
    Call<ApiResponse<User>> login(@Field("username") String str, @Field("password") String str2);

    @POST("user-access/order")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<ApiResponse<OrderItem>> order(@Header("Authorization") String str, @Body OrderItem orderItem);

    @FormUrlEncoded
    @POST("user-access/tag")
    Call<ApiResponse<List<Tag>>> postTag(@Header("Authorization") String str, @Field("tag") String str2, @Field("category") String str3);

    @GET("user/profile-hci")
    Call<ApiResponse<User>> profileHic(@Header("Authorization") String str, @Query("id") String str2);

    @GET("user-access/notification?type=read-all")
    Call<ResponseBody> readAllNoti(@Header("Authorization") String str);

    @GET("user-access/notification")
    Call<ResponseBody> readNoti(@Header("Authorization") String str, @Query("id") String str2);

    @POST("auth/customer-signup")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<AuthResponse> register(@Body ParamRegUser paramRegUser);

    @FormUrlEncoded
    @POST("auth/customer-signup")
    Call<AuthResponse> register(@Field("password") String str, @Field("first_name") String str2, @Field("last_name") String str3, @Field("email") String str4, @Field("birthday") String str5, @Field("gender") String str6, @Field("phone") String str7, @Field("avatar") String str8, @Field("address") String str9);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ResponseBody> registerOnsignal(@Header("Authorization") String str, @Field("uuid") String str2, @Field("oneSignalId") String str3, @Field("deviceInfo") String str4, @Query("type") String str5);

    @GET("app/forgotPassword")
    Call<ResponseBody> sendEmailVerify(@Query("username") String str);

    @GET("user/send-sms")
    Call<ApiResponse<String>> sendSMSVerify(@Header("Authorization") String str);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ApiResponse<User>> updateInfo(@Header("Authorization") String str, @Field("first_name") String str2, @Field("last_name") String str3, @Field("address") String str4, @Field("gender") String str5, @Field("birthday") String str6, @Field("avatar") String str7);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ApiResponse<User>> updateInfoAKReg(@Header("Authorization") String str, @Field("first_name") String str2, @Field("last_name") String str3, @Field("address") String str4, @Field("gender") String str5, @Field("birthday") String str6, @Field("avatar") String str7, @Field("email") String str8, @Field("password") String str9);

    @FormUrlEncoded
    @PUT("user-access/profile")
    Call<ApiResponse<User>> updateInfoReg(@Header("Authorization") String str, @Field("first_name") String str2, @Field("last_name") String str3, @Field("address") String str4, @Field("gender") String str5, @Field("birthday") String str6, @Field("avatar") String str7, @Field("email") String str8, @Field("phone") String str9, @Field("password") String str10);

    @POST("upload/upload-audio")
    @Multipart
    Call<ApiResponse<String>> uploadAudio(@Part MultipartBody.Part part);

    @POST("upload/upload-avatar")
    @Multipart
    Call<ResponseBody> uploadAvatar(@Part MultipartBody.Part part);

    @POST("upload/upload-image")
    @Multipart
    Call<ApiResponse<String>> uploadAvtPhotos(@Part MultipartBody.Part part);

    @POST("upload/upload-image")
    @Multipart
    Call<ApiResponse<String>> uploadPhotos(@Part MultipartBody.Part part);

    @GET("user-access/order")
    Call<ApiResponse<String>> verifyPromotionCode(@Header("Authorization") String str, @Query("code") String str2, @Query("type") String str3);

    @GET("user/sms-verify")
    Call<ApiResponse<String>> verifySMS(@Header("Authorization") String str, @Query("code") String str2);
}
