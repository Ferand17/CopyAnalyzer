/**
 * Compiladores 2s 2021
 */
class Cart {
    qty = 0;
    products = [];

    addProduct(product) {
        qty = qty + 1;
        //products.push(product);
    }

    removeProduct() {
        qty = qty - 1;
    }
}

//module.exports = Cart;