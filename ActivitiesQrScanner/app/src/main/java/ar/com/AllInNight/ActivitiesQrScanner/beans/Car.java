package ar.com.AllInNight.ActivitiesQrScanner.beans;

import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private String model;
    private Integer year;
    private Integer drawableId;
    private String vin;
    private String patent;

    private String urlOfficialPage;
    private String urlManuals;
    private String urlTechnicalDetail;

    public Car(){
        super();
        urlOfficialPage = "https://www.fiat.com.ar/content/fiat-toro";
        urlManuals = "http://www.fiatmopar.com.ar/Manuales/pdf/60355967-Toro-ESP-al-31-08.pdf";
        urlTechnicalDetail = "https://www.fiat.com.ar/sites/default/files/pdf/ft_toro_0.pdf";
    }
    public String getUrlOfficialPage() {
        return urlOfficialPage;
    }

    public void setUrlOfficialPage(String urlOfficialPage) {
        this.urlOfficialPage = urlOfficialPage;
    }

    public String getUrlManuals() {
        return urlManuals;
    }

    public void setUrlManuals(String urlManuals) {
        this.urlManuals = urlManuals;
    }

    public String getUrlTechnicalDetail() {
        return urlTechnicalDetail;
    }

    public void setUrlTechnicalDetail(String urlTechnicalDetail) {
        this.urlTechnicalDetail = urlTechnicalDetail;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(Integer drawableId) {
        this.drawableId = drawableId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }
}
