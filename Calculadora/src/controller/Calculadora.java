package controller;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JLabel;

import view.LoginForm;
import view.LoginForm;

public class Calculadora {

	private double resultado = 0;
    private double numero;
    private static final int SUMA = 1;
    private static final int RESTA = 2;
    private static final int MULTIPLICACION = 3;
    private static final int DIVISION = 4;
    private static final int NINGUNO = 0;
    private int operador = NINGUNO;
    private boolean hayPunto = false;
    private boolean nuevoNumero = true;
    private NumberFormat nf = NumberFormat.getInstance();
    private JLabel pantallaResultado;
    
    public Calculadora(JLabel pantalla) {
    	this.pantallaResultado = pantalla;
    }
	
	private void operar(int operacion) {
		 if (!nuevoNumero){
	            String resultadoPantalla = pantallaResultado.getText();
	            if (!resultadoPantalla.isEmpty()){
	                Number n = null;
	                try {
	                    n = (Number) nf.parse(resultadoPantalla);
	                    numero = n.doubleValue();
	                } catch (ParseException ex) {
	                    
	                }
	                switch (operador) {
	                    case SUMA:
	                        resultado += numero;
	                        break;
	                    case RESTA:
	                        resultado -= numero;
	                        break;
	                    case MULTIPLICACION:
	                        resultado *= numero;
	                        break;
	                    case DIVISION:
	                        resultado /= numero;
	                        break;
	                    default:
	                        resultado = numero;
	                }
	                operador = operacion;
	               
	                pantallaResultado.setText(nf.format(resultado));
	                nuevoNumero = true;
	                hayPunto = false;
	            }
	        }			
	}
	
	
	public void accion(String texto) {
        texto=texto.toUpperCase();
        if(texto.equals(".")) {
        	texto = ",";
        }
		switch (texto) {
		    
			case "+":
                operar(SUMA);
                break;
            case "-":
                operar(RESTA);
                break;
            case "*":
                operar(MULTIPLICACION);
                break;
            case "/":
                operar(DIVISION);
                break;
            case ",":
                if (!nuevoNumero){
                    if (!hayPunto){
                        String rdo = pantallaResultado.getText();
                        pantallaResultado.setText(rdo+",");
                    }
                } else {
                    pantallaResultado.setText("0,");
                    nuevoNumero = false;
                }
                hayPunto = true;
                break;
            case "C":
                pantallaResultado.setText("0");
                nuevoNumero = true;
                hayPunto = false;
                break;
             
            case "=":
                if (operador != NINGUNO){
                    String rdo = pantallaResultado.getText();
                    if (!rdo.isEmpty()){
                        Number n = null;
                        try {
                            n = (Number) nf.parse(rdo);
                            numero = n.doubleValue();
                        } catch (ParseException ex) {
                            numero = 0;
                        }
                        switch (operador) {
                            case SUMA:
                                resultado += numero;
                                break;
                            case RESTA:
                                resultado -= numero;
                                break;
                            case MULTIPLICACION:
                                resultado *= numero;
                                break;
                            case DIVISION:
                                resultado /= numero;
                                break;
                            default:
                                resultado = numero;
                                break;
                        }
                        operador = NINGUNO;
                        pantallaResultado.setText(nf.format(resultado));
                    }
                }
                break;
            default:
                String rdo = pantallaResultado.getText();
                if (nuevoNumero){
                    pantallaResultado.setText(texto);
                } else {
                    pantallaResultado.setText(rdo + texto);
                }
                nuevoNumero = false;
                break;
        }
    }

	
	
}
