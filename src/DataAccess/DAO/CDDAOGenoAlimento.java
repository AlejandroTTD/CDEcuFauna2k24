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
import DataAccess.DTO.CDDTOGenoAlimento;


public class CDDAOGenoAlimento extends CDDataHelper implements CDIDAO<CDDTOGenoAlimento> {

    @Override
    public boolean create(CDDTOGenoAlimento entity) throws Exception {
        String query = " INSERT INTO CDCatalogo (IdCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 4);   //
            pstmt.setString(2, entity.getCDNombre());
            pstmt.setString(3, entity.getCDDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
             throw e; // new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CDDTOGenoAlimento> readAll() throws Exception {
        List <CDDTOGenoAlimento> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IdCatalogo ) RowNum "
                     +" ,IdCatalogo         "
                     +" ,IdCatalogoTipo     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    CDCatalogo    "
                     +" WHERE   Estado ='A' "
                     +" AND   IdCatalogoTipo = 4 ";
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CDDTOGenoAlimento s = new CDDTOGenoAlimento(
                                         rs.getInt(1)     // RowNum
                                        ,rs.getInt(2)     // IdCatalogo
                                        ,rs.getInt(3)     // IdCatalogoTipo
                                        ,rs.getString(4)  // Nombre
                                        ,rs.getString(5)  // Descripcion
                                        ,rs.getString(6)  // Estado
                                        ,rs.getString(7)  // FechaCreacion
                                        ,rs.getString(8));// FechaModifica
                lst.add(s);
            }
        }
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean update(CDDTOGenoAlimento entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now     = LocalDateTime.now();
        String query = "UPDATE CDCatalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection        conn   = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCDNombre());
            pstmt.setString(2, entity.getCDDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getCDIdCatalogo());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CDCatalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CDDTOGenoAlimento readBy(Integer id) throws Exception {
        CDDTOGenoAlimento s = new CDDTOGenoAlimento();
        String query =
         " SELECT RowNum            "
        +"     ,IdCatalogo          "
        +"     ,IdCatalogoTipo      "
        +"     ,Nombre              "
        +"     ,Descripcion         "
        +"     ,Estado              "
        +"     ,FechaCreacion       "
        +"     ,FechaModifica       "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdCatalogo) AS RowNum "
        +"         ,IdCatalogo      "
        +"         ,IdCatalogoTipo  "
        +"         ,Nombre          "
        +"         ,Descripcion     "
        +"         ,Estado          "
        +"         ,FechaCreacion   "
        +"         ,FechaModifica   "
        +"     FROM CDCatalogo        "
        +"     WHERE Estado = 'A'   "
        +"     AND IdCatalogoTipo = 4 "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new CDDTOGenoAlimento(
                                 rs.getInt(1)     // RowNum
                                ,rs.getInt(2)     // IdCatalogo
                                ,rs.getInt(3)     // IdCatalogoTipo
                                ,rs.getString(4)  // Nombre
                                ,rs.getString(5)  // Descripcion
                                ,rs.getString(6)  // Estado
                                ,rs.getString(7)  // FechaCreacion
                                ,rs.getString(8));// FechaModifica
            }
        }
        catch (SQLException e) {
            throw e;
        }
        return s;
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    CDCatalogo         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCatalogoTipo = 4";
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        }
        catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}
