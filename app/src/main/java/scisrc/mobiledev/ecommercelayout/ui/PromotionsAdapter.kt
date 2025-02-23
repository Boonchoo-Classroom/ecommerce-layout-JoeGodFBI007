package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemPromotionBinding
import scisrc.mobiledev.ecommercelayout.model.Product

class PromotionsAdapter(private val promotions: List<Product>) : RecyclerView.Adapter<PromotionsAdapter.PromotionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        val binding = ItemPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        val promotion = promotions[position]
        holder.binding.tvPromotionName.text = promotion.name
        holder.binding.tvPromotionPrice.text = promotion.price
        holder.binding.ivPromotionImage.setImageResource(promotion.imageResource) // ใช้รูปของแต่ละโปรโมชั่น
    }


    override fun getItemCount(): Int = promotions.size

    inner class PromotionViewHolder(val binding: ItemPromotionBinding) : RecyclerView.ViewHolder(binding.root)
}
