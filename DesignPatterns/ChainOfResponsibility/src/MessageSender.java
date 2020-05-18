public abstract class MessageSender {


    public abstract void send(Message message);

    private static MessageSender defaultMessageSender;

    public static MessageSender getDefaultMessageSender() {
        if (defaultMessageSender == null) {
            synchronized (MessageSender.class) {
                if (defaultMessageSender == null) {
                    class DefaultMessageSender extends MessageSender {
                        private MessageHandler messageHandler;

                        DefaultMessageSender() {

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


                        public void send(Message message) {
                            messageHandler.addReceivers(message);
                            message.getReceivers().stream().forEach(s -> System.out.println(message.getText() + " sent to " + s));
                        }
                    }
                    defaultMessageSender = new DefaultMessageSender();
                }
            }
        }
        return defaultMessageSender;
    }


}
