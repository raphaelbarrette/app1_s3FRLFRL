package menufact;

/**
 * class Client pour le client de la facture
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     *
     * @param idClient id du client
     * @param nom du client
     * @param numeroCarteCredit du client
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     *
     * @return id du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     *
     * @param idClient id du client a set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     *
     * @return nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom du client a set
     */
    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        }
    }

    /**
     *
     * @return numero de la carte de credit du client
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     *
     * @param numeroCarteCredit du client a set
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        if (numeroCarteCredit != null) {
            this.numeroCarteCredit = numeroCarteCredit;
        }
    }

    /**
     *
     * @return String a afficher
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */