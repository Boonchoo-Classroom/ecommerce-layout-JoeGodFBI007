package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding
import scisrc.mobiledev.ecommercelayout.ui.RecommendedProductsAdapter
import scisrc.mobiledev.ecommercelayout.model.Product

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recommendedProductsRecyclerView: RecyclerView
    private lateinit var promotionsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // หา RecyclerView ใน layout
        recommendedProductsRecyclerView = binding.recommendedProductsRecyclerView
        promotionsRecyclerView = binding.promotionsRecyclerView

        // กำหนด LayoutManager ให้กับ RecyclerView
        recommendedProductsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        promotionsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // ✅ สร้างข้อมูลจำลองสำหรับสินค้าแนะนำ (ไม่มีซ้อน listOf())
        val recommendedProducts = listOf(
            Product("หูฟัง", "999", R.drawable.headphones)
        )

        // ✅ สร้าง Adapter และเชื่อมกับ RecyclerView
        val recommendedAdapter = RecommendedProductsAdapter(recommendedProducts)
        recommendedProductsRecyclerView.adapter = recommendedAdapter

        // ✅ สร้างข้อมูลจำลองสำหรับโปรโมชั่น (ไม่มีซ้ำ)
        val promotions = listOf(
            Product("ส่วนลด 50%", "ลด 50%", R.drawable.sale_50_off_cards_5_pack),
            Product("ของแถมฟรี", "รับฟรี!", R.drawable.buy_1_get_free_1_label_template_design_illustration_vector)
        )

        // ✅ สร้าง Adapter และเชื่อมกับ RecyclerView
        val promotionsAdapter = PromotionsAdapter(promotions)
        promotionsRecyclerView.adapter = promotionsAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}