class Draws {
    
    start () {
        drawBloque();
        drawMarco(10);
        drawTriangulo(25);
        drawPiramide();
    }

    drawBloque() {
        let n = 5; // row or column count
        // defining an empty string
        let string = "";

        for(let i = 0; i < n; i++) { // external loop
        for(let j = 0; j < n; j++) { // internal loop
            string += "*";
        }
        // newline after each row
        string += "\n";
        }
        // printing the string
        console.log(string);
    }

    drawMarco(drawMarcon) {
        let drawMarcostring = "";
        for(let drawMarcoi = 0; drawMarcoi < drawMarcon; drawMarcoi++) {
        for(let drawMarcoj = 0; drawMarcoj < drawMarcon; drawMarcoj++) {
            if(drawMarcoi === 0 || drawMarcoi === drawMarcon - 1) {
            drawMarcostring += "*";
            }
            else {
            if(drawMarcoj === 0 || drawMarcoj === drawMarcon - 1) {
                drawMarcostring += "*";
            }
            else {
                drawMarcostring += " ";
            }
            }
        }
        drawMarcostring += "\n";
        }
        console.log(drawMarcostring);
    }

    drawTriangulo(drawTriangulon) {
        let drawTriangulostring = "";
        for (let drawTrianguloi = 1; drawTrianguloi <= drawTriangulon; drawTrianguloi++) {
          for (let drawTrianguloj = 0; drawTrianguloj < drawTrianguloi; drawTrianguloj++) {
            drawTriangulostring += "*";
          }
          drawTriangulostring += "\n";
        }
        console.log(drawTriangulostring);
    }
    
    drawPiramide() {
        let drawPiramide = 5;
        let drawPiramidestring = "";
        // External loop
        for (let drawPiramidei = 1; drawPiramidei <= drawPiramide; drawPiramidei++) {
        // printing spaces
        for (let drawPiramidej = 1; drawPiramidej <= drawPiramide - drawPiramidei; drawPiramidej++) {
            drawPiramidestring += " ";
        }
        // printing star
        for (let drawPiramidek = 0; drawPiramidek < 2 * drawPiramidei - 1; drawPiramidek++) {
            drawPiramidestring += "*";
        }
        drawPiramidestring += "\n";
        }
        console.log(drawPiramidestring);
    }
}

//module.exports = Draws;
