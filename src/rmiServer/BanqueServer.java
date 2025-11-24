package rmiServer;

import rmiService.BanqueImpl;
import rmiService.IBanque;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(2002);

            IBanque banque = new BanqueImpl();

            Naming.rebind("rmi://localhost:2002/BANQUE", banque);

            System.out.println("Server RMI Banque demarre...");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
