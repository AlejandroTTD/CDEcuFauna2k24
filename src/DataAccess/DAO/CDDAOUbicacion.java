package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.CDDataHelper;
import DataAccess.DTO.CDDTOUbicacion;


public class CDDAOUbicacion extends CDDataHelper implements CDIDAO<CDDTOUbicacion> {

    @Override
    public boolean create(CDDTOUbicacion entity) throws Exception {
        String query = " INSERT INTO CDUBICACION (Provincia) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCDProvincia());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }
    

    public List<CDDTOUbicacion> readAll() throws Exception {
        List <CDDTOUbicacion> lst = new ArrayList<>();
        String query =" SELECT IdUbicacion       " 
                     +" ,Pais                    " 
                     +" ,Region                  " 
                     +" ,Provincia               " 
                     +" ,Estado                  " 
                     +" ,FechaCreacion           " 
                     +" ,FechaModifica           "
                     +" FROM    CDUBICACION      "
                     +" WHERE   Estado ='A'      ";

        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  cdStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  cdRs   = cdStmt.executeQuery(query);    // ejecutar la
                         while (cdRs.next()) {
                             CDDTOUbicacion s = new CDDTOUbicacion( cdRs.getInt(1)     // IdSexo
                                                     ,cdRs.getString(2)  // Nombre             
                                                     ,cdRs.getString(3)  // Estado         
                                                     ,cdRs.getString(4)  // FechaCrea      
                                                     ,cdRs.getString(5)// FechaModifica
                                                     ,cdRs.getString(6)// FechaModifica
                                                     ,cdRs.getString(7));// FechaModifica
                             lst.add(s);
                         }
                    } 
                    catch (SQLException e) {
                        throw e; 
                    }
                    return lst; 
                }
    

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CDUBICACION SET Estado = ? WHERE IdUbicacion = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public CDDTOUbicacion readBy(Integer id) throws Exception {
        CDDTOUbicacion cdOs = new CDDTOUbicacion();
        String query =" SELECT IdUbicacion                   "   
                     +" ,Pais                                " 
                     +" ,Region                              " 
                     +" ,Provincia                           " 
                     +" ,Estado                              " 
                     +" ,FechaCreacion                       " 
                     +" ,FechaModifica                       "
                     +" FROM    CDUBICACION                  "
                     +" WHERE   Estado ='A'  AND ID UBICACION"+ id.toString();
        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  cdStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  cdRs   = cdStmt.executeQuery(query);    // ejecutar la
                         while (cdRs.next()) {
                             CDDTOUbicacion s = new CDDTOUbicacion( cdRs.getInt(1)     
                                                     ,cdRs.getString(2)  // Nombre             
                                                     ,cdRs.getString(3)  // Estado         
                                                     ,cdRs.getString(4)  // FechaCrea      
                                                     ,cdRs.getString(5)// FechaModifica
                                                     ,cdRs.getString(6)// FechaModifica
                                                     ,cdRs.getString(7));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return cdOs;
    }

    @Override
    public boolean update(CDDTOUbicacion entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now     = LocalDateTime.now();
        String query          = "UPDATE CDUBICACION SET Pais = ?, Region = ?, provincia = ?,   FechaModifica = ? WHERE IdUbicacion = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCDPais());
            pstmt.setString(2, entity.getCDRegion());
            pstmt.setString(3, entity.getCDProvincia());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getCDIdUbicacion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }
}
