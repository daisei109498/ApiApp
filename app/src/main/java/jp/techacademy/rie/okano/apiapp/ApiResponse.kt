package jp.techacademy.rie.okano.apiapp
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("results")
    val results: Results
)

data class Results(
    @SerializedName("api_version")
    val apiVersion: String,
    @SerializedName("results_available")
    val resultsAvailable: Int,
    @SerializedName("results_returned")
    val resultsReturned: String,
    @SerializedName("results_start")
    val resultsStart: Int,
    @SerializedName("shop")
    val shop: List<Shop>
)

data class Shop(
    @SerializedName("access")
    val access: String,
    @SerializedName("address")
    var address: String,
    @SerializedName("band")
    val band: String,
    @SerializedName("barrier_free")
    val barrierFree: String,
    @SerializedName("budget")
    val budget: Budget,
    @SerializedName("budget_memo")
    val budgetMemo: String,
    @SerializedName("capacity")
    val capacity: Int,
    @SerializedName("card")
    val card: String,
    @SerializedName("catch")
    val `catch`: String,
    @SerializedName("charter")
    val charter: String,
    @SerializedName("child")
    val child: String,
    @SerializedName("close")
    val close: String,
    @SerializedName("coupon_urls")
    var couponUrls: CouponUrls,
    @SerializedName("course")
    val course: String,
    @SerializedName("english")
    val english: String,
    @SerializedName("free_drink")
    val freeDrink: String,
    @SerializedName("free_food")
    val freeFood: String,
    @SerializedName("genre")
    val genre: Genre,
    @SerializedName("horigotatsu")
    val horigotatsu: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("karaoke")
    val karaoke: String,
    @SerializedName("ktai_coupon")
    val ktaiCoupon: Int,
    @SerializedName("large_area")
    val largeArea: LargeArea,
    @SerializedName("large_service_area")
    val largeServiceArea: LargeServiceArea,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("logo_image")
    var logoImage: String,
    @SerializedName("lunch")
    val lunch: String,
    @SerializedName("middle_area")
    val middleArea: MiddleArea,
    @SerializedName("midnight")
    val midnight: String,
    @SerializedName("mobile_access")
    val mobileAccess: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("name_kana")
    val nameKana: String,
    @SerializedName("non_smoking")
    val nonSmoking: String,
    @SerializedName("open")
    val `open`: String,
    @SerializedName("other_memo")
    val otherMemo: String,
    @SerializedName("parking")
    val parking: String,
    @SerializedName("party_capacity")
    val partyCapacity: Any,
    @SerializedName("pet")
    val pet: String,
    @SerializedName("photo")
    val photo: Photo,
    @SerializedName("private_room")
    val privateRoom: String,
    @SerializedName("service_area")
    val serviceArea: ServiceArea,
    @SerializedName("shop_detail_memo")
    val shopDetailMemo: String,
    @SerializedName("show")
    val show: String,
    @SerializedName("small_area")
    val smallArea: SmallArea,
    @SerializedName("station_name")
    val stationName: String,
    @SerializedName("sub_genre")
    val subGenre: SubGenre,
    @SerializedName("tatami")
    val tatami: String,
    @SerializedName("tv")
    val tv: String,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("wedding")
    val wedding: String,
    @SerializedName("wifi")
    val wifi: String
)

data class Budget(
    @SerializedName("average")
    val average: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class CouponUrls(
    @SerializedName("pc")
    val pc: String,
    @SerializedName("sp")
    var sp: String
)

data class Genre(
    @SerializedName("catch")
    val `catch`: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class LargeArea(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class LargeServiceArea(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class MiddleArea(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class Photo(
    @SerializedName("mobile")
    val mobile: Mobile,
    @SerializedName("pc")
    val pc: Pc
)

data class ServiceArea(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class SmallArea(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class SubGenre(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)

data class Urls(
    @SerializedName("pc")
    val pc: String
)

data class Mobile(
    @SerializedName("l")
    val l: String,
    @SerializedName("s")
    val s: String
)

data class Pc(
    @SerializedName("l")
    val l: String,
    @SerializedName("m")
    val m: String,
    @SerializedName("s")
    val s: String
)