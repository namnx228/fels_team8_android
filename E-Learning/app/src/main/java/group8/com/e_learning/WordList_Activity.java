package group8.com.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.network.EConnect;


public class WordList_Activity extends AppCompatActivity
        implements EConnect.OnConnected {
    private JSONObject jsonObject;
    Spinner spLevel, spStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list_);
        //   Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_actionBar);
        // setSupportActionBar(myToolbar);

        //new EConnect(this).execute(Constant.API_WORD);
        hanglerJsonObject();
        initSpiner();
    }

    private void initSpiner() {
        spLevel = (Spinner) findViewById(R.id.sp_level);
        spStatus = (Spinner) findViewById(R.id.sp_status);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.level_array, R.layout.spinner_item);
        spLevel.setAdapter(adapter);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.status_array, R.layout.spinner_item);
        spStatus.setAdapter(adapter1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_list_, menu);
        return true;
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.button_next) {
            ;
            Intent intent = new Intent(this, Category_activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    } */


    private void tapPDF() {
        Toast.makeText(this, "Print PDF", Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                finish();
                break;
            case R.id.button_PDF:
                tapPDF();
                break;
        }
    }

    private void hanglerJsonObject()
    {
        try {
            jsonObject = new JSONObject(Constant.API_WORD);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        //code vao day
    }

    @Override
    public void getJson(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        //code vao day de hien thi du lieu nhe.
    }

    private ArrayList<Word> getList() throws JSONException {
        ArrayList<Word> result = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("list");// thay list = tag name cua list trong api nhe
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            //tiep theo lay cac du lieu trong object chuyen vao result nhe
        }
        return result;
    }
}
