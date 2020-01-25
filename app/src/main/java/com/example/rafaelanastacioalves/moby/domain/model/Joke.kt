package com.example.rafaelanastacioalves.moby.domain.model;

import com.google.gson.annotations.SerializedName


class Joke {
    lateinit var value: String
    @SerializedName("icon_url")
    lateinit var iconUrl: String
    lateinit var url: String
}
