import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Character [][] matriz = new Character[6][6]; //Matriz de ADN

        int i, j;


        //MENU

        Character opcion = '0';


        while (opcion != '1') {
            System.out.println("Hola Usuario!!");
            System.out.println("Vamos a llenar tu secuencia de ADN, para ver si sos mutante:  ");


            //BUCLE ANIDADO PARA LLENAR LA SECUENCIA DE ADN

            for (i = 0; i < 6; i++) {
                System.out.println("Vamos a llenar la secuencia de ADN");
                for (j = 0; j < 6; j++) {

                    System.out.println("Ingrese la letra de la base nitrogenada en la posicion fila: " + i + " columna: " + j);

                    matriz[i][j] = sc.next().charAt(0); //Ingreso la base nitrogenada en la matriz

                }
            }
            //Verifico que la matriz este bien cargada

            boolean coincidencia = true; //Supongo que todos los elementos coinciden
            for (i = 0; i < 6; i++) {
                for (j = 0; j < 6; j++) {
                    if (matriz[i][j] != 'A' && matriz[i][j] != 'G' && matriz[i][j] != 'T' && matriz[i][j] != 'C' && matriz[i][j] != 'a' && matriz[i][j] != 'g' && matriz[i][j] != 't' && matriz[i][j] != 'c') {
                        System.out.println("Se encontro con un elemento en la matriz que no es valido, debera llenarla de vuelta\n");
                        coincidencia = false;
                        break;
                    }
                }
                if (!coincidencia) {
                    break; //Salgo del bucle si coincidencia es falso
                }
            }
            if (!coincidencia) {
                continue;
            }



            System.out.println("");//Salto de linea


            if(is_mutant(matriz)){ //Llamo a la funcion is_mutant

                for (i = 0; i < 6; i++) {   //Muestro la matriz
                    for (j = 0; j < 6; j++) {
                        System.out.printf(matriz[i][j] + " ");
                    }
                    System.out.println(" ");
                }
                System.out.println("\nMutante");
            }else{
                for (i = 0; i < 6; i++) {   //Muestro la matriz
                    for (j = 0; j < 6; j++) {
                        System.out.printf(matriz[i][j] + " ");
                    }
                    System.out.println(" ");
                }
                System.out.println("No-Mutante");
            }

            System.out.println("Desea salir?");
            System.out.println("Ingrese 1 para salir");
            System.out.println("Ingrese cualquier otra cosa para volver a empezar");
            opcion = sc.next().charAt(0);


        }


        System.out.println("\nHASTA LA PROXIMA!!");


    }

    //Funcion que devuelve un valor booleano si encuentra coincidencias en 4 letras
    public static boolean is_mutant(Character matrix[][]){
        int sum;
        sum = comprobacionHorizontal(matrix) + comprobacionVertical(matrix) + comprobacionDiagonal(matrix) + comprobacionDiagonalInvertida(matrix);
        if (sum >= 2 ){
            return true;
        }else {
            return false;
        }
    }

    public static int comprobacionHorizontal(Character [][] matrix){ //Metodo para saber si una fila tiene 4 letras iguales consecutivas
        int i, z, counter = 0;

        for (i = 0; i < matrix.length ; i++){
            for(z = 0; z < matrix.length - 3; z++){
                if ((matrix[i][z] == matrix[i][z+1]) && (matrix[i][z+1] == matrix[i][z+2]) && (matrix[i][z+2] == matrix[i][z+3])) {
                    counter = counter + 1;
                }
            }
        }
        return counter;
    }

    public static int comprobacionVertical(Character [][] matrix){  //Funcion que transpone la matriz
        int filas, columnas, i, j;

        filas = matrix.length; //Cantidad de filas
        columnas = matrix[0].length; //Cantidad de columnas
        Character [][] matrixT = new Character[filas][columnas];

        for (i = 0; i < filas; i++){
            for(j = 0; j < columnas; j++){
                matrixT[j][i] = matrix[i][j];
            }
        }

        return comprobacionHorizontal(matrixT); //Llama a la funcion comprobacion horizontal con la matriz transpuesta, la cual va a verificar las columnas como si fueran filas
    }

    public static int comprobacionDiagonal(Character [][] matrix){ //Metodo para verificar las diagonales de izquierda a derecha
        int filas, columnas, i, j;
        filas = matrix.length; //Cantidad de filas
        columnas = matrix[0].length; //Cantidad de columnas
        int cont = 0;


        //Bucle para saber las diagonales superiores a la principal
        for (i = 0; i < filas; i++ ){
            ArrayList<Character> diagonal1 = new ArrayList<Character>();
            for(j = 0; j < filas - 1; j++){
                diagonal1.add(matrix[j][j+1]);
            }
            if(diagonales(diagonal1)){
                cont = cont + 1;
            }
        }

        //Bucle para saber las diagonales inferiores a la principal
        for(i = 1; i < columnas; i++){
            ArrayList<Character> diagonal2 = new ArrayList<Character>();
            for(j = 0; j < columnas - i; j++){
                diagonal2.add(matrix[i+j][j]);
            }
            if(diagonales(diagonal2)){
                cont = cont + 1;
            }
        }
    return cont;
    }

    public static boolean diagonales(ArrayList<Character> diagonal) { //Verifica que en la diagonal hayan 4 letras seguidas
        ;

        if (diagonal.size() < 4) {
            return false; // No hay suficientes elementos para tener 4 letras consecutivas.
        }

        for (int i = 0; i <= diagonal.size() - 4; i++) {
            if (diagonal.get(i) == diagonal.get(i + 1) && diagonal.get(i + 1) == diagonal.get(i + 2) && diagonal.get(i + 2) == diagonal.get(i + 3)) {
                return true;
            }
        }

        return false; // No se encontraron 4 letras consecutivas en la diagonal.
    }

    public static int comprobacionDiagonalInvertida(Character [][] matrix){ //Metodo para verificar las diagonales de derecha a izquierda
        int columnas, filas, i, j, cont;
        filas = matrix.length; //Cantidad de elementos por filas
        columnas = matrix[0].length; //Cantidad de elementos por columna
        cont = 0;

        //Bucle para saber la cantidad de diagonales inferiores a la secundaria

        for(i = 0; i < filas - 1; i++){
            ArrayList<Character> diagonal = new ArrayList<Character>();
            for (j = 0; j < columnas - i - 1; j++){
                diagonal.add(matrix[filas - 1 - j][i + 1 + j]);
            }
            if (diagonales(diagonal)){
                cont = cont + 1;
            }
        }

        //Bucle para saber diagonales superiores a la secundaria

        for(i = 0; i < filas - 1; i++){
            ArrayList<Character> diagonal = new ArrayList<Character>();
            for (j = 0; j < i + 1; j++){
                diagonal.add(matrix[j][i - j]);
            }
            if (diagonales(diagonal)){
                cont = cont + 1;
            }
        }

        //Bucle para saber la diagonal secundaria

        ArrayList<Character> diagonalSecundaria = new ArrayList<Character>();
        for (i = 0; i < Math.min(filas, columnas); i++){
            diagonalSecundaria.add(matrix[i][i]);
        }
        if (diagonales(diagonalSecundaria)){
            cont = cont + 1;
        }

        return cont;
    }


}


//CASOS DE PRUEBA:

//NO MUTANTE:

//matriz = ['AGTCCG','TCAGTA','CGTATC','ATCCAG','GCTAAT','ATGCCC']

//MUTANTE:

//matriz = ['AGTCCG','TCAGTA','CGCATC','ATCCAG','AAAACT','ATGCCC']

