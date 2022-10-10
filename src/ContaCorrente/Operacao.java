package main.java.ContaCorrente;

import java.time.LocalDate;

public class Operacao {
   private Integer codigo;
   private String tipo;
   private Double valor;
   private LocalDate data;

    public Operacao() {

        data = LocalDate.now();
    }

    public Operacao(String tipo, Double valor) {
        data = LocalDate.now();
        this.tipo = tipo;
        this.valor = valor;
        codigo = (int)Math.random() * 100;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
