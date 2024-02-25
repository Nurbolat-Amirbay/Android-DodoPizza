import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.MainActivity

class PizzaAdapter(
    private val pizzas: MainActivity,
    private val listener: List<Pizza>
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(pizza: Pizza)
    }

    inner class PizzaViewHolder(private val binding: ItemPizzaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            binding.apply {
                textViewName.text = pizza.name
                textViewDescription.text = pizza.description
                imageViewPizza.setImageResource(pizza.image)
                root.setOnClickListener { listener.onItemClick(pizza) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding = ItemPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaViewHolder(binding)
    }



    override fun getItemCount(): Int {
        return pizzas.size
    }
}
