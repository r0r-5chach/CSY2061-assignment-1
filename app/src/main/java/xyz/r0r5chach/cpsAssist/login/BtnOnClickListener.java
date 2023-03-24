package xyz.r0r5chach.cpsAssist.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import xyz.r0r5chach.cpsAssist.ArrayTools;
import xyz.r0r5chach.cpsAssist.notes.NotesActivity;

/**
 * This Class defines the definition of the OnCLickListener for the LoginActivity
 * @author r0r5chach
 */
public class BtnOnClickListener implements View.OnClickListener{
    /**
     * This attribute stores the amount of attempts the user has currently taken
     */
    private int currentAttempts;
    /**
     * This attribute stores the View for the username field of the UI
     */
    private final EditText usernameField;
    /**
     * This attribute stores the View for the password field of the UI
     */
    private final EditText passwordField;
    /**
     * This attribute stores a list of users' usernames and password
     */
    private String[][] users;
    /**
     * This Constructor initialises the attributes for the Listener
     * @param usernameField the View for the username field of the UI
     * @param passwordField the View for the password field of the UI
     */
    public BtnOnClickListener(EditText usernameField, EditText passwordField, String users) {
        initUsers(users);
        this.currentAttempts = 0;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }
    /**
     * This method defines what happens when Object this Listener is assigned to is clicked
     * @param view The Activity the Object is from
     */
    @Override
    public void onClick(View view) {
        String[] inputs = new String[]{usernameField.getText().toString(), passwordField.getText().toString()};
        String valid = isValid(inputs);
        if (!valid.equals("true")) {
            Toast.makeText(view.getContext(), valid, Toast.LENGTH_LONG).show();
        }

        if (isUser(inputs)) {
            Intent home = new Intent(view.getContext(), NotesActivity.class);
            home.putExtra("username", inputs[0]);
            view.getContext().startActivity(home);
            Activity login = (Activity) view.getContext();
            login.finish();
        }
        else {
            currentAttempts += 1;
            Toast.makeText(view.getContext(), "Incorrect Username/Password!", Toast.LENGTH_LONG).show();
        }
    }
    /**
     * This method initializes the users array from the activity properties
     */
    private void initUsers(String usersString) {
        String[] users = usersString.split("%");
        this.users = new String[users.length][2];
        for (int i = 0; i < users.length; i++) {
            String[] details = users[i].split("#");
            this.users[i][0] = details[0];
            this.users[i][1] = details[1];
        }
    }
    /**
     * This method checks to see if the user has no attempts left
     * @param attempts the current attempts the user has had
     * @return true if the attempts is less than MAX_ATTEMPTS; false otherwise
     */
    private boolean hasNoAttempts(int attempts) {
        int MAX_ATTEMPTS = 3;
        return attempts >= MAX_ATTEMPTS;
    }

    /**
     * This method checks to see if the details the user has inputted are valid
     * @param inputs The details to be checked
     * @return "true" if the details are valid; A String containing the error message otherwise
     */
    private String isValid(String[] inputs) {
        String errorMsg = "Username and/or Password Fields ";
        if (ArrayTools.isEmpty(inputs)) {
            return errorMsg + "are empty!";
        }
        else if (ArrayTools.hasInvalidChars(inputs)) {
            return errorMsg + "have invalid characters!";
        }
        else if (hasNoAttempts(currentAttempts)) {
            return "No more Login Attempts!";
        }
        return "true";
    }
    /**
     * This method checks to see if the details the user has inputted match with any existing user
     * @param inputs The details to be checked
     * @return true if the user exists; false otherwise
     */
    private boolean isUser(String[] inputs) {
        for (String[] user: users) {
            if (inputs[0].equals(user[0]) || inputs[1].equals(user[1])) {
                return true;
            }
        }
        return false;
    }
}