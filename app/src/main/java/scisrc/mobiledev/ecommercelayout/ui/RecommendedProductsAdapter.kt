package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemRecommendedProductBinding
import scisrc.mobiledev.ecommercelayout.model.Product

class RecommendedProductsAdapter(private val productList: List<Product>) : RecyclerView.Adapter<RecommendedProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemRecommendedProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRecommendedProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        // กำหนดข้อมูลของสินค้าให้กับ view ใน item layout
        holder.binding.tvProductName.text = product.name
        holder.binding.tvProductPrice.text = product.price
        holder.binding.tvRecommendImage.setImageResource(product.imageResource) // ✅ กำหนดรูปให้ ImageView
    }


    override fun getItemCount(): Int = productList.size
}
