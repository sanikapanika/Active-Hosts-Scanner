import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActiveHosts {
    public static void main(String[] args) {
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            while(nis.hasMoreElements())
            {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration ias = ni.getInetAddresses();
               while (ias.hasMoreElements()) {

                       InetAddress ia = (InetAddress) ias.nextElement();
                   if (ni.getName().contains("wlp")) {
                       System.out.println(ia.getHostAddress());
                   }
               }


            }
        } catch (SocketException ex) {
            Logger.getLogger(ActiveHosts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
