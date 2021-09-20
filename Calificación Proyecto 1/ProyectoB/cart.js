/**
 * Compiladores 2s 2021
 */
class Carrito {
    qty = 0;
    //products = [];

    addProducto(product) {
        qty = qty + 1;
        //products.push(product);
    }

    removeProducto() {
        qty = qty - 1;
    }
}

//module.exports = Carrito;