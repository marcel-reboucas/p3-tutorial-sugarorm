package br.ufpe.cin.mscr.sugarormexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.ufpe.cin.mscr.sugarormexample.model.Contact;


public class ContantListActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.AddressBook.MESSAGE";

    private ListView obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contant_list);

        List<Contact> contacts = Contact.listAll(Contact.class);

        ArrayAdapter arrayAdapter =
                new ArrayAdapter(this,android.R.layout.simple_list_item_1, contacts);

        //adding it to the list view.
        obj = (ListView)findViewById(R.id.contactListView);
        obj.setAdapter(arrayAdapter);

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub

                Contact contact = ((ArrayAdapter<Contact>) parent.getAdapter()).getItem(position);
                Bundle dataBundle = new Bundle();
                dataBundle.putLong("id", contact.getId());
                Intent intent = new Intent(getApplicationContext(),DisplayContactActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contant_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.item1:
                Bundle dataBundle = new Bundle();
                dataBundle.putLong("id", 0);
                Intent intent = new Intent(getApplicationContext(),DisplayContactActivity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }
}
