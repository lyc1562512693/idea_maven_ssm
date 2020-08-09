package socketV3;

public class Message {

	private int dataType;
	private long dataLen;
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public long getDataLen() {
		return dataLen;
	}

	public void setDataLen(long dataLen) {
		this.dataLen = dataLen;
	}

	@Override
	public String toString() {
		return "Message [dataType=" + dataType + ", dataLen=" + dataLen + ", Content=" + Content + "]";
	}

	
	
}
