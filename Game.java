package mastermind;
//@author edwardsdw
public interface Game  {
    public static int guesses = 0;
    public static String[] responses = new String{"", "No colors are correct.", "", "Some colors are correct, but none are in the correct position.", "", "All colors are correct, but not all of them are in the correct position.", "", "Some colors are correct and in the right position.", "", "The set is correct."};
    public void sMaster(); //should set the master set
    public void sGuess(int response); //should set the guess set
    public int test(); //should test guess set against master set and return the response OR simply return the response
    public void update(int response);  //should update guess pools based on response and keep track of guesses
}
