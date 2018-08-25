package leandro.com.gameloversapp.Data;

public class Cover {
    String url;
    String cloudinary_id;
    int widht;
    int height;

    public Cover() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCloudinary_id() {
        return cloudinary_id;
    }

    public void setCloudinary_id(String cloudinary_id) {
        this.cloudinary_id = cloudinary_id;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBigCover(){
        return url.replace("thumb", "cover_big");
    }
}
