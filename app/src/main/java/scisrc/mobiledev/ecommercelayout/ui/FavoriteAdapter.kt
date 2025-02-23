package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemFavoriteBinding
import scisrc.mobiledev.ecommercelayout.model.FavoriteItem

class FavoriteAdapter(private val favoriteItems: List<FavoriteItem>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    inner class FavoriteViewHolder(val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoriteItems[position]
        holder.binding.tvProductName.text = item.name
        holder.binding.tvProductPrice.text = "฿${item.price}"
        holder.binding.ivProductImage.setImageResource(item.imageResource) // แสดงรูปสินค้า
    }

    override fun getItemCount(): Int = favoriteItems.size
}
