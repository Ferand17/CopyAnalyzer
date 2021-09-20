class Math {
    
    showTables() {
        for (var i = 1; i <= 9; i++) {
            let value = "";
            for (var j = 1; j <= i; j++) {
                value = value + j + "*" + i + "=" + i * j + "   ";
            }
            console.log(value);
        }
    }


    /**
     * Factorial
     * @param {*} numero 
     */
    showFactorial(numero) {
        if (numero < 0) numero = numero * -1;
        if (numero <= 0) {
            console.log(1);
        }
        let factorial = 1;
        while (numero > 1) {
            factorial = factorial * numero;
            numero--;
        }
        console.log(factorial);
    }
    

    showFib(n) {
        let siguiente = 1;
        let actual = 0;
        let temporal = 0;
        let value_showFib = ""
		for (let x = 1; x <= n; x++) {
			value_showFib = value_showFib + actual + ", ";
			temporal = actual;
			actual = siguiente;
			siguiente = siguiente + temporal;
		}
		console.log(value_showFib);
    }
}

//module.exports = Math;
