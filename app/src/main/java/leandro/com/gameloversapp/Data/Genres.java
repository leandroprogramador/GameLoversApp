package leandro.com.gameloversapp.Data;

import java.util.List;

public class Genres {

    int id;
    String name;

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

    public static String getGenres(List<Genres> genres){

        try {
            if(genres.size() >0) {
                StringBuilder rString = new StringBuilder();
                String separator = ", ";
                for (int i = 0; i < genres.size(); i++) {
                    if (i > 0 && i <= genres.size() - 1) {
                        rString.append(separator).append(genres.get(i).getName());
                    } else {
                        rString.append(genres.get(i).getName());
                    }
                }

                return rString.toString();
            } else {
                throw new Exception();
            }
        } catch (Exception ex){
            return "Não Informado";
        }
    }

    public static String getGenres(int[] genres){
        try {
            if(genres.length >0) {
                StringBuilder rString = new StringBuilder();
                String separator = ",";
                for (int i = 0; i < genres.length; i++) {
                    if (i > 0 && i <= genres.length - 1) {
                        rString.append(separator).append(String.valueOf(genres[i]));
                    } else {
                        rString.append(String.valueOf(genres[i]));
                    }
                }

                return rString.toString();
            } else {
                throw new Exception();
            }
        } catch (Exception ex){
            return "Não Informado";
        }
    }
}
