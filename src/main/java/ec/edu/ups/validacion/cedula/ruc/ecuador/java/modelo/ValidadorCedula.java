/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.validacion.cedula.ruc.ecuador.java.modelo;

/**
 *
 * @author ESTUDIANTE
 */
public class ValidadorCedula {
    private static final int TAMANO_LONGITUD_CEDULA = 10;
    private static final int[] COEFICIENTES = {2, 1, 2, 1, 2, 1, 2, 1, 2};
    private static final int NUMERO_PROVINCIAS = 24;
    private static final int TERCER_DIGITO = 6;

    public boolean verificarCedula(String cedula) {
        int total = 0;

        if (cedula.matches("[0-9]*") && cedula.length() == TAMANO_LONGITUD_CEDULA) {
            int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));
            int digitoTres = Integer.parseInt(cedula.charAt(2) + "");

            if ((provincia > 0 && provincia <= NUMERO_PROVINCIAS) && digitoTres < TERCER_DIGITO) {
                int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");

                for (int i = 0; i < COEFICIENTES.length; i++) {
                    int valor = COEFICIENTES[i] * Integer.parseInt(cedula.charAt(i) + "");
                    total = valor >= 10 ? total + (valor - 9) : total + valor;
                }

                int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10) : total;

                return digitoVerificadorObtenido == digitoVerificadorRecibido;
            }
        }

        return false;
    }
}
