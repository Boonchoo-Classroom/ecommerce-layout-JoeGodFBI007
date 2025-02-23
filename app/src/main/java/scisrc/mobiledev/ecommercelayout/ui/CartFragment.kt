package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCartBinding
import scisrc.mobiledev.ecommercelayout.model.CartItem

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var cartRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cartRecyclerView = binding.cartRecyclerView
        cartRecyclerView.layoutManager = LinearLayoutManager(context)

        // ✅ สร้างรายการสินค้าตัวอย่าง
        val cartItems = listOf(
            CartItem("ปากกา", "20", 2, R.drawable.pen),
            CartItem("สมุด", "50", 1, R.drawable.notebook),
            CartItem("หูฟัง", "999", 1, R.drawable.headphones)
        )

        val cartAdapter = CartAdapter(cartItems)
        cartRecyclerView.adapter = cartAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
