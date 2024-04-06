package com.ztktsn.dog

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class dog(
    @SerializedName("name") val name: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("barking") val barking: Int,
    @SerializedName("shedding") val shedding: Int,
    @SerializedName("energy") val energy: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageLink)
        parcel.writeInt(barking)
        parcel.writeInt(shedding)
        parcel.writeInt(energy)
        parcel.writeInt(minLifeExpectancy)
        parcel.writeInt(maxLifeExpectancy)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dog> {
        override fun createFromParcel(parcel: Parcel): dog {
            return dog(parcel)
        }

        override fun newArray(size: Int): Array<dog?> {
            return arrayOfNulls(size)
        }
    }
}