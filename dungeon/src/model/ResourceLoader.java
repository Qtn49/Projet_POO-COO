package model;

import java.io.File;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ResourceLoader {

	private static final String PATHSEPARATOR = "/";
	public static boolean loaded;
	private static ChannelSftp channelSftp;
	
	public static void loadResource () {
		
		JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("donjon-poo", "ftp.xebot.fr", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("donjon");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            
            recursiveFolderDownload("Resources", "Resources");
            loaded = true;
            System.out.println("Loaded !");
            
            channelSftp.exit();
            session.disconnect();
            
        }catch (Exception exception) {
        	
        }
		
	}
	
	/**
     * This method is called recursively to download the folder content from SFTP server
     * 
     * @param sourcePath
     * @param destinationPath
     * @throws SftpException
     */
    @SuppressWarnings("unchecked")
    private static void recursiveFolderDownload(String sourcePath, String destinationPath) throws SftpException {
        Vector<ChannelSftp.LsEntry> fileAndFolderList = channelSftp.ls(sourcePath); // Let list of folder content
        
        new File(destinationPath).mkdir();
        
        //Iterate through list of folder content
        for (ChannelSftp.LsEntry item : fileAndFolderList) {
             
            if (!item.getAttrs().isDir()) { // Check if it is a file (not a directory).
                if (!(new File(destinationPath + PATHSEPARATOR + item.getFilename())).exists()
                        || (item.getAttrs().getMTime() > Long
                                .valueOf(new File(destinationPath + PATHSEPARATOR + item.getFilename()).lastModified()
                                        / (long) 1000)
                                .intValue())) { // Download only if changed later.
 
                    new File(destinationPath + PATHSEPARATOR + item.getFilename());
                    channelSftp.get(sourcePath + PATHSEPARATOR + item.getFilename(),
                            destinationPath + PATHSEPARATOR + item.getFilename()); // Download file from source (source filename, destination filename).
                }
            } else if (!(".".equals(item.getFilename()) || "..".equals(item.getFilename()))) {
                new File(destinationPath + PATHSEPARATOR + item.getFilename()).mkdirs(); // Empty folder copy.
                recursiveFolderDownload(sourcePath + PATHSEPARATOR + item.getFilename(),
                        destinationPath + PATHSEPARATOR + item.getFilename()); // Enter found folder on server to read its contents and create locally.
            }
        }
    }
	
}
