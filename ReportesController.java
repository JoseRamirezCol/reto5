/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ProyectoBancoDao;
import Modelo.ProyectoBancoVo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MARTHA SALDAÑA
 */
public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;



    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        
       
    }

    //Metodos para entregar informacion
    //listarProyectos
    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco)throws SQLException {
        return proyectoBancoDao.listar(banco);
    
    }
    //listarDeudas
   
    
}
