package DataAccess.DTO;

public class CDDTOGenoAlimento {
    private Integer cdRowNum;
    private Integer cdIdCatalogo;
    private Integer cdIdCatalogoTipo;
    private String cdNombre;
    private String cdDescripcion;
    private String cdEstado;
    private String cdFechaCreacion;
    private String cdFechaModifica;

    public CDDTOGenoAlimento() {
    }

    public CDDTOGenoAlimento(Integer cdRowNum, Integer cdIdCatalogo, Integer cdIdCatalogoTipo, String cdNombre,
            String cdDescripcion, String cdEstado, String cdFechaCreacion, String cdFechaModifica) {
        this.cdRowNum = cdRowNum;
        this.cdIdCatalogo = cdIdCatalogo;
        this.cdIdCatalogoTipo = cdIdCatalogoTipo;
        this.cdNombre = cdNombre;
        this.cdDescripcion = cdDescripcion;
        this.cdEstado = cdEstado;
        this.cdFechaCreacion = cdFechaCreacion;
        this.cdFechaModifica = cdFechaModifica;
    }

    public Integer getCDRowNum() {
        return cdRowNum;
    }

    public void setCDRowNum(Integer cdRowNum) {
        this.cdRowNum = cdRowNum;
    }

    public Integer getCDIdCatalogo() {
        return cdIdCatalogo;
    }

    public void setCDIdCatalogo(Integer cdIdCatalogo) {
        this.cdIdCatalogo = cdIdCatalogo;
    }

    public Integer getCDIdCatalogoTipo() {
        return cdIdCatalogoTipo;
    }

    public void setCDIdCatalogoTipo(Integer cdIdCatalogoTipo) {
        this.cdIdCatalogoTipo = cdIdCatalogoTipo;
    }

    public String getCDNombre() {
        return cdNombre;
    }

    public void setCDNombre(String cdNombre) {
        this.cdNombre = cdNombre;
    }

    public String getCDDescripcion() {
        return cdDescripcion;
    }

    public void setCDDescripcion(String cdDescripcion) {
        this.cdDescripcion = cdDescripcion;
    }

    public String getCDEstado() {
        return cdEstado;
    }

    public void setCDEstado(String cdEstado) {
        this.cdEstado = cdEstado;
    }

    public String getCDFechaCreacion() {
        return cdFechaCreacion;
    }

    public void setCDFechaCreacion(String cdFechaCreacion) {
        this.cdFechaCreacion = cdFechaCreacion;
    }

    public String getCDFechaModifica() {
        return cdFechaModifica;
    }

    public void setCDFechaModifica(String cdFechaModifica) {
        this.cdFechaModifica = cdFechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n RowNum        :       " + getCDRowNum()
                + "\n IdCatalogo:       " + getCDIdCatalogo()
                + "\n IdCatalogotipo:  " + getCDIdCatalogoTipo()
                + "\n Nombre           :  " + getCDNombre()
                + "\n Descripcion     :  " + getCDDescripcion()
                + "\n estado           :  " + getCDEstado()
                + "\n fechaCreacion    :  " + getCDFechaCreacion()
                + "\n fechaModifica    :  " + getCDFechaModifica();

    }

}