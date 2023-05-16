package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bil {
    private String navn;
    private String mærke;
    private int kmTal;
    private Prisklasse prisklasse;
    private LocalDate serviceDato;
    private List<Service> serviceAftaler = new ArrayList<>();
    private List<Udlejning> udlejninger = new ArrayList<>();

    public Bil(String navn, String mærke, int kmTal){
        this.navn = navn;
        this.mærke = mærke;
        this.kmTal = kmTal;
    }

    public Bil(String navn, String mærke, int kmTal, Prisklasse prisklasse){
        this.navn = navn;
        this.mærke = mærke;
        this.kmTal = kmTal;
        this.prisklasse = prisklasse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public int getKmTal() {
        return kmTal;
    }

    public void setKmTal(int kmTal) {
        this.kmTal = kmTal;
    }

    public Prisklasse getPrisklasse() {
        return prisklasse;
    }

    public void setPrisklasse(Prisklasse prisklasse) {
        this.prisklasse = prisklasse;
    }

    public LocalDate getServiceDato() {
        return serviceDato;
    }

    public void setServiceDato(LocalDate serviceDato) {
        this.serviceDato = serviceDato;
    }

    public void addUdlejning(Udlejning udlejning){
        if (!udlejninger.contains(udlejning)){
            udlejninger.add(udlejning);
        }
    }

    public void removeUdlejning(Udlejning udlejning){
        if (udlejninger.contains(udlejning)){
            udlejninger.remove(udlejning);
        }
    }

    public ArrayList<Udlejning> getUdlejninger(){
        return new ArrayList<>(udlejninger);
    }

    public void addService(Service service){
        if (!serviceAftaler.contains(service)){
            serviceAftaler.add(service);
        }
    }

    public void removeService(Service service){
        if (serviceAftaler.contains(service)){
            serviceAftaler.remove(service);
        }
    }

    public List<Service> getServiceAftaler() {
        return new ArrayList<>(serviceAftaler);
    }
}
