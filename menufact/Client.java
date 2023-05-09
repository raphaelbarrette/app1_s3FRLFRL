package menufact;

/**
 * class Client pour le client de la facture
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * constructeur du client avec le idClient, le nom et le numeroCarteCredit
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
     * retourne le idClient du client
     * @return id du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * set le IdClient du client
     * @param idClient id du client a set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * retourne le nom du client
     * @return nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * set le nom du client
     * @param nom du client a set
     */
    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        }
    }

    /**
     * retourne le numeroCarteCredit du client
     * @return numero de la carte de credit du client
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * set le numeroCarteCredit du client
     * @param numeroCarteCredit du client a set
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        if (numeroCarteCredit != null) {
            this.numeroCarteCredit = numeroCarteCredit;
        }
    }

    /**
     * retourne String du client
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