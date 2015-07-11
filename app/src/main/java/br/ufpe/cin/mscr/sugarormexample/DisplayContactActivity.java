package br.ufpe.cin.mscr.sugarormexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpe.cin.mscr.sugarormexample.model.Contact;


public class DisplayContactActivity extends ActionBarActivity {

    TextView name ;
    TextView phone;
    Contact currentContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            long id = extras.getLong("id");
            if(id>0){

               currentContact = Contact.findById(Contact.class, id);

                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                name.setText(currentContact.getName());
                name.setFocusable(false);
                name.setClickable(false);

                phone.setText(currentContact.getPhone());
                phone.setFocusable(false);
                phone.setClickable(false);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            long id = extras.getLong("id");
            if(id>0){
                getMenuInflater().inflate(R.menu.menu_display_contact, menu);
            }
            else{
                getMenuInflater().inflate(R.menu.menu_contant_list, menu);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteMessage)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                currentContact.delete();
                                Toast.makeText(getApplicationContext(), "Contato removido com sucesso.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ContantListActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Confirma?");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void run(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            long id = extras.getLong("id");
            if(id>0){
                currentContact.setName(name.getText().toString());
                currentContact.setPhone(phone.getText().toString());

                currentContact.save();
                Toast.makeText(getApplicationContext(), "Atualizado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ContantListActivity.class);
                startActivity(intent);
            }
            else{
                Contact novoContato = new Contact(name.getText().toString(), phone.getText().toString());
                novoContato.save();
                Toast.makeText(getApplicationContext(), "Novo contato criado!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ContantListActivity.class);
                startActivity(intent);
            }
        }
    }
}
