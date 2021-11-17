public enum AcceptNote {
    VAL0(0), VAL1(10000),VAL2(20000),VAL3(50000),VAL4(100000),VAL5(200000);
    private int value;
    private AcceptNote(int value){
        this.value=value;
    };
    public int getValue(){
        return this.value;
    };
}
