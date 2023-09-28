import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eleccion, i;
        double num1, num2, suma, resta, multiplicacion, division;
        i = 1; //Inicializo la condicion de salida del bucle
        while (i == 1) {
            System.out.println("Opreraciones a realizar: ");
            System.out.println("1_Suma ");
            System.out.println("2_Resta");
            System.out.println(("3_Multiplicacion"));
            System.out.println("4_Division ");
            System.out.println("Ingrese el numero de la operacion a realizar: ");
            eleccion = sc.nextInt();

            if (eleccion == 1){ //SUMA
                System.out.println("Ingrese el primer numero: ");
                num1 = sc.nextDouble(); //El usuario ingresa el primer numero
                System.out.println("Ingrese el segundo numero: ");
                num2 = sc.nextInt(); //El usuario ingresa el segundo numero
                suma = num1 + num2; //Realizo la operacion

                System.out.println("El resultado de la suma es: "+suma );
                System.out.println("Desea realiazar otra operacion? ");
                System.out.println("Ingrese 1 para realizar otra operacion");
                System.out.println("Para salir ingrese cualquier otro numero");

                i = sc.nextInt();

            }else if (eleccion == 2){ //RESTA
                System.out.println("Ingrese el primer numero: ");
                num1 = sc.nextDouble(); //El usuario ingresa el primer numero
                System.out.println("Ingrese el segundo numero: ");
                num2 = sc.nextInt(); //El usuario ingresa el segundo numero
                resta = num1 - num2; //Realizo la operacion

                System.out.println("El resultado de la resta es: "+resta);
                System.out.println("Desea realiazr otra operacion? ");
                System.out.println("Ingrese 1 para realizar otra operacion");
                System.out.println("Para salir ingrese cualquier otro numero");

                i = sc.nextInt();

            }else if (eleccion == 3){ //MULTIPLICACION
                System.out.println("Ingrese el primer numero: ");
                num1 = sc.nextDouble(); //El usuario ingresa el primer numero
                System.out.println("Ingrese el segundo numero: ");
                num2 = sc.nextInt(); //El usuario ingresa el segundo numero
                multiplicacion = num1 * num2; //Realizo la operacion

                System.out.println("El resultado de la multiplicacion es: "+ multiplicacion);
                System.out.println("Desea realiazr otra operacion? ");
                System.out.println("Ingrese 1 para realizar otra operacion");
                System.out.println("Para salir ingrese cualquier otro numero");

                i = sc.nextInt();


            }else if(eleccion == 4){ //DIVISON
                System.out.println("Ingrese el primer numero: ");
                num1 = sc.nextDouble(); //El usuario ingresa el primer numero
                System.out.println("Ingrese el segundo numero: ");
                num2 = sc.nextInt(); //El usuario ingresa el segundo numero
                if (num2 == 0){
                    System.out.println("No se puede realiazr una division por 0"); //va a volver a pedir que realice una operacion
                }else{
                    division = num1 / num2; //Realizo la operacion

                    System.out.println("El resultado de la division es: "+ division);
                    System.out.println("Desea realiazr otra operacion? ");
                    System.out.println("Ingrese 1 para realizar otra operacion");
                    System.out.println("Para salir ingrese cualquier otro numero");

                    i = sc.nextInt();
                }

            }else{
                System.out.println("Numero no valido, intente nuevamete");
            }

        }
        System.out.println("ADIOS");

        }
    }
