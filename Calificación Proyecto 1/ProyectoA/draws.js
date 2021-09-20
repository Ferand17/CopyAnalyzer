class Draws {
    
    start () {
        drawSquare();
        drawFrame(10);
        drawTriangle(25);
        drawTriangle2(25);
        drawPiramid();
        drawPiramid2();
    }

    drawSquare() {
        let n = 5; // row or column count
        // defining an empty string
        let string = "";

        for(let i = 0; i < n; i++) { 
        for(let j = 0; j < n; j++) { 
            string += "*";
        }
        // newline after each row
        string += "\n";
        }
        // printing the string
        console.log(string);
    }

    drawFrame(drawFramen) {
        let drawFramestring = "";
        for(let drawFramei = 0; drawFramei < drawFramen; drawFramei++) { // external loop
        for(let drawFramej = 0; drawFramej < drawFramen; drawFramej++) { // internal loop
            if(drawFramei === 0 || drawFramei === drawFramen - 1) {
            drawFramestring += "*";
            }
            else {
            if(drawFramej === 0 || drawFramej === drawFramen - 1) {
                drawFramestring += "*";
            }
            else {
                drawFramestring += " ";
            }
            }
        }
        drawFramestring += "\n";
        }
        console.log(drawFramestring);
    }

    drawTriangle(drawTrianglen) {
        let drawTrianglestring = "";
        for (let drawTrianglei = 1; drawTrianglei <= drawTrianglen; drawTrianglei++) {
          for (let drawTrianglej = 0; drawTrianglej < drawTrianglei; drawTrianglej++) {
            drawTrianglestring += "*";
          }
          drawTrianglestring += "\n";
        }
        console.log(drawTrianglestring);
    }

    drawTriangle2(drawTriangle2n){
        let drawTriangle2string = "";
        for (let drawTriangle2i = 0; drawTriangle2i < drawTriangle2n; drawTriangle2i++) {
        // printing star
        for (let drawTriangle2k = 0; drawTriangle2k < drawTriangle2n - drawTriangle2i; drawTriangle2k++) {
            drawTriangle2string += "*";
        }
        drawTriangle2string += "\n";
        }
        console.log(drawTriangle2string);
    }
    
    drawPiramid() {
        let drawPiramidn = 5;
        let drawPiramidstring = "";
        // External loop
        for (let drawPiramidi = 1; drawPiramidi <= drawPiramidn; drawPiramidi++) {
        // printing spaces
        for (let drawPiramidj = 1; drawPiramidj <= drawPiramidn - drawPiramidi; drawPiramidj++) {
            drawPiramidstring += " ";
        }
        for (let drawPiramidk = 0; drawPiramidk < 2 * drawPiramidi - 1; drawPiramidk++) {
            drawPiramidstring += "*";
        }
        drawPiramidstring += "\n";
        }
        console.log(drawPiramidstring);
    }

    drawPiramid2(){
        let drawPiramid2n = 5;
        let drawPiramid2 = "";

        for (let drawPiramid2i = 0; drawPiramid2i < drawPiramid2n; drawPiramid2i++) {
        for (let drawPiramid2j = 0; drawPiramid2j < drawPiramid2i; drawPiramid2j++) {
            drawPiramid2 += " ";
        }
        for (let drawPiramid2k = 0; drawPiramid2k < 2 * (drawPiramid2n-drawPiramid2i) - 1; drawPiramid2k++) {
            drawPiramid2 += "*";
        }
        drawPiramid2 += "\n";
        }
        
        console.log(drawPiramid2);
    }
}

//module.exports = Draws;
