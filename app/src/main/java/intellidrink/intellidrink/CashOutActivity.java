package intellidrink.intellidrink;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import IntelliDrinkDB.LocalDatabaseHelper;
import IntelliDrinkDB.ServerDatabase;


public class CashOutActivity extends ActionBarActivity {

    Button createNewCustomerButton;
    Button cashOutCustomerButton;
    Button editCustomersTabButton;
    Button editRFIDButton;
    Button editCustomersDetailsButton;
    Button removeCustomerButton;
    Button toggleActiveCustomersButton;
    Button backButton;
    Button orderAsAdminButton;
    Button editPricingButton;

    Button searchButton;
    EditText searchEditText;

    ListView customerListView;
    String[] tmpList = {"tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp", "tmp"};

    TextView customerNameTextEdit;
    TextView customersRFIDTextEdit;
    TextView customersCurrentTabTextEdit;

    ListView tabListView;


    ServerDatabase database;
    LocalDatabaseHelper localDataBase;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_cash_out);

        createNewCustomerButton = (Button) findViewById(R.id.createNewCustomerButton);
        cashOutCustomerButton = (Button) findViewById(R.id.cashOutCustomerButton);
        editCustomersDetailsButton = (Button) findViewById(R.id.editDetailsButton);
        editCustomersTabButton = (Button) findViewById(R.id.editTabButton);
        editRFIDButton = (Button) findViewById(R.id.editRFIDButton);
        removeCustomerButton = (Button) findViewById(R.id.removeCustomerButton);
        orderAsAdminButton = (Button) findViewById(R.id.orderAsAdminButton);
        editPricingButton = (Button) findViewById(R.id.editPricingButton);
        toggleActiveCustomersButton = (Button) findViewById(R.id.toggleActiveCustomersButton);

        backButton = (Button) findViewById(R.id.backButtonCashOutActivity);

        searchButton = (Button) findViewById(R.id.searchForNameButton);
        searchEditText = (EditText) findViewById(R.id.searchForNameEditText);

        customerListView = (ListView) findViewById(R.id.customerListView);
        //TODO FIX THIS ADAPTER
        ArrayAdapter<String> tmpAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, tmpList);
        customerListView.setAdapter(tmpAdapter);

        customerNameTextEdit = (TextView) findViewById(R.id.customerNameTextEdit);
        customersRFIDTextEdit = (TextView) findViewById(R.id.customersRFIDTextEdit);
        customersCurrentTabTextEdit = (TextView) findViewById(R.id.customersCurrentTabTextEdit);

        tabListView = (ListView) findViewById(R.id.tabListViewCashOutActivity);
        //TODO FIX THIS ADAPTER
        tabListView.setAdapter(tmpAdapter);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cash_out, menu);
        return true;
    }

    public void onClickCashOutActivity(View v)
    {
        if(v.getId() == R.id.createNewCustomerButton)
        {

        }
        else if(v.getId() == R.id.cashOutCustomerButton)
        {

        }
        else if(v.getId() == R.id.editDetailsButton)
        {

        }
        else if(v.getId() == R.id.editTabButton)
        {

        }
        else if(v.getId() == R.id.editRFIDButton)
        {

        }
        else if(v.getId() == R.id.removeCustomerButton)
        {

        }
        else if(v.getId() == R.id.toggleActiveCustomersButton)
        {

        }
        else if(v.getId() == R.id.editPricingButton)
        {

        }
        else if(v.getId() == R.id.orderAsAdminButton)
        {

        }
        else if(v.getId() == R.id.backButtonCashOutActivity)
        {
            Intent i = new Intent(this, AdminPanel.class);
            startActivity(i);
        }

        else
        {
            Toast.makeText(this, "Bad button press somewhere", Toast.LENGTH_SHORT);
        }

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

    public void loadDBInfo(LocalDatabaseHelper localDB, ServerDatabase DB)
    {
        this.localDataBase = localDB;
        this.database = DB;
    }
}
