class Operaciones {
    //operaciones aritmeticas
    aritmeticas(){
        const n1 = 5**3; 
        let n2 = ((-(1+1+1+1+1-5-10)+(4*3-n1))+8200*3/10)*3;
        if(n2 == -(-7071)){
            console.log("Operaciones aritmeticas bien. Valor = " + n2);
        }
        relacionales();
    }
    //operaciones relacionales
    relacionales(){
        const n3 = 5.66 < 5.67;
        if(n3 == true){
            console.log("Operacion relacional bien!")
        }
        if (15+8 == 22-10+5*3-4 && 13*0>-1){
            if (10.0 != 11.0-1.01 ){
                console.log("segunda operacion relacional bien!");
            }else {
                console.log("segunda operacion relacional mal :c!")
            }
        }
        logicas(true, false)
    }
    //operaciones logicas
    logicas(verdadero, falso){
        var bandera =  verdadero && (verdadero || falso && verdadero);
        do{
            n1++;
            if((86 >= 8) && ((6 == 7) || (6 != 7)) && !!bandera){
                console.log("Operacion logica esta correcta!!")
            }else{
                console.log("Error en operaciones logicas :c")
            }
        }while(n1 < 126);
    }  
}
/**
 * Clase de operaciones 
 * 2do. Semestre 2021
 */