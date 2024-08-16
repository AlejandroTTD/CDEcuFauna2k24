package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOSexo;
import DataAccess.DTO.CDDTOSexo;

public class CDBLSexo {
    private CDDTOSexo cdSexo;
    private CDDAOSexo cdSDAO = new CDDAOSexo();

    public CDBLSexo(){}

    public List<CDDTOSexo> getAll() throws Exception{
        List<CDDTOSexo> lst = cdSDAO.readAll();
        for (CDDTOSexo sexoDTO : lst) 
            sexoDTO.setCDNombre(sexoDTO.getCDNombre().toUpperCase());
        return lst;
    }
    public CDDTOSexo getBy(int idSexo) throws Exception{
     cdSexo = cdSDAO.readBy(idSexo);
        return cdSexo;
    }
    public boolean add(CDDTOSexo sexoDTO) throws Exception{   
        return cdSDAO.create(sexoDTO);
    }
    public boolean update(CDDTOSexo sexoDTO) throws Exception{
        return cdSDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return cdSDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception{
        return cdSDAO.getRowCount();
    }
}