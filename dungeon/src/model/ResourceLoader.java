package model;

import java.io.File;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * a class with static methods to load all the ressources from the server
 * @author quentin
 *
 */
public class ResourceLoader {

	private static final String PATHSEPARATOR = "/";
	private static boolean loaded;
	private static boolean working;
	private static ChannelSftp channelSftp;
	private static JSch jsch = new JSch();
    private static Session session = null;
	
	public static boolean isLoaded() {
		return loaded;
	}

	public static void setLoaded(boolean loaded) {
		ResourceLoader.loaded = loaded;
	}

	/**
	 * load the resources only if it's not already doing it
	 */
	public static void loadResource () {
		
		loaded = false;
		
		if (!working) {
		
			try {
	        	
	        	working = true;
	        	
	            session = jsch.getSession("donjon-poo", "ftp.xebot.fr", 22);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword("donjon");
	            session.connect();

	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            channelSftp = (ChannelSftp) channel;
	            
	            recursiveFolderDownload("Resources", "Resources");
	            setLoaded(true);
	            
	            channelSftp.exit();
	            session.disconnect();
	            
	            working = false;
	            
	        }catch (Exception exception) {
	        	
	        }
			
		}
		
	}
	
	/**
     * This method is called recursively to download the folder content from SFTP server
     * it's checking whether the tree is already existing in the local computer
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
