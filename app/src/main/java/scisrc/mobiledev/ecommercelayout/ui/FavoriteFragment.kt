package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentFavoriteBinding
import scisrc.mobiledev.ecommercelayout.model.FavoriteItem

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoritesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesRecyclerView = binding.favoritesRecyclerView
        favoritesRecyclerView.layoutManager = LinearLayoutManager(context)

        // ✅ รายการสินค้าตัวอย่างที่บันทึกเป็นรายการโปรด
        val favoriteItems = listOf(
            FavoriteItem("ปากกา", "20", R.drawable.pen),
            FavoriteItem("สมุด", "50", R.drawable.notebook),
            FavoriteItem("หูฟัง", "999", R.drawable.headphones)
        )

        // ✅ ตั้งค่า Adapter ให้ `RecyclerView`
        val favoriteAdapter = FavoriteAdapter(favoriteItems)
        favoritesRecyclerView.adapter = favoriteAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
