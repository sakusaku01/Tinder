package kg.megacom.miniTinder.models;

public class Orders {
    private Long id;
    private Users senderId;
    private Users recipientId;

    private String message;
    private boolean match;

    public Orders() {
    }

    public Orders(Users senderId, Users recipientId, boolean match,String message) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.match = match;
        this.message=message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getSenderId() {
        return senderId;
    }

    public void setSenderId(Users senderId) {
        this.senderId = senderId;
    }

    public Users getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Users recipientId) {
        this.recipientId = recipientId;
    }

    public boolean getMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "\nOrderId= " + id +"\n"+
                "SenderId: " + senderId +
                "RecipientId: " + recipientId +
                "Message: " + message +"\n"+
                "Match: " + match ;
    }
}
