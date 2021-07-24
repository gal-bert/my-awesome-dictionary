package com.gregorius.myawesomedictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WordListResponse {

    @SerializedName("word")
    @Expose
    public String word;

    @SerializedName("definitions")
    @Expose
    public List<WordDefinitionResponse> definitions = null;

}
