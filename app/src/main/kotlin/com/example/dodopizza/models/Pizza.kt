import java.io.Serializable

data class Pizza(
    val name: String,
    val description: String,
    val image: Int
) : Serializable
