package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonMessage;
    private boolean followed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonMessage = findViewById(R.id.btnFollow);
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followed = !followed;
                updateButtonMessageText();

                // Toast Message
                String toastMessage = followed? "Followed": "Unfollowed";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        // Intialize a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get the TextViews and Button from Layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Set the TextViews with the User's name, description, default button message
        tvName.setText(user.name);

        // Display MAD + random integer
        int randomNumber = getIntent().getIntExtra("randomNumber", 0);
        String newName = "MAD " + randomNumber;
        tvName.setText(newName);
        tvDescription.setText(user.description);
        btnFollow.setText(getString(R.string.button_follow_text));



        // Logic to update based on boolean

    }
    private void updateButtonMessageText() {
        if (followed) {
            buttonMessage.setText(R.string.button_unfollow_text);
        } else {
            buttonMessage.setText(R.string.button_follow_text);
        }

    }
}