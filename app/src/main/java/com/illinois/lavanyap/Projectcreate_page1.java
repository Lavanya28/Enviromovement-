package  com.illinois.lavanyap;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Projectcreate_page1 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectcreate);
        final SQLiteDatabase mydatabase3 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        //final EditText projectid = (EditText)findViewById(R.id.c_projectid);

        final EditText projectname = (EditText)findViewById(R.id.c_projectname);

        // EditText resourcetype = (EditText)findViewById(R.id.c_resourcetype);

        final EditText motivation = (EditText)findViewById(R.id.c_motivation);

        final EditText metrics = (EditText)findViewById(R.id.c_metrics);

        //final EditText active = (EditText)findViewById(R.id.c_active);

        final EditText total = (EditText)findViewById(R.id.c_total);

        Button create = (Button) findViewById(R.id.createprojectbutton);

        Bundle b = this.getIntent().getExtras();
        final String user = "'"+b.getString("username")+"'";

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pid ="00000";
                String pname = "'"+ projectname.getText().toString()+ "'";
                String rtype = "Plastic";
                String motivate = "'"+ motivation.getText().toString()+ "'";
                String metric = "'"+ metrics.getText().toString()+ "'";
                String activ ="True";
                String tot = "'"+ total.getText().toString()+ "'";
                Integer int_total = Integer.parseInt(total.getText().toString());


                //Insert values in table Project in database here
                String Query = "INSERT INTO Project (ProjectID,ProjectName, ResourceType, Motivation, Metrics, Active, Total) VALUES ("+ pid+" , "+pname+" , "+rtype+" , "+motivate+" , " +metric+" , "+activ+" , "+tot+")";
                mydatabase3.execSQL(Query);


                String Query2 = "INSERT INTO ProfileTable VALUES (" + user + " ,"+ pid +  " ," +tot + " ," + tot +")" ;
                mydatabase3.execSQL(Query2);





                    Intent startIntent = new Intent(Projectcreate_page1.this.getApplicationContext(), User_Profile.class);
                    Projectcreate_page1.this.startActivity(startIntent);


            }
        });



    }

}



