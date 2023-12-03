package edu.hw6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;

public class PortScanner {
    private PortScanner() {
    }

    private static final int MAX_PORTS = 49152;

    public static void scanPorts() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int port = 1; port < MAX_PORTS; port++) {
            try {
                (new Socket("localhost", port)).close();
                printPort(port, writer);
            } catch (IOException ignored) {
            }
        }

        writer.flush();
    }

    private static void printPort(int port, BufferedWriter writer) throws IOException {
        String str;

        if (PORTS.containsKey(port)) {
            str = String.format("%d\t\t\t%s\n", port, PORTS.get(port));
            writer.write(str);
        } else {
            str = String.format("%d\t\t\tTCP/UDP\n", port);
            writer.write(str);
        }
    }

    private final static Map<Integer, String> PORTS = Map.<Integer, String>ofEntries(
            Map.entry(7, "TCP/UDP\t\t\tEcho service"),
            Map.entry(20, "TCP\t\t\tFile Transfer Protocol (FTP) - data transfer"),
            Map.entry(21, "TCP/UDP\t\t\tFile Transfer Protocol (FTP) - control connection"),
            Map.entry(22, "TCP/UDP\t\t\tSecure Shell (SSH), secure logins,"
                    + "file transfers (scp, sftp), and port forwarding"),
            Map.entry(23, "TCP\t\t\tTelnet protocol—unencrypted text communications"),
            Map.entry(25, "TCP\t\t\tSimple Mail Transfer Protocol, used for email routing between mail servers"),
            Map.entry(53, "TCP/UDP\t\t\tDomain Name System (DNS) name resolver"),
            Map.entry(69, "UDP\t\t\tTrivial File Transfer Protocol (TFTP)"),
            Map.entry(80, "TCP/UDP\t\t\tHypertext Transfer Protocol (HTTP versions 1.x and 2.)"),
            Map.entry(88, "TCP/UDP\t\t\tKerberos (Network authentication system)"),
            Map.entry(102, "TCP\t\t\tISO Transport Service Access Point (TSAP) Class 0 protocol"),
            Map.entry(110, "TCP\t\t\tPost Office Protocol, version 3 (POP3)"),
            Map.entry(135, "TCP/UDP\t\t\tMicrosoft EPMAP (End Point Mapper)"),
            Map.entry(137, "TCP/UDP\t\t\tNetBIOS Name Service, used for name registration and resolution"),
            Map.entry(139, "TCP/UDP\t\t\tNetBIOS Session Service"),
            Map.entry(143, "TCP/UDP\t\t\tInternet Message Access Protocol (IMAP),"
                    + "management of electronic mail messages on a server"),
            Map.entry(381, "TCP/UDP\t\t\tHP data alarm manager"),
            Map.entry(383, "TCP/UDP\t\t\tHP performance data collector"),
            Map.entry(443, "TCP/UDP\t\t\tHTTP over SSL (HTTPS)"),
            Map.entry(464, "TCP/UDP\t\t\tKerberos Change/Set password"),
            Map.entry(465, "TCP\t\t\tSMTP over TLS/SSL, SSM"),
            Map.entry(587, "TCP\t\t\tSMTP (Email message submission)"),
            Map.entry(593, "TCP/UDP\t\t\tMicrosoft DCOM"),
            Map.entry(636, "TCP/UDP\t\t\tLDAP over TLS/SSL"),
            Map.entry(691, "TCP\t\t\tMS Exchange Routing"),
            Map.entry(902, "_\t\t\tVMware ESXi"),
            Map.entry(989, "TCP/UDP\t\t\tFTPS Protocol (data), FTP over TLS/SSL"),
            Map.entry(990, "TCP/UDP\t\t\tFTPS Protocol (control), FTP over TLS/SSL"),
            Map.entry(993, "TCP\t\t\tInternet Message Access Protocol 4 over TLS/SSL (IMAPS)"),
            Map.entry(995, "TCP/UDP\t\t\tPost Office Protocol 3 (POP3) over TLS/SSL"),
            Map.entry(1025, "TCP\t\t\tMicrosoft RPC"),
            Map.entry(1194, "TCP/UDP\t\t\tOpenVPN"),
            Map.entry(1337, "-\t\t\tWASTE Encrypted File Sharing Program"),
            Map.entry(1589, "TCP/UDP\t\t\tCisco VLAN Query Protocol (VQP)"),
            Map.entry(1725, "UDP\t\t\tValve Steam Client"),
            Map.entry(2082, "-\t\t\tcPanel default"),
            Map.entry(2083, "TCP/UDP\t\t\tSecure RADIUS Service (radsec), cPanel default SSL"),
            Map.entry(2483, "TCP/UDP\t\t\tOracle database listening for"
                    + "insecureclient connections to the listener, replaces port 1521"),
            Map.entry(2484, "TCP/UDP\t\t\tOracle database listening for SSL client connections to the listener"),
            Map.entry(2967, "TCP/UDP\t\t\tSymantec System Center agent (SSC-AGENT)"),
            Map.entry(3074, "TCP/UDP\t\t\tXbox LIVE and Games for Windows – Live"),
            Map.entry(3306, "TCP\t\t\tMySQL database system"),
            Map.entry(3724, "TCP/UDP\t\t\tSome Blizzard games, Unofficial Club Penguin Disney online game for kids"),
            Map.entry(4664, "-\t\t\tGoogle Desktop Search"),
            Map.entry(5432, "TCP\t\t\tPostgreSQL database system"),
            Map.entry(5900, "TCP/UDP\t\t\tVirtual Network Computing (VNC) Remote Frame Buffer RFB protocol"),
            Map.entry(6665, "TCP\t\t\tInternet Relay Chat"),
            Map.entry(6666, "TCP\t\t\tInternet Relay Chat (IRC)"),
            Map.entry(6667, "TCP\t\t\tInternet Relay Chat - IRC"),
            Map.entry(6668, "TCP\t\t\tIRC (Internet Relay Chat)"),
            Map.entry(6669, "TCP\t\t\tIRC - Internet Relay Chat"),
            Map.entry(6881, "-\t\t\tBitTorrent"),
            Map.entry(6970, "-\t\t\tQuickTime Streaming Server"),
            Map.entry(6999, "-\t\t\tBitTorrent, part of the full range of ports used most often"),
            Map.entry(8086, "TCP\t\t\tKaspersky - AV Control Center"),
            Map.entry(8087, "TCP\t\t\tKaspersky AV Control Center"),
            Map.entry(8222, "TCP/UDP\t\t\tVMware Server Management User Interface (insecure Web interface)"),
            Map.entry(9100, "TCP\t\t\tPDL Data Stream, used for printing to certain network printers"),
            Map.entry(10000, "-\t\t\tBackupExec - Webmin, Web-based Unix/Linux system"
                    + "administration tool (default port)"),
            Map.entry(12345, "-\t\t\tNetBus remote administration tool (often Trojan horse)"),
            Map.entry(27374, "-\t\t\tSub7 default"),
            Map.entry(31337, "-\t\t\tBack Orifice 2000 remote administration tools")
    );
}
