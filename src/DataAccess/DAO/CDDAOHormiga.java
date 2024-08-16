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
import DataAccess.DTO.CDDTOHormiga;
import Framework.CDException;

public class CDDAOHormiga extends CDDataHelper implements CDIDAO<CDDTOHormiga> {

    @Override
    public boolean create(CDDTOHormiga entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO CDHORMIGA (IdClgTipoHormiga, IdClgIngestaNativa, IdClgGenoAlimento, IdClgSexo, IdUbicacion, FechaModifica) VALUES (?,?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getCDIdClgTipoHormiga());
            pstmt.setInt(2, entity.getCDIdClgIngestaNativa());
            pstmt.setInt(3, entity.getCDIdClgGenoAlimento());
            pstmt.setInt(4, entity.getCDIdClgSexo());
            pstmt.setInt(5, entity.getCDIdUbicacion());
            pstmt.setString(6, dtf.format(now).toString());;

            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new CDException(e.getMessage(), getClass().getName(), "create()");
        }
    }
    

    public List<CDDTOHormiga> readAll() throws Exception {
        List <CDDTOHormiga> lst = new ArrayList<>();
        String query =" SELECT IdHormiga             " 
                     +" ,IdClgTipoHormiga            " 
                     +" ,IdClgIngestaNativa          " 
                     +" ,IdClgGenoAlimento           " 
                     +" ,IdClgSexo                   " 
                     +" ,IdUbicacion                 " 
                     +" ,Estado                      " 
                     +" ,FechaCreacion               " 
                     +" ,FechaModifica               "
                     +" FROM    MJHORMIGA            "
                     +" WHERE   Estado ='A'          ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  cdStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  cdRs   = cdStmt.executeQuery(query);    // ejecutar la
                         while (cdRs.next()) {
                             CDDTOHormiga s = new CDDTOHormiga( cdRs.getInt(1)     // IdHormiga
                                                     ,cdRs.getInt(2)  // Nombre             
                                                     ,cdRs.getInt(3)  // Nombre             
                                                     ,cdRs.getInt(4)  // Nombre             
                                                     ,cdRs.getInt(5)  // Nombre             
                                                     ,cdRs.getInt(6)  // Nombre             
                                                     ,cdRs.getString(7)  // Estado         
                                                     ,cdRs.getString(8)  // FechaCrea      
                                                     ,cdRs.getString(9));// FechaModifica
                             lst.add(s);
                         }
                    } 
                    catch (SQLException e) {
                        throw new CDException(e.getMessage(), getClass().getName(), "readAll()");
                    }
                    return lst; 
                }
    

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE MJHORMIGA SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new CDException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CDDTOHormiga readBy(Integer id) throws Exception {
        CDDTOHormiga cdOs = new CDDTOHormiga();
        String query =" SELECT IdHormiga                " 
                     +" ,IdClgTipoHormiga               " 
                     +" ,Estado                         " 
                     +" ,FechaCrea                      " 
                     +" ,FechaModifica                  "
                     +" FROM    MJHORMIGA               "
                     +" WHERE   Estado ='A'  AND IdHormiga"+ id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  cdStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  cdRs   = cdStmt.executeQuery(query);    // ejecutar la
                         while (cdRs.next()) {
                            CDDTOHormiga s = new CDDTOHormiga( cdRs.getInt(1)     // IdHormiga
                            ,cdRs.getInt(2)  // Nombre             
                            ,cdRs.getInt(2)  // Nombre             
                            ,cdRs.getInt(2)  // Nombre             
                            ,cdRs.getInt(2)  // Nombre             
                            ,cdRs.getInt(2)  // Nombre             
                            ,cdRs.getString(3)  // Estado         
                            ,cdRs.getString(4)  // FechaCrea      
                            ,cdRs.getString(5));// FechaModifica
            } 
        }catch (SQLException e) {
                throw new CDException(e.getMessage(), getClass().getName(), "readBy()");
            }
            return cdOs; 
        }

    @Override
    public boolean update(CDDTOHormiga entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CDHORMIGA SET IdClgTipoHormiga = ?, IdClgIngestaNativa = ?, IdClgGenoAlimento = ?, IdClgSexo = ?, IdUbicacion = ?,    FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getCDIdClgTipoHormiga());
            pstmt.setInt(2, entity.getCDIdClgIngestaNativa());
            pstmt.setInt(3, entity.getCDIdClgGenoAlimento());
            pstmt.setInt(4, entity.getCDIdClgSexo());
            pstmt.setInt(4, entity.getCDIdUbicacion());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getCDIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw  new CDException(e.getMessage(), getClass().getName(), "update()");
        }
    }    

}