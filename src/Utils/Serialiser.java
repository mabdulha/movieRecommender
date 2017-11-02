package Utils;

public interface Serialiser {
	void push (Object o);
	Object pop();
	void write() throws Exception;
	void read() throws Exception;
}
