let Cart = require("./cart")
let product = require("./product")
let cat = require("./category")
let drw = require("./draws")
const Math = require("./math")
const Product = require("./product")
const Draws = require("./draws")

/**
 * 
 */
class main {
    
    start() {
        console.log("Primer Proyecto");
        console.log("Compiladores 1");
        console.log("Segundo semestre");
        console.log("2021");
        console.log("+++++++++++++++++++++++++++++++++++");
        //let cart = new Cart();

        /*
        let product = new Product();
        product.setName("Cereal");
        product.setPrice(12.5);
        product.setsellPrice(15);
        product.setType("FOOD");
        cart.addProduct(product);

        product = new Product();
        product.setName("Pastas");
        product.setPrice(5.5);
        product.setsellPrice(7.75);
        product.setType("FOOD");
        cart.addProduct(product);

        product = new Product();
        product.setName("Pan");
        product.setPrice(12.5);
        product.setsellPrice(15);
        product.setType("FOOD");
        cart.addProduct(product);
       
        console.log("show products: ");
        cart.products.forEach( element => {
            console.log(`${element.name}: ${element.type}`);
        });
        */

        //new Draws().start();
        addCategories(10);
        showMath();
    }

    addCategories(t) {
        console.log("Categories");
        var i = 0;
        while (i < t) {
            let name = "Category No. "+i;
            console.log(name);
            //let cat = new Category();
            //cat.setName(name);
            //cat.showName();
            i = i + 1;
        }
    }

    showMath() {
        //const math = new Math();
        console.log("SHOW FACTORIAL");
        showFactorial(7);
        console.log("TABLES");
        showTables();
        console.log("SHOW FIBONACCI");
        showFib(7);
    }
}

//new main().start();