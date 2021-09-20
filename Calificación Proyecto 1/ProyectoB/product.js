/**
 * Compiladores 2s 2021
 */
class Producto {
    type = -1;
    name = "";
    price = "";
    sell_price = "";

    /**
     * set price
     */
    setPrecio(newprice) {
        price = newprice
    }

    /**
     * set sell price
     */
    setNombre(newname) {

        name = newname;

    }

    setPrecioVenta(new_sell_price) {
        
        sell_price = new_sell_price;
    }

    /**
     * show info product
     */
    setTipo(type) {
        if (type == "COMIDA") {
            type = 1;
        } else if (type == "COSAS") {
            type = 2
        }else if (type == "ZAPATOS") {
            type = 3
        }else if (type == "ELECTRÓNICOS") {
            type = 4
        }
    }
}

//module.exports = Producto;
