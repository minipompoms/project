package project;

public class InvalidConnectionException extends RuntimeException {

	public InvalidConnectionException()
	{
		super("Exception Occured: unable to connect to file.");
	}
}
