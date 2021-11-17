public enum Product {
    COKE(10000), PEPSI(10000), SODA(20000);
    private int value;
    private Product(int value){
        this.value=value;
    };
    public int getValue(){
        return this.value;
    }
}
