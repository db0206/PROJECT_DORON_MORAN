package Beans;

public enum Category {
    MOVIES(1),
    RENTAL_GEAR(2),
    NEW_GEAR(3),
    PRODUCTION(4);

    private int id;

    private Category (int id){
        this.id =id;
    }

}
