package com.dave.ssh;

import com.jcraft.jsch.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by David on 29/10/2017.
 */
public class SSHConnection {
    public static void main(String[] arg) {
        Session session = null;
        ChannelSftp c = null;
        Channel channel = null;
        try {
            JSch jsch = new JSch();

            String user = "David";
            String host = "localhost";
            int port = 22;
            String privateKey = "d:\\Development\\SSH-keys\\new\\ssh_host_rsa_key";
            String known_hosts = "localhost ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCiX9PGNbY9BO19maIVn/npQS/z/UeFdx+ffbewkGsidyKY3LHL//rzVslhiIHKF/itq70jgOVe0YysAngrcyCaPxUczjGPv91j6h8qEbNIX7fWmmGoy7bsiFn9meTeZG+0ab84tdQXimEW8madhgLglf4PY3PBlguuxAvl3apEkix9DSWI4i9ZGrGB/8JBMB+Km5xw9yifutqndhua/U9sKnzk1g4qIXHF1/ZpCdJRNmQ6mOzP//UiMVCjPP/wnSbNmFssAyfXPcO0opl52acKfBddOUKb6KJL58dd/aILaqsYaTnQruNoNjlYP5dVjw4k8ogWRdvHYThyzlrBRuAf";

            String absoluteFilePathPrivatekey = null;
            File tmpFileObject = new File(privateKey);
            if (tmpFileObject.exists() && tmpFileObject.isFile())
            {
                absoluteFilePathPrivatekey = tmpFileObject.getAbsolutePath();
            }

            jsch.setKnownHosts(new ByteArrayInputStream(known_hosts.getBytes()));
            jsch.addIdentity(absoluteFilePathPrivatekey);
            System.out.println("identity added ");

            session = jsch.getSession(user, host, port);
            System.out.println("session created.");
//            session.setConfig("StrictHostKeyChecking", "no");
            // disabling StrictHostKeyChecking may help to make connection but makes it insecure
            // see http://stackoverflow.com/questions/30178936/jsch-sftp-security-with-session-setconfigstricthostkeychecking-no
            //
//             java.util.Properties config = new java.util.Properties();
//             config.put("StrictHostKeyChecking", "no");
//             session.setConfig(config);

            session.connect();
            System.out.println("session connected.....");

            channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            System.out.println("shell channel connected....");

            c = (ChannelSftp) channel;

//            c.cd("d:\\aaa");
//            c.put(new ByteArrayInputStream(absoluteFilePathPrivatekey.getBytes(StandardCharsets.UTF_8)), "d:\\temp\\aaa");
            c.put(privateKey, tmpFileObject.getName(), ChannelSftp.OVERWRITE);
//            c.put(new FileInputStream(tmpFileObject), tmpFileObject.getName(), ChannelSftp.OVERWRITE);

            c.get("test.txt",".\\transferedFile.txt");
            System.out.println("done");

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            c.exit();
            channel.disconnect();
            session.disconnect();
        }
    }
}
