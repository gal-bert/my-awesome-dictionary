package com.gregorius.myawesomedictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WordDefinitionResponse {

    @SerializedName("img_url")
    @Expose
    public String img_url;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("definition")
    @Expose
    public String definition;

}
