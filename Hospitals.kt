package com.suresh.retrofitdemo

import com.google.gson.annotations.SerializedName

public class Hospitals {
    public var id: String? = null
    @SerializedName("hospital_name")
    public var hospitalName: String? = null
    public var address: String? = null
}
