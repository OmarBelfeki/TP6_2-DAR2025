package rmiServer;

import rmiService.BanqueImpl;
import rmiService.IBanque;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

public class BanqueServer {
    public static void main(String[] args) {
        try{
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL, "rmi://localhost:2002");

            InitialContext ctx = new InitialContext(env);

            IBanque banque = new BanqueImpl();

            ctx.rebind("BANQUE", banque);

        } catch (RemoteException | NamingException e) {
            System.out.println(e);
        }
    }
}
