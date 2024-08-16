package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOGenoAlimento;
import DataAccess.DTO.CDDTOGenoAlimento;

public class CDBLGenoAlimento {
    private CDDTOGenoAlimento cdSexo;
    private CDDAOGenoAlimento cdSDAO = new CDDAOGenoAlimento();

    public CDBLGenoAlimento(){}

    public List<CDDTOGenoAlimento> getAll() throws Exception{
        List<CDDTOGenoAlimento> lst = cdSDAO.readAll();
        for (CDDTOGenoAlimento cdSDTO : lst) 
            cdSDTO.setCDNombre(cdSDTO.getCDNombre().toUpperCase());
        return lst;
    }
    public CDDTOGenoAlimento getBy(int cdIdReg) throws Exception{
        cdSexo = cdSDAO.readBy(cdIdReg);
        return cdSexo;
    }
    public boolean add(CDDTOGenoAlimento cdRegDTO) throws Exception{   
        return cdSDAO.create(cdRegDTO);
    }
    public boolean update(CDDTOGenoAlimento cdRegDTO) throws Exception{
        return cdSDAO.update(cdRegDTO);
    }
    public boolean delete(int cdIdReg) throws Exception{
        return cdSDAO.delete(cdIdReg);
    }
    public Integer getRowCount() throws Exception{
        return cdSDAO.getRowCount();
    }
}