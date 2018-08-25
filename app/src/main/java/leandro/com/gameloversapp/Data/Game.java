package leandro.com.gameloversapp.Data;

public class Game {
    int id;
    String name;
    Cover cover;
    String summary;
    int[] genres;
    int platforms[];

    public Game() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }

    public int[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(int[] platforms) {
        this.platforms = platforms;
    }
}
