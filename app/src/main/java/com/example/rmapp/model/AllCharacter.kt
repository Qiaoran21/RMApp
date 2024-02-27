import com.google.gson.annotations.SerializedName
import com.example.rmapp.model.Character

data class AllCharacter(
    @SerializedName("results")
    var characterList: List<Character>
)