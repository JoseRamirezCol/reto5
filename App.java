
import Vista.ReportesView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MARTHA SALDAÑA
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println("Consulta 1");
        ReportesView reporte = new ReportesView();
        String banco="Conavi";
        reporte.proyectosFinanciadosPorBanco(banco);

    }
}
