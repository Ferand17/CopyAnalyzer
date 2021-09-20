/**
 * Compiladores 2s 2021
 */
class Product {
    type = -1;
    name = "";
    price = "";
    sell_price = "";

    /**
     * set price
     */
    setPrice(newprice) {
        price = newprice
    }

    /**
     * set sell price
     */
    setName(newname) {

        name = newname;

    }

    setsellPrice(new_sell_price) {
        
        sell_price = new_sell_price;
    }

    /**
     * show info product
     */
    setType(type) {
        if (type == "FOOD") {
            type = 1;
        } else if (type == "CLOTHES") {
            type = 2
        }else if (type == "SHOES") {
            type = 3
        }else if (type == "TECNOLOGY") {
            type = 4
        }
    }
}

//module.exports = Product;
