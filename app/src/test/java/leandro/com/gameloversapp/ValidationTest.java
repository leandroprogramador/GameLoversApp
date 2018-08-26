package leandro.com.gameloversapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import leandro.com.gameloversapp.Data.Genres;

public class ValidationTest {

    @Test
    public void testGenresNullString(){
        List<Genres> genres = new ArrayList<>();
        Assert.assertEquals("Não Informado", Genres.getGenres(genres));
    }

    @Test
    public void testGenresEmptyString(){
        List<Genres> genres = new ArrayList<>();
        Genres genres1 = new Genres();
        genres1.setName("");
        Assert.assertEquals("Não Informado", Genres.getGenres(genres));
    }

    @Test
    public void testGenresNullId(){
        int ids[] = null;
        Assert.assertEquals(Genres.getGenres(ids), "Não Informado");
    }
}
