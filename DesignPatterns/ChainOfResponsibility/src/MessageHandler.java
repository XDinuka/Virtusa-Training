public abstract class MessageHandler {

    protected MessageHandler successor;

    public void setSuccessor(MessageHandler successor) {
        this.successor = successor;
    }

    public abstract void addReceivers(Message message);
}
