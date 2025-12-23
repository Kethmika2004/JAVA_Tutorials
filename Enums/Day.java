public enum Day {
    //Enum constant
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private final int dayNum;

    Day(int i){
        this.dayNum = i;
    }

    public int getNumber(){
        return this.dayNum;
    }
}
