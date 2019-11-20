package mastermind;
//@author edwardsdw
public interface Game  {
    public static int guesses = 0;
    public void sMaster(); //should set the master set
    public void sGuess(); //should set the guess set
    public int test(); //should test guess set against master set and return the response OR simply return the response
    public void update(int response);  //should update guess pools based on response and keep track of guesses
}
