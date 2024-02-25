import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dodopizza.databinding.ActivityPizzaDetailsBinding

class PizzaDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPizzaDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzaDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = intent.getSerializableExtra("pizza") as? Pizza
        pizza?.let {
            binding.apply {
                textViewName.text = it.name
                textViewDescription.text = it.description
                imageViewPizza.setImageResource(it.image)
            }
        }
    }
}
