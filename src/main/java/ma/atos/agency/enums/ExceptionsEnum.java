package ma.atos.agency.enums;

public enum ExceptionsEnum {
    PRIVILEGE_NOT_FOUND("Le privilege que vous recherchez est introuvable"),
    ROLE_NOT_FOUND("Le role que vous recherchez est introuvable"),
    CLIENT_NOT_FOUND("Le client que vous recherchez est introuvable"),

    PRIVILEGE_LIST_EMPTY("La liste Des Privileges est vide"),

    INVALID_PRIVILEGE_NAME("Le nom du privilege ne correspond pas aux noms du parametrage"),

    ROLE_LIST_EMPTY("La liste Des Roles est vide"),

    INVALID_ROLE_NAME("Le nom du role ne correspond pas aux noms du parametrage"),












    ;

    private String message;
    ExceptionsEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
