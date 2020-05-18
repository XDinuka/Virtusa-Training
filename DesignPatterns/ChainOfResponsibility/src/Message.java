import java.util.ArrayList;

public class Message {

    private String text;
    private ArrayList<String> receivers;
    private Integer messageScope;

    public Message() {
        receivers = new ArrayList<>();
        messageScope = MessageScope.SYSTEM_ADMIN;
    }

    private static MessageHandler messageHandler;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getReceivers() {
        return receivers;
    }

    public Integer getMessageScope() {
        return messageScope;
    }

    public void setMessageScope(Integer messageScope) {
        if(messageScope>MessageScope.SYSTEM_ADMIN || messageScope<MessageScope.STUDENT){
            throw new RuntimeException("Invalid Message Scope "+messageScope);
        }

        this.messageScope = messageScope;
    }


    static {


        MessageHandler systemAdminMessageHandler = new MessageHandler() {
            @Override
            public void addReceivers(Message message) {
                message.getReceivers().addAll(ReceiversDB.getSystemAdmins());
                if (message.getMessageScope() < MessageScope.SYSTEM_ADMIN) {
                    successor.addReceivers(message);
                }
            }
        };
        MessageHandler principalMessageHandler = new MessageHandler() {
            @Override
            public void addReceivers(Message message) {
                message.getReceivers().addAll(ReceiversDB.getPrincipals());
                if (message.getMessageScope() < MessageScope.PRINCIPAL) {
                    successor.addReceivers(message);
                }
            }
        };
        MessageHandler sectionalHeadMessageHandler = new MessageHandler() {
            @Override
            public void addReceivers(Message message) {
                message.getReceivers().addAll(ReceiversDB.getSectionalHeads());
                if (message.getMessageScope() < MessageScope.SECTIONAL_HEAD) {
                    successor.addReceivers(message);
                }
            }
        };
        MessageHandler teacherMessageHandler = new MessageHandler() {
            @Override
            public void addReceivers(Message message) {
                message.getReceivers().addAll(ReceiversDB.getTeachers());
                if (message.getMessageScope() < MessageScope.TEACHER) {
                    successor.addReceivers(message);
                }
            }
        };
        MessageHandler studentMessageHandler = new MessageHandler() {
            @Override
            public void addReceivers(Message message) {
                message.getReceivers().addAll(ReceiversDB.getStudents());
            }
        };

        systemAdminMessageHandler.setSuccessor(principalMessageHandler);
        principalMessageHandler.setSuccessor(sectionalHeadMessageHandler);
        sectionalHeadMessageHandler.setSuccessor(teacherMessageHandler);
        teacherMessageHandler.setSuccessor(studentMessageHandler);

        messageHandler = systemAdminMessageHandler;
    }


    public static void send(Message message) {
        messageHandler.addReceivers(message);
        message.getReceivers().stream().forEach(s -> System.out.println(message.getText()+" sent to "+s));
    }
}
