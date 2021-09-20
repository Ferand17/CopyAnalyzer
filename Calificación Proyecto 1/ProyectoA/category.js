/**
 * Compiladores 2s 2021
 */
class Category {
    /**
     * Categories are usefull to filter products
     */

    id = 0; //randomId();
    name = "";
    setName(newName) {
        name = newName;
    }

    showName() {

        console.log(name);
        
    }

}
//module.exports = Category;
