public  interface sellable {
    /** returns a descriptions of objects*/
    public String descriptions();
    /** returns the list price in cents*/
    public int listPrice();

    /** returns the lowest price in cents we will accept*/
    public int lowestPrice();

}



