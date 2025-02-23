package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.databinding.ItemCategoryBinding
import scisrc.mobiledev.ecommercelayout.model.Category

class CategoryAdapter(
    private val categoryList: List<Category>,
    private val onCategoryClick: (String) -> Unit // Callback เมื่อคลิกหมวดหมู่
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.binding.tvCategoryName.text = category.name
        holder.binding.ivCategoryImage.setImageResource(category.imageResource)

        holder.itemView.setOnClickListener {
            onCategoryClick(category.name) // เมื่อคลิกที่หมวดหมู่
        }
    }

    override fun getItemCount(): Int = categoryList.size
}
