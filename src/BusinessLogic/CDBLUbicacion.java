package BusinessLogic;

import java.util.List;

import DataAccess.DAO.CDDAOUbicacion;
import DataAccess.DTO.CDDTOUbicacion;

public class CDBLUbicacion {
    private CDDTOUbicacion cdSexo;
    private CDDAOUbicacion cdSDAO = new CDDAOUbicacion();

    public CDBLUbicacion(){}

    public List<CDDTOUbicacion> getAll() throws Exception{
        List<CDDTOUbicacion> lst = cdSDAO.readAll();
        for (CDDTOUbicacion cdSDTO : lst) 
            cdSDTO.setCDProvincia(cdSDTO.getCDProvincia().toUpperCase());
        return lst;
    }
    public CDDTOUbicacion getBy(int cdIdReg) throws Exception{
        cdSexo = cdSDAO.readBy(cdIdReg);
        return cdSexo;
    }
    public boolean add(CDDTOUbicacion cdRegDTO) throws Exception{   
        return cdSDAO.create(cdRegDTO);
    }
    public boolean update(CDDTOUbicacion cdRegDTO) throws Exception{
        return cdSDAO.update(cdRegDTO);
    }
    public boolean delete(int cdIdReg) throws Exception{
        return cdSDAO.delete(cdIdReg);
    }

}