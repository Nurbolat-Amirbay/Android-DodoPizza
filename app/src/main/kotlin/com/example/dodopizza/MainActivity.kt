package com.example.dodopizza

import Pizza
import PizzaAdapter
import PizzaDetailsActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dodopizza.databinding.ActivityMainBinding
import java.io.Serializable


class MainActivity : AppCompatActivity(), PizzaAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pizzaAdapter: PizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        pizzaAdapter = PizzaAdapter(this, getPizzas())
        binding.recyclerView.adapter = pizzaAdapter
    }

    // Dummy data for pizzas
    private fun getPizzas(): List<Pizza> {
        // Implementation for fetching pizzas from a data source would go here
        return listOf(
            Pizza("Margherita", "Classic Italian pizza with tomato sauce and mozzarella cheese", R.drawable.margherita),
            Pizza("Pepperoni", "Pizza topped with pepperoni slices and mozzarella cheese", R.drawable.pepperoni),
            // Add more pizzas
        )
    }

    override fun onItemClick(pizza: Pizza) {
        // Open PizzaDetailsActivity and pass selected pizza
        val intent = Intent(this, PizzaDetailsActivity::class.java).apply {
            putExtra("pizza", pizza as Serializable)
        }
        startActivity(intent)
    }
}
