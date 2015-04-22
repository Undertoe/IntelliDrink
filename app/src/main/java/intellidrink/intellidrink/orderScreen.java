package intellidrink.intellidrink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import IntelliDrinkDB.LocalDatabaseHelper;
import IntelliDrinkDB.ServerDatabase;


public class orderScreen extends ActionBarActivity {

    ImageButton orderButton;
    ImageButton backButton;

    ImageView drinkImage;

    TextView drinkTitle;
    TextView drinkDescription;
    TextView ingredients;

    Button searchButton;
    EditText searchEditText;

    ListView drinkListView;
    String[] tmpList = {"tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp"};


    ServerDatabase database;
    LocalDatabaseHelper localDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_order_screen);

        orderButton = (ImageButton) findViewById(R.id.orderButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        drinkImage = (ImageView) findViewById(R.id.drinkPictureImage);

        drinkTitle = (TextView) findViewById(R.id.drinkNameTextfield);
        drinkDescription = (TextView) findViewById(R.id.drinkDescriptionTextField);
        ingredients = (TextView) findViewById(R.id.drinkIngredientsTextField);

        searchButton = (Button) findViewById(R.id.searchButton);
        searchEditText = (EditText) findViewById(R.id.searchEditText);


        drinkListView = (ListView) findViewById(R.id.drinkListView);
        ArrayAdapter<String> tmpAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, tmpList);
        drinkListView.setAdapter(tmpAdapter);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void onClickOrderScreen(View v)
    {
        if(v.getId() == R.id.orderButton)
        {
            //ErrorAlert e = new ErrorAlert(this);
            //Toast.makeText(this, "ordering Drink", Toast.LENGTH_SHORT).show();
            confirmationDialog();
            //e.showErrorDialog("NYI", "This event is not implemented yet");
        }
        else if(v.getId() == R.id.backButton)
        {
            Intent i = new Intent(this, CustomerTabActivity.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.searchButton)
        {
            ErrorAlert e = new ErrorAlert(this);
            e.showErrorDialog("NYI", "This event is not implemented yet");
        }
        else
        {
            Toast.makeText(this, "Shits broken yo", Toast.LENGTH_SHORT);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void confirmationDialog()
    {
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                orderScreen.this);

        alertDialog2.setTitle("Drink Confirmation");

        //TODO: ADD IN THE DRINK NAME TO THE STRING
        //TODO: ADD IN CHARGE TO YOUR ACCOUNT STRING
        alertDialog2.setMessage("Are you sure you want this drink?");

        //TODO: SET THIS PICTURE TO THE ID OF THE DRINK
        //alertDialog2.setIcon(R.drawable.delete);

        alertDialog2.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        drinkMixing(true);
                    }
                });
        alertDialog2.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        drinkMixing(false);
                        dialog.cancel();
                    }
                });
        alertDialog2.show();
    }

    void drinkMixing(boolean confirmation)
    {
        if(confirmation)
        {
            Toast.makeText(this, "Drink Made", Toast.LENGTH_SHORT).show();
            wouldYouLikeAnotherDialog();
        }
        else
        {
            Toast.makeText(this, "Drink NOT Made", Toast.LENGTH_SHORT).show();
        }
    }

    void wouldYouLikeAnotherDialog()
    {
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                orderScreen.this);

        alertDialog2.setTitle("Moar???");

        //TODO: ADD IN THE DRINK NAME TO THE STRING
        //TODO: ADD IN CHARGE TO YOUR ACCOUNT STRING
        alertDialog2.setMessage("Would you like another drink?");

        //TODO: SET THIS PICTURE TO THE ID OF THE DRINK
        //alertDialog2.setIcon(R.drawable.delete);

        alertDialog2.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog2.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), MainScreen.class);
                        startActivity(i);
                        dialog.cancel();
                    }
                });
        alertDialog2.show();
    }

    public void loadDBInfo(LocalDatabaseHelper localDB, ServerDatabase DB)
    {
        this.localDataBase = localDB;
        this.database = DB;
    }

}
