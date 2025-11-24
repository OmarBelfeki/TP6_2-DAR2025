package rmiService;

import metier.Compte;

import java.rmi.RemoteException;
import java.util.HashMap;

public class BanqueImpl implements IBanque{

    private HashMap<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException{
        comptes = new HashMap<>();
    }


    @Override
    public String creerCompte(Compte c) throws RemoteException {
        comptes.put(c.getCode(), c);
        return "Compte cree avec succes: " + c.toString();
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        Compte c = comptes.get(code);
        if(c != null) return c.toString();
        else return "Compte introvable !";
    }
}
