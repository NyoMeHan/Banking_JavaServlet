package exception;

public class TransactionAbortedException  extends Exception {

	public TransactionAbortedException() {
		super("Your Transaction have been aborted!");
		
	}

	public TransactionAbortedException(String message) {
		super(message);
		
	}

}
