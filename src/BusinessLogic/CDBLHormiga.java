package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOHormiga;
import DataAccess.DTO.CDDTOHormiga;

public class CDBLHormiga {
    private CDDTOHormiga cdHormihas;
    private CDDAOHormiga cdSDAO = new CDDAOHormiga();

    public CDBLHormiga(){}

    public List<CDDTOHormiga> getAll() throws Exception{
        List<CDDTOHormiga> lst = cdSDAO.readAll();
        return lst;
    }
    public CDDTOHormiga getBy(int cdIdHormiga) throws Exception{
        cdHormihas = cdSDAO.readBy(cdIdHormiga);
        return cdHormihas;
    }
    public boolean add(CDDTOHormiga CDDTOHormiga) throws Exception{   
        return cdSDAO.create(CDDTOHormiga);
    }
    public boolean update(CDDTOHormiga CDDTOHormiga) throws Exception{
        return cdSDAO.update(CDDTOHormiga);
    }
    public boolean delete(int cdIdHormiga) throws Exception{
        return cdSDAO.delete(cdIdHormiga);
    }
    // public Integer getRowCount() throws Exception{
    //     return cdSDAO.getRowCount();
    // }
}