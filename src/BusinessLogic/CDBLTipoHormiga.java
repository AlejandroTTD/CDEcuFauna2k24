package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOTipoHormiga;
import DataAccess.DTO.CDDTOTipoHormiga;

public class CDBLTipoHormiga {
    private CDDTOTipoHormiga cdSexo;
    private CDDAOTipoHormiga cdSDAO = new CDDAOTipoHormiga();

    public CDBLTipoHormiga(){}

    public List<CDDTOTipoHormiga> getAll() throws Exception{
        List<CDDTOTipoHormiga> lst = cdSDAO.readAll();
        for (CDDTOTipoHormiga cdSDTO : lst) 
            cdSDTO.setCDNombre(cdSDTO.getCDNombre().toUpperCase());
        return lst;
    }
    public CDDTOTipoHormiga getBy(int cdIdReg) throws Exception{
        cdSexo = cdSDAO.readBy(cdIdReg);
        return cdSexo;
    }
    public boolean add(CDDTOTipoHormiga cdRegDTO) throws Exception{   
        return cdSDAO.create(cdRegDTO);
    }
    public boolean update(CDDTOTipoHormiga cdRegDTO) throws Exception{
        return cdSDAO.update(cdRegDTO);
    }
    public boolean delete(int cdIdReg) throws Exception{
        return cdSDAO.delete(cdIdReg);
    }
    public Integer getRowCount() throws Exception{
        return cdSDAO.getRowCount();
    }
}