package com.gregorius.myawesomedictionary;

public class Definition {

    private String img_url;
    private String type;
    private String definition;

    public Definition(String img_url, String type, String definition) {
        this.img_url = img_url;
        this.type = type;
        this.definition = definition;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
