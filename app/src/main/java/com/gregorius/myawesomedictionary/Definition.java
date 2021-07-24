package com.gregorius.myawesomedictionary;

public class Definition {

    private String image_url;
    private String type;
    private String definition;

    public Definition(String image_url, String type, String definition) {
        this.image_url = image_url;
        this.type = type;
        this.definition = definition;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImg_url(String image_url) {
        this.image_url = image_url;
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
