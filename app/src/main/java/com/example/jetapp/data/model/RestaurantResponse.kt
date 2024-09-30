package com.example.jetapp.data.model

import com.google.gson.annotations.SerializedName

data class RestaurantResponseContainer(
    @SerializedName("Restaurants") val restaurants: List<RestaurantResponse>
)

data class RestaurantResponse(
    @SerializedName("Id") val id: Long,
    @SerializedName("Name") val name: String,
    @SerializedName("UniqueName") val uniqueName: String,
    @SerializedName("City") val city: String,
    @SerializedName("Postcode") val postcode: String,
    @SerializedName("Latitude") val latitude: Long,
    @SerializedName("Longitude") val longitude: Long,
    @SerializedName("NumberOfRatings") val numberOfRatings: Long,
    @SerializedName("RatingAverage") val ratingAverage: Double,
    @SerializedName("Description") val description: String,
    @SerializedName("Url") val url: String,
    @SerializedName("LogoUrl") val logoUrl: String,
    @SerializedName("IsTestRestaurant") val isTestRestaurant: Boolean,
    @SerializedName("IsHalal") val isHalal: Boolean,
    @SerializedName("IsNew") val isNew: Boolean,
    @SerializedName("ReasonWhyTemporarilyOffline") val reasonWhyTemporarilyOffline: String,
    @SerializedName("DriveDistance") val driveDistance: Double,
    @SerializedName("DriveInfoCalculated") val driveInfoCalculated: Boolean,
    @SerializedName("IsCloseBy") val isCloseBy: Boolean,
    @SerializedName("OfferPercent") val offerPercent: Long,
    @SerializedName("NewnessDate") val newnessDate: String,
    @SerializedName("OpeningTime") val openingTime: String?,
    @SerializedName("OpeningTimeUtc") val openingTimeUtc: String?,
    @SerializedName("OpeningTimeIso") val openingTimeIso: String,
    @SerializedName("OpeningTimeLocal") val openingTimeLocal: String,
    @SerializedName("DeliveryOpeningTimeLocal") val deliveryOpeningTimeLocal: String,
    @SerializedName("DeliveryOpeningTime") val deliveryOpeningTime: String?,
    @SerializedName("DeliveryOpeningTimeUtc") val deliveryOpeningTimeUtc: String?,
    @SerializedName("DeliveryStartTime") val deliveryStartTime: String,
    @SerializedName("DeliveryWorkingTimeMinutes") val deliveryWorkingTimeMinutes: Long?,
    @SerializedName("DeliveryEtaMinutes") val deliveryEtaMinutes: RestaurantDeliveryEtaMinutesResponse?,
    @SerializedName("IsCollection") val isCollection: Boolean,
    @SerializedName("IsDelivery") val isDelivery: Boolean,
    @SerializedName("IsFreeDelivery") val isFreeDelivery: Boolean,
    @SerializedName("IsOpenNowForCollection") val isOpenNowForCollection: Boolean,
    @SerializedName("IsOpenNowForDelivery") val isOpenNowForDelivery: Boolean,
    @SerializedName("IsOpenNowForPreorder") val isOpenNowForPreorder: Boolean,
    @SerializedName("IsOpenNow") val isOpenNow: Boolean,
    @SerializedName("IsTemporarilyOffline") val isTemporarilyOffline: Boolean,
    @SerializedName("DeliveryZipcode") val deliveryZipcode: String?,
    @SerializedName("DeliveryCost") val deliveryCost: Long,
    @SerializedName("MinimumDeliveryValue") val minimumDeliveryValue: Long,
    @SerializedName("SecondDateRanking") val secondDateRanking: Long,
    @SerializedName("DefaultDisplayRank") val defaultDisplayRank: Long,
    @SerializedName("SponsoredPosition") val sponsoredPosition: Long,
    @SerializedName("SecondDateRank") val secondDateRank: Long,
    @SerializedName("Score") val score: Double,
    @SerializedName("IsTemporaryBoost") val isTemporaryBoost: Boolean,
    @SerializedName("IsSponsored") val isSponsored: Boolean,
    @SerializedName("IsPremier") val isPremier: Boolean,
    @SerializedName("ShowSmiley") val showSmiley: Boolean,
    @SerializedName("SmileyElite") val smileyElite: Boolean,
    @SerializedName("SendsOnItsWayNotifications") val sendsOnItsWayNotifications: Boolean,
    @SerializedName("BrandName") val brandName: String,
    @SerializedName("IsBrand") val isBrand: Boolean,
    @SerializedName("LastUpdated") val lastUpdated: String,
    @SerializedName("Tags") val tags: List<String>,
    @SerializedName("CuisineTypes") val cuisineTypes: List<RestaurantCuisineResponse>,
    @SerializedName("Cuisines") val cuisines: List<RestaurantCuisineResponse>
)

data class RestaurantCuisineResponse(
    @SerializedName("Id") val id: Long,
    @SerializedName("IsTopCuisine") val isTopCuisine: Boolean,
    @SerializedName("Name") val name: String,
    @SerializedName("SeoName") val seoName: String,
)

data class RestaurantDeliveryEtaMinutesResponse(
    @SerializedName("RangeLower") val rangeLower: Long,
    @SerializedName("RangeUpper") val rangeUpper: Long,
)