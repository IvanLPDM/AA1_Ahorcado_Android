import com.example.ahorcadogame.R

data class Level(
    val name: String
) {
    val letters: Int = name.length
    val word: String = name
    val imageRes: Int = when (letters) {
        in 1..4 -> R.mipmap.easy_level
        in 5..7 -> R.mipmap.medium_level
        else -> R.mipmap.hard_level
    }
}