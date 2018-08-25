package leandro.com.gameloversapp.Data;

import java.util.List;

public class Platform {

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

    public static String getPlatforms(List<Platform> platforms){

        try {
            if(platforms.size() >0) {
                StringBuilder rString = new StringBuilder();
                String separator = ", ";
                for (int i = 0; i < platforms.size(); i++) {
                    if (i > 0 && i <= platforms.size() - 1) {
                        rString.append(separator).append(platforms.get(i).getName());
                    } else {
                        rString.append(platforms.get(i).getName());
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

    public static String getPlatforms(int[] platforms){
        try {
            if(platforms.length >0) {
                StringBuilder rString = new StringBuilder();
                String separator = ",";
                for (int i = 0; i < platforms.length; i++) {
                    if (i > 0 && i <= platforms.length - 1) {
                        rString.append(separator).append(String.valueOf(platforms[i]));
                    } else {
                        rString.append(String.valueOf(platforms[i]));
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
