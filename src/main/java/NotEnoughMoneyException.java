public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("Недостаточно средств на счете");
    }
}
