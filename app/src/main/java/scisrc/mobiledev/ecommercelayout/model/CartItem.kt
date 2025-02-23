package scisrc.mobiledev.ecommercelayout.model

data class CartItem(
    val name: String,
    val price: String,
    val quantity: Int,
    val imageResource: Int // เพิ่มรูปสินค้า
)