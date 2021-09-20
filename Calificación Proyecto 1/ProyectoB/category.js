/**
 * Compiladores 2s 2021
 */
class Categoria {
    /**
     * Categories are usefull to filter products
     */

    id = 0; //randomId();
    name = "";
    setNombre(newName) {
        name = newName;
    }

    showNombre() {

        console.log(name);
        
    }

}
//module.exports = Category;
