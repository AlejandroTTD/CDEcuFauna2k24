package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOIngestaNativa;
import DataAccess.DTO.CDDTOIngestaNativa;

public class CDBLIngestaNativa {
    private CDDTOIngestaNativa cdSexo;
    private CDDAOIngestaNativa cdSDAO = new CDDAOIngestaNativa();

    public CDBLIngestaNativa(){}

    public List<CDDTOIngestaNativa> getAll() throws Exception{
        List<CDDTOIngestaNativa> lst = cdSDAO.readAll();
        for (CDDTOIngestaNativa cdSDTO : lst) 
            cdSDTO.setCDNombre(cdSDTO.getCDNombre().toUpperCase());
        return lst;
    }
    public CDDTOIngestaNativa getBy(int cdIdReg) throws Exception{
        cdSexo = cdSDAO.readBy(cdIdReg);
        return cdSexo;
    }
    public boolean add(CDDTOIngestaNativa cdRegDTO) throws Exception{   
        return cdSDAO.create(cdRegDTO);
    }
    public boolean update(CDDTOIngestaNativa cdRegDTO) throws Exception{
        return cdSDAO.update(cdRegDTO);
    }
    public boolean delete(int cdIdReg) throws Exception{
        return cdSDAO.delete(cdIdReg);
    }
    public Integer getRowCount() throws Exception{
        return cdSDAO.getRowCount();
    }
}