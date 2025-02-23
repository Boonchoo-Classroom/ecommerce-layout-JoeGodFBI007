package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemCartBinding
import scisrc.mobiledev.ecommercelayout.model.CartItem

class CartAdapter(private val cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.binding.tvProductName.text = item.name
        holder.binding.tvProductPrice.text = "฿${item.price}"
        holder.binding.tvQuantity.text = "จำนวน: ${item.quantity}"
        holder.binding.ivProductImage.setImageResource(item.imageResource) // แสดงรูปสินค้า
    }

    override fun getItemCount(): Int = cartItems.size
}
