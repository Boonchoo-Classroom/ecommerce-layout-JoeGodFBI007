package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductBinding
import scisrc.mobiledev.ecommercelayout.model.Category
import scisrc.mobiledev.ecommercelayout.model.Product

class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var productsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryRecyclerView = binding.categoryRecyclerView
        productsRecyclerView = binding.productsRecyclerView

        // ✅ กำหนดค่าให้ RecyclerView หมวดหมู่สินค้า
        val categories = listOf(
            Category("อุปกรณ์เครื่องเขียน", R.drawable.ic_home),
            Category("อุปกรณ์กีฬา", R.drawable.ic_home),
            Category("Gadget", R.drawable.ic_home),
            Category("เสื้อผ้า", R.drawable.ic_home)
        )

        val categoryAdapter = CategoryAdapter(categories) { category ->
            loadProducts(category) // โหลดสินค้าตามหมวดหมู่
        }

        // ✅ ตั้งค่า RecyclerView ให้แสดงหมวดหมู่แบบ List แนวตั้ง
        categoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        categoryRecyclerView.adapter = categoryAdapter
    }

    // ✅ โหลดสินค้าตามหมวดหมู่ที่เลือก
    private fun loadProducts(category: String) {
        val products = when (category) {
            "อุปกรณ์เครื่องเขียน" -> listOf(Product("ปากกา", "20", R.drawable.pen))
            "อุปกรณ์กีฬา" -> listOf(Product("ลูกบอล", "300", R.drawable.pen))
            "Gadget" -> listOf(Product("หูฟัง", "999", R.drawable.headphones))
            "เสื้อผ้า" -> listOf(Product("เสื้อยืด", "199", R.drawable.pen))
            else -> emptyList()
        }

        val productAdapter = RecommendedProductsAdapter(products)
        productsRecyclerView.layoutManager = LinearLayoutManager(context)
        productsRecyclerView.adapter = productAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
