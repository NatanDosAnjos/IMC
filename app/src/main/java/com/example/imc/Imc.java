package com.example.imc;

public class Imc {
    private double peso;
    private String nome;
    private double altura;
    private double imc = 0;

    //Métodos Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Méttodos Getters
    public double getPeso() {
        return peso;
    }

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public double getImc() {
        return imc;
    }

    private void calcularImc(double peso, double altura) {		        //Método para calcular IMC. Recebe dois parametros double e retorna um valor double
        if(peso != 0 || altura != 0) {
            this.imc = (peso / (Math.pow(altura, 2)));                            //Atribui resultado de peso dividido por altura ao quadrado a variável imc
        } else {
            imc = 0;
        }
    }

    public String diagnostico() {
        calcularImc(this.peso, this.altura);

        if(this.peso == 0|| this.altura == 0){
            return "Valores Inválidos";
        }

        if (imc < 16) {
            return "Baixo Peso, Muito Grave";
        }
        if ((imc > 15.99) && (imc < 17 )){
            return "Baixo Peso, Grave";
        }
        if ((imc > 16.99) && (imc < 18.50 )){
            return "Baixo Peso";
        }
        if ((imc > 18.49 ) && (imc < 25 )) {
            return "Peso Normal";
        }
        if ((imc > 24.99 ) && (imc < 30 )) {
            return "Sobrepeso";
        }
        if ((imc > 29.99 ) && (imc < 35 )) {
            return "Obesidade Grau I";
        }
        if ((imc > 34.99 ) && (imc < 40 )) {
            return "Obesidade Grau II";
        }
        if (imc > 39.99) {
            return "Obesidade Grau III (Obesidade Morbida)";
        }

        return "Inválido";
    }
}
