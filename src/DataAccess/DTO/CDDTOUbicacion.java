package DataAccess.DTO;

public class CDDTOUbicacion {

    private Integer CDIdUbicacion;
    private String CDPais;
    private String CDRegion;
    private String CDProvincia;
    private String CDEstado;
    private String CDFechaCrea;
    private String CDFechaModifica;

    public CDDTOUbicacion() {
    }

    public CDDTOUbicacion(String cdPais) {
        this.CDPais = cdPais;
    }

    public CDDTOUbicacion(int cdIdUbicacion, String cdPais, String cdRegion, String cdProvincia, String cdEstado,
            String cdFechaCrea, String cdFechaModifica) {
        this.CDIdUbicacion = cdIdUbicacion;
        this.CDPais = cdPais;
        this.CDRegion = cdRegion;
        this.CDProvincia = cdProvincia;
        this.CDEstado = cdEstado;
        this.CDFechaCrea = cdFechaCrea;
        this.CDFechaModifica = cdFechaModifica;

    }

    public Integer getCDIdUbicacion() {
        return CDIdUbicacion;
    }

    public void setCDIdUbicacion(Integer cdIdUbicacion) {
        CDIdUbicacion = cdIdUbicacion;
    }

    public String getCDPais() {
        return CDPais;
    }

    public void setCDPais(String cdPais) {
        CDPais = cdPais;
    }

    public String getCDRegion() {
        return CDRegion;
    }

    public void setCDRegion(String cdRegion) {
        CDRegion = cdRegion;
    }

    public String getCDProvincia() {
        return CDProvincia;
    }

    public void setCDProvincia(String cdProvincia) {
        CDProvincia = cdProvincia;
    }

    public String getCDEstado() {
        return CDEstado;
    }

    public void setCDEstado(String cdEstado) {
        CDEstado = cdEstado;
    }

    public String getCDFechaCrea() {
        return CDFechaCrea;
    }

    public void setCDFechaCrea(String cdFechaCrea) {
        CDFechaCrea = cdFechaCrea;
    }

    public String getCDFechaModifica() {
        return CDFechaModifica;
    }

    public void setCDFechaModifica(String cdFechaModifica) {
        CDFechaModifica = cdFechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n idUbicacion       " + getCDIdUbicacion()
                + "\n Pais              " + getCDPais()
                + "\n Region            " + getCDRegion()
                + "\n Provincia         " + getCDProvincia()
                + "\n estado            " + getCDEstado()
                + "\n fechaCreacion     " + getCDFechaCrea()
                + "\n fechaModifica     " + getCDFechaModifica();
    }

}
