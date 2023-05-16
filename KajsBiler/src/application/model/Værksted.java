package application.model;

import java.util.ArrayList;

public class Værksted   {

    //Link Attributes
    private final ArrayList<Service> services = new ArrayList<>();

    //Instance Variables
    private String adresse;
    private int tlfNr;
    private String email;

    public Værksted(String adresse, int tlfNr, String email){
        this.adresse = adresse;
        this.tlfNr = tlfNr;
        this.email = email;
    }

    public void addService(Service service){
        if (!services.contains(service)){
            services.add(service);
        }
    }

    public void removeService(Service service){
        if (services.contains(service)){
            services.remove(service);
        }
    }

    public ArrayList<Service> getServices(){return services;}
}
