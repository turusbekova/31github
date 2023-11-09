package API.dataProviders;

public enum URI {
    USERS("/users"),
    EDITUSERS("/edituser"),
    CREATEUSER("/usersignup"),
    DELETEUSER("/deleteuser"),
    ;
    public final String endpoints;

    private URI(String endpoints) {
        this.endpoints = endpoints;
    }
}
