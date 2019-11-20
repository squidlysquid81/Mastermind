package mastermind;
//@author edwardsdw
public class TwoPlayer implements Game  {
    Set master;
    Set guess;
    public TwoPlayer()  {
        master = new Set();
        guess = new Set();
        sMaster();
    }
}
