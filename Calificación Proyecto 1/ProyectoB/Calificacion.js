/**
 * Clase de operaciones 
 * 2do. Semestre 2021
 */
class Operaciones {
    /*operaciones aritmeticas*/
    n1 = 5**3; 
    op_aritmeticas(){
        var n2 = ((-(1+1+1+1+1-5-10)+(4*3-n1))+8200*3/10)*3;
        var n3 = (((3 * 3) + 4) - 80 + 40.00 * 2 + 358.50 - (29 / 14.50)) - (0.50) + (5750 * 2) - 11800 + 1.0
        if(n2 == -(-7071) && n3 == 70){
            console.log("Operacion ARITMETICA correcta.");
        }
        op_logicas(false, true)
    }
    /*
      operaciones logicas
    */
    logicas(falso, verdadero){
        let bAnDERA =  verdadero && (verdadero || falso && verdadero);
        do{
            n1++;
            if(!!!!!!!!!!!!!!!!!!!!!!bAnDERA){
                console.log("Operacion LOGICA correcta!!")
            }else{
                console.log("Error en operaciones logicas :c")
            }
        }while(!!(!(n1 == 126 && false==true) && !(true)))
    }

    Operaciones(){
        console.log("======= Inician las operaciones =======");
        //operaciones relacionales
        const menor = 5.66 < 5.67
        if(menor == true){
            console.log("Operacion relacional correcta (:")
        }
        op_aritmeticas()
    } 
}