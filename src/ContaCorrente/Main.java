package main.java.ContaCorrente;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente(24587,683,"Maria Almeida", LocalDate.now(), 60.00 );
        ContaCorrente conta2 = new ContaCorrente(12354,683,"Jose Almeida", LocalDate.now(), 50.00 );
        try {
            conta2.cancelarConta("teste conta cancelada");
            conta1.transferirValor(10.0,conta2);
            System.out.println(conta1.consultarSaldoAtual() + " - " + conta2.consultarSaldoAtual());
//            conta1.depositarValor(500.0);
//            conta1.depositarValor(100.0);
//            conta1.depositarValor(200.0);
//            conta1.transferirValor(60.0,conta2);
//
//            System.out.println(conta1.consultarExtrato(LocalDate.of(2021,01,13), LocalDate.of(2023,11,13)).size());
//           conta1.consultarExtrato(LocalDate.of(2021, 12, 10), LocalDate.of(2022, 12,10)).forEach(o -> System.out.println(o.getTipo()+ " valor: " + o.getValor()));
        } catch (Exception e){
            e.printStackTrace();

        }
        //System.out.println("" + new Date());
        //System.out.println(conta1.consultarSaldoAtual());


    }
}
