package DataAccess.DTO;
public class CDDTOHormiga {
    
    private Integer cdIdHormiga;
    private Integer cdIdClgTipoHormiga;
    private Integer cdIdClgIngestaNativa;
    private Integer cdIdClgGenoAlimento;
    private Integer cdIdClgSexo;
    private Integer cdIdUbicacion;
    private String  cdEstado;
    private String  cdFechaCreacion;
    private String  cdFechaModifica;

    public CDDTOHormiga(){}


    public CDDTOHormiga(Integer cdIdHormiga, Integer cdIdClgTipoHormiga, Integer cdIdClgIngestaNativa,
            Integer cdIdClgGenoAlimento, Integer cdIdClgSexo, Integer cdIdUbicacion, String cdEstado,
            String cdFechaCreacion, String cdFechaModifica) {
        this.cdIdHormiga            = cdIdHormiga;
        this.cdIdClgTipoHormiga     = cdIdClgTipoHormiga;
        this.cdIdClgIngestaNativa   = cdIdClgIngestaNativa;
        this.cdIdClgGenoAlimento    = cdIdClgGenoAlimento;
        this.cdIdClgSexo            = cdIdClgSexo;
        this.cdIdUbicacion          = cdIdUbicacion;
        this.cdEstado               = cdEstado;
        this.cdFechaCreacion        = cdFechaCreacion;
        this.cdFechaModifica        = cdFechaModifica;
    }



    public CDDTOHormiga(int idHormiga, String tipoHormiga, String ubicacion, String sexo, String genoAlimento,
            String ingestaNativa) {
        
    }


    public Integer getCDIdHormiga() {
        return cdIdHormiga;
    }



    public void setCDIdHormiga(Integer cdIdHormiga) {
        this.cdIdHormiga = cdIdHormiga;
    }



    public Integer getCDIdClgTipoHormiga() {
        return cdIdClgTipoHormiga;
    }



    public void setCDIdClgTipoHormiga(Integer cdIdClgTipoHormiga) {
        this.cdIdClgTipoHormiga = cdIdClgTipoHormiga;
    }



    public Integer getCDIdClgIngestaNativa() {
        return cdIdClgIngestaNativa;
    }



    public void setCDIdClgIngestaNativa(Integer cdIdClgIngestaNativa) {
        this.cdIdClgIngestaNativa = cdIdClgIngestaNativa;
    }



    public Integer getCDIdClgGenoAlimento() {
        return cdIdClgGenoAlimento;
    }



    public void setCDIdClgGenoAlimento(Integer cdIdClgGenoAlimento) {
        this.cdIdClgGenoAlimento = cdIdClgGenoAlimento;
    }



    public Integer getCDIdClgSexo() {
        return cdIdClgSexo;
    }



    public void setCDIdClgSexo(Integer cdIdClgSexo) {
        this.cdIdClgSexo = cdIdClgSexo;
    }



    public Integer getCDIdUbicacion() {
        return cdIdUbicacion;
    }



    public void setCDIdUbicacion(Integer cdIdUbicacion) {
        this.cdIdUbicacion = cdIdUbicacion;
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
                + "\n IdHormiga           " + getCDIdHormiga()
                + "\n TipoHormiga         " + getCDIdClgTipoHormiga()
                + "\n IdIngestaNativa     " + getCDIdClgIngestaNativa()
                + "\n IdGenoAlimento      " + getCDIdClgGenoAlimento()
                + "\n IdSexo              " + getCDIdClgSexo()
                + "\n IdUbicacion         " + getCDIdUbicacion()
                + "\n Estado              " + getCDEstado()
                + "\n fechaCreacion       " + getCDFechaCreacion()
                + "\n fechaModifica       " + getCDFechaModifica();

    }

    

}