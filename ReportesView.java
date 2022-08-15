/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ReportesController;
import Modelo.ProyectoBancoVo;
import java.util.List;

/**
 *
 * @author MARTHA SALDAÑA
 */
public class ReportesView {
    private static ReportesController controlador;
    public ReportesView() {
        controlador= new ReportesController();    
    }
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
        respuesta += caracter;
        }
        return respuesta;
        }
        public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
        + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
        System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
        "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
        System.out.println(repitaCaracter('-', 105));
        try{
            List<ProyectoBancoVo> proyecto=controlador.listarProyectosPorBanco(banco);
            for(ProyectoBancoVo proyec:proyecto){
                System.out.println(proyec);
            }
        }catch (Exception ex){
            System.err.printf("Error: "+ex);
        }
        }
    }   

}