/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARTHA SALDAÑA
 */
public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar(String banco)throws SQLException{
        ArrayList<ProyectoBancoVo> a=new ArrayList<>();
        Connection conn=JDBCUtilities.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String consulta= " SELECT ID_Proyecto as ID,Constructora ,Ciudad ,Proyecto.Clasificacion,Estrato,"
                        +" Nombre || ''  || Primer_Apellido || '' || Segundo_Apellido As LIDER"
                        +" FROM Proyecto"
                        +" JOIN Tipo ON Proyecto.ID_Tipo = Tipo.ID_Tipo" 
                        +" JOIN Lider ON Proyecto.ID_Lider = lider.ID_Lider" 
                        +" WHERE Banco_Vinculado = ?"
                        +" ORDER BY Fecha_Inicio DESC, Ciudad, Constructora";
    try {
        pstmt = conn.prepareStatement(consulta);
        pstmt.setString(1, banco);
        rs=pstmt.executeQuery();
        while (rs.next()){
            ProyectoBancoVo objeto=new ProyectoBancoVo();
            objeto.setId(rs.getInt("id"));
            objeto.setCiudad(rs.getString("ciudad"));
            objeto.setConstructora(rs.getString("constructora"));
            objeto.setClasificacion(rs.getString("clasificacion"));
            objeto.setEstrato(rs.getInt("estrato"));
            objeto.setLider(rs.getString("lider"));
            a.add(objeto);
            }
            
        }finally{
            if (rs != null){
                    rs.close();
                }
            if (pstmt != null) {
                pstmt.close();
                }
            if (conn != null){
                conn.close();
                }
    }

    return a;
    }
    
}
