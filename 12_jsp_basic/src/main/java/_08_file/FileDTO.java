package _08_file;

public class FileDTO {

	private String uploader;
	private String originalFileName;
	private String uuid;
	
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String toString() {
		return "FileDTO [uploader=" + uploader + ", originalFileName=" + originalFileName + ", uuid=" + uuid + "]";
	}
	
}
