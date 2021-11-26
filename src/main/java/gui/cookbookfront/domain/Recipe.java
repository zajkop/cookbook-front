package gui.cookbookfront.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe implements Serializable {

    private int id;
    private String name;
    private String description;
    private String category;
    private String imageUri;
    private List<String> ingredients;
    private Kcal kcal;

    public String ingredientsAsString() {
        return StringUtils.join(ingredients, ",");
    }

    public String uriAsBase64Image() {
        return Base64.getEncoder().encodeToString(RecipeHelper.getImageByUri(imageUri));
    }
}
