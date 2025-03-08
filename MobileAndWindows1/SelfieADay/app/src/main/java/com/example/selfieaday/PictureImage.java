package com.example.selfieaday;

public class PictureImage {
    private String id;

    private String image_url;

    public PictureImage(String id, String image_url)
    {
        this.id = id;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
